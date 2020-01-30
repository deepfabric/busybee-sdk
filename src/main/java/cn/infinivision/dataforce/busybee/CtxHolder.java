package cn.infinivision.dataforce.busybee;

import io.netty.util.HashedWheelTimer;
import io.netty.util.Timeout;
import io.netty.util.Timer;
import io.netty.util.TimerTask;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import org.apache.commons.pool2.ObjectPool;

/**
 * ctx holder, manager async ctx
 *
 * @author fagongzi
 */
class CtxHolder {
    private static final ObjectPool<TimeoutTask> pool = SimpleBeanPoolFactory.create(TimeoutTask::new);
    private static final TimeUnit TIMEOUT_UNIT = TimeUnit.MILLISECONDS;
    private static final Timer TIMEOUT_TIMER = new HashedWheelTimer(10, TIMEOUT_UNIT);
    private static final Map<Long, Transport.Ctx> ASYNC_CONTENT = new ConcurrentHashMap<>();

    private CtxHolder() {
    }

    /**
     * add ctx
     *
     * @param id
     * @param ctx
     * @param timeout
     */
    public static void add(long id, Transport.Ctx ctx, long timeout) {
        ASYNC_CONTENT.put(id, ctx);
        TIMEOUT_TIMER.newTimeout(getTimeoutTask(id, ctx), timeout, TIMEOUT_UNIT);
    }

    /**
     * remove ctx
     *
     * @param id
     * @return
     */
    public static Transport.Ctx remove(long id) {
        return ASYNC_CONTENT.remove(id);
    }

    public static Transport.Ctx get(long id) {
        return ASYNC_CONTENT.get(id);
    }

    public static void stop() {
        for (Timeout timeout : TIMEOUT_TIMER.stop()) {
            timeout.cancel();
        }
    }

    private static class TimeoutTask implements TimerTask {
        long id;
        TimerTask delegate;

        public TimeoutTask() {
        }

        @Override
        public void run(Timeout timeout) throws Exception {
            if (CtxHolder.remove(id) != null) {
                if (null != delegate) {
                    delegate.run(timeout);
                }
            }
        }
    }

    private static TimeoutTask getTimeoutTask(long id, TimerTask timerTask) {
        TimeoutTask task;

        try {
            task = pool.borrowObject();
        } catch (Exception e) {
            task = new TimeoutTask();
        }

        task.id = id;
        task.delegate = timerTask;
        return task;
    }
}
