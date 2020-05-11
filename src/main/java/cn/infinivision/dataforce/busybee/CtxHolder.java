package cn.infinivision.dataforce.busybee;

import io.netty.util.HashedWheelTimer;
import io.netty.util.Timeout;
import io.netty.util.Timer;
import io.netty.util.TimerTask;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * ctx holder, manager async ctx
 *
 * @author fagongzi
 */
class CtxHolder {
    private static final TimeUnit TIMEOUT_UNIT = TimeUnit.MILLISECONDS;
    private final Timer wheelTimer = new HashedWheelTimer(10, TIMEOUT_UNIT);
    private final Map<Long, Transport.Ctx> contents = new ConcurrentHashMap<>();

    CtxHolder() {
    }

    /**
     * add ctx
     *
     * @param id
     * @param ctx
     * @param timeout
     */
    public void add(long id, Transport.Ctx ctx, long timeout) {
        ctx.timeout = wheelTimer.newTimeout(getTimeoutTask(id, ctx, this), timeout, TIMEOUT_UNIT);
        contents.put(id, ctx);
    }

    /**
     * remove ctx
     *
     * @param id
     * @return
     */
    public Transport.Ctx remove(long id) {
        return contents.remove(id);
    }

    public Transport.Ctx get(long id) {
        return contents.get(id);
    }

    public void stop() {
        for (Timeout timeout : wheelTimer.stop()) {
            timeout.cancel();
        }
    }

    private static class TimeoutTask implements TimerTask {
        long id;
        TimerTask delegate;
        CtxHolder holder;

        public TimeoutTask() {
        }

        @Override
        public void run(Timeout timeout) throws Exception {
            if (holder.remove(id) != null) {
                if (null != delegate) {
                    delegate.run(timeout);
                }
            }
        }
    }

    private static TimeoutTask getTimeoutTask(long id, TimerTask timerTask, CtxHolder holder) {
        TimeoutTask task = new TimeoutTask();
        task.id = id;
        task.delegate = timerTask;
        task.holder = holder;
        return task;
    }
}
