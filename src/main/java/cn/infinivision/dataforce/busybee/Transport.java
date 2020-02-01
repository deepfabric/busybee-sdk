package cn.infinivision.dataforce.busybee;

import cn.infinivision.dataforce.busybee.pb.rpc.Request;
import cn.infinivision.dataforce.busybee.pb.rpc.Response;
import com.google.protobuf.MessageLite;
import io.aicloud.tools.netty.ChannelAware;
import io.aicloud.tools.netty.Connector;
import io.aicloud.tools.netty.ConnectorBuilder;
import io.aicloud.tools.netty.util.NamedThreadFactory;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.util.Timeout;
import io.netty.util.TimerTask;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Consumer;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.pool2.ObjectPool;

/**
 * Transport
 *
 * @author fagongzi
 */
@Slf4j(topic = "busybee")
class Transport implements ChannelAware<MessageLite> {
    private AtomicBoolean running = new AtomicBoolean(false);
    private long workers;
    private AtomicLong ops = new AtomicLong(0);
    private ExecutorService executor;
    private ScheduledExecutorService sharedExecutor = Executors.newSingleThreadScheduledExecutor();
    private EventLoopGroup sharedConnectorEventGroup;
    private List<Connector<MessageLite>> connectors = new ArrayList<>();
    private long timeoutMS;
    private List<BlockingQueue<Ctx>> queues = new ArrayList<>();
    private Ctx stopFlag = new Ctx();
    private ObjectPool<Ctx> pool = SimpleBeanPoolFactory.create(Ctx::new);

    Transport(int workers, int ioExecutors, long timeoutMS) {
        this.workers = workers;
        this.timeoutMS = timeoutMS;
        executor = Executors.newFixedThreadPool(workers, new NamedThreadFactory("busybee-workers"));
        sharedConnectorEventGroup = new NioEventLoopGroup(ioExecutors);

        for (int i = 0; i < workers; i++) {
            queues.add(new LinkedBlockingQueue<>());
        }

        log.info("transport start with {} workers, {} io executors, and {} ms timeout",
            workers,
            ioExecutors);
    }

    void start() {
        if (running.compareAndSet(false, true)) {
            queues.forEach(q -> executor.execute(() -> run(q)));
        }
    }

    void stop() {
        if (running.compareAndSet(true, false)) {
            queues.forEach(q -> q.add(stopFlag));
        }
    }

    void addConnector(String address) {
        Connector<MessageLite> conn = new ConnectorBuilder<MessageLite>(address)
            .allowReconnect(true, 5)
            .channelAware(this)
            .codec(RPCCodec.DEFAULT)
            .executor(sharedExecutor)
            .eventGroup(sharedConnectorEventGroup)
            .build();
        conn.connect();
        connectors.add(conn);
        log.info("connector for {} added", address);
    }

    void sent(Request request, Consumer<Response> cb, Consumer<Throwable> errCB) {
        Ctx ctx;
        try {
            ctx = pool.borrowObject();
        } catch (Exception e) {
            ctx = new Ctx();
        }

        ctx.request = request;
        ctx.cb = cb;
        ctx.errCB = errCB;

        CtxHolder.add(request.getId(), ctx, this.timeoutMS);
        queues.get((int) (ops.incrementAndGet() % workers)).add(ctx);

        log.debug("request-{} added to sent queue", request.getId());
    }

    private void run(BlockingQueue<Ctx> queue) {
        log.info("sent executor started");

        long idx = 0;
        long size = connectors.size();
        List<Ctx> requests = new ArrayList<>(16);
        while (running.get()) {
            try {
                requests.clear();
                Ctx value = queue.take();
                if (value == null) {
                    continue;
                } else if (value == stopFlag) {
                    break;
                }

                requests.add(value);
                queue.drainTo(requests, 15);

                long start = System.currentTimeMillis();
                for (; ; ) {
                    long duration = System.currentTimeMillis() - start;
                    if (duration > this.timeoutMS) {
                        log.warn("sent {} request failed after {} ms, stop retry", requests.size(), duration);
                        break;
                    }

                    Connector<MessageLite> conn = null;
                    for (; ; ) {
                        idx++;
                        conn = connectors.get((int) (idx % size));
                        if (conn.isConnected()) {
                            break;
                        }
                    }

                    boolean failed = false;
                    for (Ctx ctx : requests) {
                        if (!conn.write(ctx.request)) {
                            failed = true;
                            break;
                        }
                    }

                    if (!failed && conn.flush()) {
                        log.debug("sent {} request", requests.size());
                        break;
                    }

                    log.warn("sent {} request failed, retry", requests.size());
                }
            } catch (Throwable e) {
                log.error("sent executor failed", e);
            } finally {
                requests.forEach(ctx -> {
                    try {
                        pool.returnObject(ctx);
                    } catch (Exception e) {
                        log.error("return ctx object to pool failed", e);
                    }
                });

            }
        }

        log.info("sent executor exit");
    }

    @Override
    public void messageReceived(Channel channel, MessageLite message) {
        if (message instanceof Response) {
            Response resp = (Response) message;
            Ctx ctx = CtxHolder.remove(resp.getId());
            if (ctx != null) {
                ctx.done(resp);
                try {
                    pool.returnObject(ctx);
                } catch (Exception e) {
                    // ignore
                }
            }
        } else {
            log.warn("not support message {}", message.getClass().getCanonicalName());
        }
    }

    @Override
    public void onChannelException(Channel channel, Throwable cause) {
        log.error("{} failed with {}", channel, cause);
    }

    @Override
    public void onChannelClosed(Channel channel) {
        log.error("{} closed", channel);
    }

    @Override
    public void onChannelConnected(Channel channel) {
        log.error("{} connected", channel);
    }

    @Getter
    @Setter
    static class Ctx implements TimerTask {
        private Consumer<Response> cb;
        private Consumer<Throwable> errCB;
        private Request request;

        @Override
        public void run(Timeout timeout) throws Exception {
            errCB.accept(new TimeoutException());
        }

        void done(Response resp) {
            cb.accept(resp);
        }
    }

    public static void main(String[] args) {
        Transport t = new Transport(1, 1, 10000);
        t.start();

    }
}
