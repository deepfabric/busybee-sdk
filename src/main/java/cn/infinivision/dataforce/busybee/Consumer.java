package cn.infinivision.dataforce.busybee;

import cn.infinivision.dataforce.busybee.pb.meta.Notify;
import cn.infinivision.dataforce.busybee.pb.rpc.QueueFetchRequest;
import cn.infinivision.dataforce.busybee.pb.rpc.QueueFetchResponse;
import cn.infinivision.dataforce.busybee.pb.rpc.QueueJoinGroupRequest;
import cn.infinivision.dataforce.busybee.pb.rpc.QueueJoinGroupResponse;
import cn.infinivision.dataforce.busybee.pb.rpc.Request;
import cn.infinivision.dataforce.busybee.pb.rpc.Response;
import cn.infinivision.dataforce.busybee.pb.rpc.Type;
import com.google.protobuf.ByteString;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.BiConsumer;
import lombok.extern.slf4j.Slf4j;

/**
 * queue consumer
 * <pre>
 * Date: 2020-03-25
 * Time: 13:58
 * </pre>
 *
 * @author fagongzi
 */
@Slf4j(topic = "busybee")
class Consumer {
    private AtomicBoolean stopped = new AtomicBoolean(false);
    private Client client;
    private long tenantId;
    private String group;
    private ScheduledExecutorService schedulers;
    private BiConsumer<QueueID, Notify> callback;
    private Map<Integer, PartitionFetcher> fetches = new HashMap<>();

    Consumer(Client client, long tenantId, String group,
        BiConsumer<QueueID, Notify> callback,
        ScheduledExecutorService schedulers) {
        this.client = client;
        this.tenantId = tenantId;
        this.group = group;
        this.schedulers = schedulers;
        this.callback = callback;
    }

    void start() {
        doJoin();
    }

    void stop() {
        stopped.set(true);
    }

    void doJoin() {
        if (stopped.get()) {
            return;
        }

        log.debug("tenant {} start join to {}",
            tenantId,
            group);

        client.transport.sent(Request.newBuilder()
            .setId(client.id.incrementAndGet())
            .setType(Type.QueueJoin)
            .setQueueJoin(QueueJoinGroupRequest.newBuilder()
                .setId(tenantId)
                .setGroup(ByteString.copyFromUtf8(group))
                .build())
            .build(), this::onJoinResponse, this::onJoinError);
    }

    void onJoinResponse(Response resp) {
        log.debug("tenant {} join to {}, response {}",
            tenantId,
            group,
            resp);

        QueueJoinGroupResponse joinResp = resp.getJoinResp();
        if (joinResp.getPartitionsCount() == 0) {
            retryJoin();
            return;
        }

        // start partition fetchers
        for (int i = 0; i < joinResp.getPartitionsCount(); i++) {
            int partition = joinResp.getPartitions(i);
            long version = joinResp.getVersions(i);
            fetches.put(partition, new PartitionFetcher(this,
                joinResp.getIndex(), partition, version));
        }

        schedulers.execute(() -> fetches.values().forEach(f -> f.start()));
    }

    void onJoinError(Throwable cause) {
        log.error("tenant " + tenantId + " join to " + group + " failed", cause);
        retryJoin();
    }

    void retryJoin() {
        schedulers.schedule(this::doJoin, 5, TimeUnit.SECONDS);
    }

    synchronized void partitionRemoved(int partition) {
        PartitionFetcher fetcher = fetches.remove(partition);
        if (fetcher == null) {
            return;
        }

        fetcher.stop();
        log.info("{}/{}/{} partition removed",
            tenantId,
            group,
            partition);

        // all partition removed, re-join to group
        if (fetches.size() == 0) {
            log.info("tenant {} all partitions have been removed, re-join {}",
                tenantId,
                group);
            retryJoin();
            return;
        }
    }

    static class PartitionFetcher {
        private Consumer consumer;
        private AtomicBoolean stopped = new AtomicBoolean(false);
        private int index;
        private int partition;
        private long version;
        private long offset;
        private boolean doHB;

        PartitionFetcher(Consumer consumer, int index, int partition, long version) {
            this.consumer = consumer;
            this.index = index;
            this.partition = partition;
            this.version = version;
        }

        void start() {
            log.info("{}/{}/v{} start fetch from partition {} at {}, stopped",
                consumer.tenantId,
                consumer.group,
                version,
                partition,
                offset);

            doFetch();
        }

        void stop() {
            stopped.set(true);
        }

        void doFetch() {
            if (stopped.get()) {
                log.info("{}/{}/v{} fetch from partition {} at {}, stopped",
                    consumer.tenantId,
                    consumer.group,
                    version,
                    partition,
                    offset);
                return;
            }

            log.debug("{}/{}/v{} start fetch from partition {} at {}",
                consumer.tenantId,
                consumer.group,
                version,
                partition,
                offset);

            consumer.client.transport.sent(Request.newBuilder()
                .setId(consumer.client.id.incrementAndGet())
                .setType(Type.FetchNotify)
                .setQueueFetch(QueueFetchRequest.newBuilder()
                    .setId(consumer.tenantId)
                    .setGroup(ByteString.copyFromUtf8(consumer.group))
                    .setConsumer(index)
                    .setVersion(version)
                    .setPartition(partition)
                    .setCompletedOffset(offset)
                    .setCount(consumer.client.opts.fetchCount)
                    .setMaxBytes(consumer.client.opts.fetchBytes)
                    .build())
                .build(), this::onResponse, this::onError);
        }

        void doHeartbeat() {
            if (stopped.get()) {
                return;
            }

            if (doHB) {
                consumer.client.transport.sent(Request.newBuilder()
                    .setId(consumer.client.id.incrementAndGet())
                    .setType(Type.FetchNotify)
                    .setQueueFetch(QueueFetchRequest.newBuilder()
                        .setId(consumer.tenantId)
                        .setGroup(ByteString.copyFromUtf8(consumer.group))
                        .setConsumer(index)
                        .setVersion(version)
                        .setPartition(partition)
                        .setCompletedOffset(offset)
                        .setCount(0)
                        .build())
                    .build(), resp -> retryHB(), cause -> retryHB());
            }
        }

        void onResponse(Response resp) {
            if (resp.hasError() &&
                null != resp.getError().getError() &&
                !resp.getError().getError().isEmpty()) {
                log.error("{}/{}/v{} fetch from partition {} at {} failed",
                    consumer.tenantId,
                    consumer.group,
                    version,
                    partition,
                    offset,
                    resp.getError().getError());
                retryFetch(consumer.client.opts.fetchHeartbeat);
                return;
            }

            QueueFetchResponse fetchResp = resp.getFetchResp();
            if (fetchResp.getRemoved()) {
                log.info("{}/{}/v{} fetch from partition {} at {}, removed",
                    consumer.tenantId,
                    consumer.group,
                    version,
                    partition,
                    offset);
                consumer.partitionRemoved(partition);
                return;
            }

            onFetch(fetchResp);
        }

        void onError(Throwable cause) {
            log.error("{}/{}/v{} fetch from partition {} at {} failed",
                consumer.tenantId,
                consumer.group,
                version,
                partition,
                offset,
                cause);
            retryFetch(consumer.client.opts.fetchHeartbeat);
        }

        void retryFetch(long after) {
            consumer.schedulers.schedule(this::doFetch,
                after, TimeUnit.SECONDS);
        }

        void retryHB() {
            consumer.schedulers.schedule(this::doHeartbeat,
                consumer.client.opts.fetchHeartbeat, TimeUnit.SECONDS);
        }

        void onFetch(QueueFetchResponse resp) {
            if (resp.getItemsCount() == 0) {
                retryFetch(consumer.client.opts.fetchHeartbeat);
                return;
            }

            startHB();
            consumer.client.opts.bizService.execute(() -> {
                long after = consumer.client.opts.fetchHeartbeat;
                try {
                    List<ByteString> items = resp.getItemsList();
                    if (items.size() > 0) {
                        long value = resp.getLastOffset() - items.size() + 1;
                        List<Notify> values = new ArrayList<>();
                        for (ByteString bs : items) {
                            values.add(Notify.parseFrom(bs));
                        }

                        for (Notify nt : values) {
                            consumer.callback.accept(new QueueID(consumer.tenantId, consumer.group, partition, value), nt);
                            offset = value;
                            value++;
                        }

                        after = 0;
                    }
                } catch (Throwable cause) {
                    log.error(consumer.tenantId + "/" + consumer.group + "/v" + version + " fetch from partition " + partition + " at " + offset + " failed",
                        cause);
                } finally {
                    stopHB();
                }

                retryFetch(after);
            });
        }

        void startHB() {
            doHB = true;
            retryHB();
        }

        void stopHB() {
            doHB = false;
        }
    }
}
