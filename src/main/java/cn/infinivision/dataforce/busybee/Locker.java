package cn.infinivision.dataforce.busybee;

import io.netty.util.internal.ConcurrentSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import lombok.extern.slf4j.Slf4j;

/**
 * Distributed locker, not thread safe in current process
 * <pre>
 * Date: 2020-03-28
 * Time: 9:26
 * </pre>
 *
 * @author fagongzi
 */
@Slf4j(topic = "busybee-lock")
class Locker implements Lock {
    private int lease;
    private ThreadLocal<String> ctx = new ThreadLocal<>();
    private Set<String> keeps = new ConcurrentSet<>();
    private Client client;
    private String resource;

    Locker(String resource, Client client, int lease) {
        this.resource = resource;
        this.client = client;
        this.lease = lease;
    }

    @Override
    public void lock() {
        try {
            lock(0, TimeUnit.SECONDS, false);
        } catch (InterruptedException e) {
            throw new IllegalStateException("unexpected: thread interrupted");
        }
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }

        lock(0, TimeUnit.SECONDS, true);
    }

    @Override
    public boolean tryLock() {
        String id = UUID.randomUUID().toString();
        boolean succeed = false;
        try {
            succeed = doLock(id);
        } catch (Throwable e) {
            log.error("distributed lock for resource " + resource + ", lock failed", e);
        }

        if (succeed) {
            afterLockSucceed(id);
        }

        return succeed;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return lock(time, unit, true);
    }

    @Override
    public void unlock() {
        String id = ctx.get();
        if (id == null || id.equals("")) {
            throw new RuntimeException("missing lock id, must call Lock method first");
        }

        stop(id);

        try {
            if (client.deleteIf(resource.getBytes(),
                ConditionBuilder.newBuilder()
                    .exist()
                    .equal(id.getBytes())
                    .build()).get().booleanResponse()) {
                log.debug("{} unlock succeed with {}", resource, id);
            } else {
                log.warn("{} unlock failed with {}", resource, id);
            }
        } catch (Throwable e) {
            log.error("resource " + resource + " unlock failed", e);
        }
    }

    private boolean lock(long time, TimeUnit unit, boolean interruptibility) throws InterruptedException {
        long start = System.nanoTime();
        long timeout = unit.toNanos(time);
        String id = UUID.randomUUID().toString();
        for (; ; ) {
            try {
                if (doLock(id)) {
                    break;
                }

                Thread.sleep(1000);
                if (timeout > 0) {
                    long now = System.nanoTime();
                    if (now - start >= timeout) {
                        return false;
                    }
                }

            } catch (InterruptedException e) {
                if (interruptibility) {
                    throw e;
                }
            } catch (Throwable e) {
                log.error(resource + " lock failed", e);
            }
        }

        afterLockSucceed(id);
        return true;
    }

    private boolean doLock(String id) throws ExecutionException, InterruptedException {
        return client.setIf(resource.getBytes(), id.getBytes(), lease,
            ConditionBuilder.newBuilder()
                .notExist()
                .or()
                .equal(id.getBytes())
                .build()).get().booleanResponse();
    }

    private void afterLockSucceed(String id) {
        int interval = lease / 3;

        ctx.set(id);
        keep(id, interval == 0 ? 1 : interval);

        log.debug("{} lock succeed with {}", resource, id);
    }

    @Override
    public Condition newCondition() {
        throw new UnsupportedOperationException("not support condition operation");
    }

    private void keep(String id, int interval) {
        client.opts.bizService.schedule(() -> {
            if (!keeps.contains(id)) {
                log.debug("{} keep exits", resource);
                return;
            }

            try {
                doLock(id);
            } catch (Throwable e) {
                log.error(resource + " keep lock failed", e);
            }

            keep(id, interval);
        }, interval, TimeUnit.SECONDS);
    }

    private void stop(String id) {
        keeps.remove(id);
    }
}
