package cn.infinivision.dataforce.busybee;

import cn.infinivision.dataforce.busybee.pb.meta.Event;
import cn.infinivision.dataforce.busybee.pb.meta.IDValue;
import cn.infinivision.dataforce.busybee.pb.meta.InstanceCountState;
import cn.infinivision.dataforce.busybee.pb.meta.KV;
import cn.infinivision.dataforce.busybee.pb.meta.Notify;
import cn.infinivision.dataforce.busybee.pb.meta.StepState;
import cn.infinivision.dataforce.busybee.pb.meta.Workflow;
import cn.infinivision.dataforce.busybee.pb.meta.WorkflowInstance;
import cn.infinivision.dataforce.busybee.pb.rpc.AddEventRequest;
import cn.infinivision.dataforce.busybee.pb.rpc.AllocIDRequest;
import cn.infinivision.dataforce.busybee.pb.rpc.BMAddRequest;
import cn.infinivision.dataforce.busybee.pb.rpc.BMClearRequest;
import cn.infinivision.dataforce.busybee.pb.rpc.BMContainsRequest;
import cn.infinivision.dataforce.busybee.pb.rpc.BMCountRequest;
import cn.infinivision.dataforce.busybee.pb.rpc.BMRemoveRequest;
import cn.infinivision.dataforce.busybee.pb.rpc.DeleteRequest;
import cn.infinivision.dataforce.busybee.pb.rpc.FetchNotifyRequest;
import cn.infinivision.dataforce.busybee.pb.rpc.GetMappingRequest;
import cn.infinivision.dataforce.busybee.pb.rpc.GetProfileRequest;
import cn.infinivision.dataforce.busybee.pb.rpc.GetRequest;
import cn.infinivision.dataforce.busybee.pb.rpc.InstanceCountStateRequest;
import cn.infinivision.dataforce.busybee.pb.rpc.InstanceCrowdStateRequest;
import cn.infinivision.dataforce.busybee.pb.rpc.Request;
import cn.infinivision.dataforce.busybee.pb.rpc.ResetIDRequest;
import cn.infinivision.dataforce.busybee.pb.rpc.Response;
import cn.infinivision.dataforce.busybee.pb.rpc.SetRequest;
import cn.infinivision.dataforce.busybee.pb.rpc.StartingInstanceRequest;
import cn.infinivision.dataforce.busybee.pb.rpc.StopInstanceRequest;
import cn.infinivision.dataforce.busybee.pb.rpc.TenantInitRequest;
import cn.infinivision.dataforce.busybee.pb.rpc.Type;
import cn.infinivision.dataforce.busybee.pb.rpc.UpdateMappingRequest;
import cn.infinivision.dataforce.busybee.pb.rpc.UpdateProfileRequest;
import com.google.protobuf.ByteString;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Consumer;
import lombok.extern.slf4j.Slf4j;
import org.roaringbitmap.RoaringBitmap;

/**
 * busybee java client
 *
 * @author fagongzi
 */
@Slf4j(topic = "busybee")
public class Client {
    private AtomicLong id = new AtomicLong(0);
    private Transport transport;
    private long fetchCount;
    private Map<Long, FetchWorker> fetchWorkers = new ConcurrentHashMap<>();
    private ScheduledExecutorService schedulers;

    Client(Transport transport, long fetchCount, int fetchSchedulers) {
        this.transport = transport;
        this.fetchCount = fetchCount;
        schedulers = Executors.newScheduledThreadPool(fetchSchedulers);
    }

    /**
     * alloc a batch uint32 id values
     *
     * @param key key
     * @param batch value
     * @return Future Result, use {@link Result#uint32RangeResponse()} to get a uint32 range response
     */
    public Future<Result> allocId(byte[] key, long batch) {
        return CompletableFuture.supplyAsync(() -> {
            Request req = Request.newBuilder()
                .setId(id.incrementAndGet())
                .setType(Type.AllocID)
                .setAllocID(AllocIDRequest.newBuilder()
                    .setKey(ByteString.copyFrom(key))
                    .setBatch(batch)
                    .build())
                .build();

            return doRequest(req);
        });
    }

    /**
     * reset id generator
     *
     * @param key key
     * @return Future Result, use {@link Result#checkError} to check has a error
     */
    public Future<Result> resetId(byte[] key) {
        return CompletableFuture.supplyAsync(() -> {
            Request req = Request.newBuilder()
                .setId(id.incrementAndGet())
                .setType(Type.ResetID)
                .setResetID(ResetIDRequest.newBuilder()
                    .setKey(ByteString.copyFrom(key))
                    .build())
                .build();

            return doRequest(req);
        });
    }

    /**
     * reset id generator with start value
     *
     * @param key key
     * @param startWith start value
     * @return Future Result, use {@link Result#checkError} to check has a error
     */
    public Future<Result> resetId(byte[] key, long startWith) {
        return CompletableFuture.supplyAsync(() -> {
            Request req = Request.newBuilder()
                .setId(id.incrementAndGet())
                .setType(Type.ResetID)
                .setResetID(ResetIDRequest.newBuilder()
                    .setKey(ByteString.copyFrom(key))
                    .setStartWith(startWith)
                    .build())
                .build();

            return doRequest(req);
        });
    }

    /**
     * set the key-value
     *
     * @param key key
     * @param value value
     * @return Future Result, use {@link Result#checkError} to check has a error
     */
    public Future<Result> set(byte[] key, byte[] value) {
        return CompletableFuture.supplyAsync(() -> {
            Request req = Request.newBuilder()
                .setId(id.incrementAndGet())
                .setType(Type.Set)
                .setSet(SetRequest.newBuilder()
                    .setKey(ByteString.copyFrom(key))
                    .setValue(ByteString.copyFrom(value))
                    .build())
                .build();

            return doRequest(req);
        });
    }

    /**
     * get value
     *
     * @param key key
     * @return Future Result, use {@link Result#bytesResponse()} to get []byte result
     */
    public Future<Result> get(byte[] key) {
        return CompletableFuture.supplyAsync(() -> {
            Request req = Request.newBuilder()
                .setId(id.incrementAndGet())
                .setType(Type.Get)
                .setGet(GetRequest.newBuilder()
                    .setKey(ByteString.copyFrom(key))
                    .build())
                .build();

            return doRequest(req);
        });
    }

    /**
     * delete the key-value
     *
     * @param key key
     * @return Future Result, use {@link Result#checkError} to check has a error
     */
    public Future<Result> delete(byte[] key) {
        return CompletableFuture.supplyAsync(() -> {
            Request req = Request.newBuilder()
                .setId(id.incrementAndGet())
                .setType(Type.Delete)
                .setDelete(DeleteRequest.newBuilder()
                    .setKey(ByteString.copyFrom(key))
                    .build())
                .build();

            return doRequest(req);
        });
    }

    /**
     * update the id mappings
     *
     * @param tenantId tenant id
     * @param ids id of different types
     * @return Future Result, use {@link Result#checkError} to check has a error
     */
    public Future<Result> updateIDMapping(long tenantId, IDValue... ids) {
        return CompletableFuture.supplyAsync(() -> {
            Request req = Request.newBuilder()
                .setId(id.incrementAndGet())
                .setType(Type.UpdateMapping)
                .setUpdateMapping(UpdateMappingRequest.newBuilder()
                    .setId(tenantId)
                    .addAllValues(Arrays.asList(ids))
                    .build())
                .build();

            return doRequest(req);
        });
    }

    /**
     * get id
     *
     * @param tenantId tenant id
     * @param from from id
     * @param to to id type
     * @return Future Result, use {@link Result#stringResponse()} to get string result
     */
    public Future<Result> getID(long tenantId, IDValue from, int to) {
        return CompletableFuture.supplyAsync(() -> {
            Request req = Request.newBuilder()
                .setId(id.incrementAndGet())
                .setType(Type.GetMapping)
                .setGetMapping(GetMappingRequest.newBuilder()
                    .setId(tenantId)
                    .setFrom(from)
                    .setTo(to)
                    .build())
                .build();

            return doRequest(req);
        });
    }

    /**
     * update the user profile
     *
     * @param tenantId tenant id
     * @param userId user id
     * @param value profile json value
     * @return Future Result, use {@link Result#checkError} to check has a error
     */
    public Future<Result> updateProfile(long tenantId, int userId, byte[] value) {
        return CompletableFuture.supplyAsync(() -> {
            Request req = Request.newBuilder()
                .setId(id.incrementAndGet())
                .setType(Type.UpdateProfile)
                .setUpdateProfile(UpdateProfileRequest.newBuilder()
                    .setId(tenantId)
                    .setUserID(userId)
                    .setValue(ByteString.copyFrom(value))
                    .build())
                .build();

            return doRequest(req);
        });
    }

    /**
     * get user profile info
     *
     * @param tenantId tenant id
     * @param userId user id
     * @return Future Result, use {@link Result#bytesResponse()} ()} to get byte array result
     */
    public Future<Result> getProfile(long tenantId, int userId) {
        return CompletableFuture.supplyAsync(() -> {
            Request req = Request.newBuilder()
                .setId(id.incrementAndGet())
                .setType(Type.GetProfile)
                .setGetProfile(GetProfileRequest.newBuilder()
                    .setId(tenantId)
                    .setUserID(userId)
                    .build())
                .build();

            return doRequest(req);
        });
    }

    /**
     * get user profile with spec field
     *
     * @param tenantId tenant id
     * @param userId user id
     * @param field field
     * @return Future Result, use {@link Result#bytesResponse()} ()} to get byte array result
     */
    public Future<Result> getProfile(long tenantId, int userId, String field) {
        return CompletableFuture.supplyAsync(() -> {
            Request req = Request.newBuilder()
                .setId(id.incrementAndGet())
                .setType(Type.GetProfile)
                .setGetProfile(GetProfileRequest.newBuilder()
                    .setId(tenantId)
                    .setUserID(userId)
                    .setField(field)
                    .build())
                .build();

            return doRequest(req);
        });
    }

    /**
     * set bitmap
     *
     * @param key key
     * @param bm bitmap
     * @return Future Result, use {@link Result#checkError} to check has a error
     */
    public Future<Result> setBitmap(byte[] key, RoaringBitmap bm) {
        byte[] value = new byte[bm.serializedSizeInBytes()];
        bm.serialize(ByteBuffer.wrap(value));
        return set(key, value);
    }

    /**
     * get bitmap value
     *
     * @param key key
     * @return Future Result, use {@link Result#bitmapResponse()} to get bitmap result
     */
    public Future<Result> getBitmap(byte[] key) {
        return get(key);
    }

    /**
     * add ints to a bitmap
     *
     * @param key key
     * @param values int array
     * @return Future Result, use {@link Result#checkError} to check has a error
     */
    public Future<Result> addToBitmap(byte[] key, Integer... values) {
        return CompletableFuture.supplyAsync(() -> {
            Request req = Request.newBuilder()
                .setId(id.incrementAndGet())
                .setType(Type.BMAdd)
                .setBmAdd(BMAddRequest.newBuilder()
                    .setKey(ByteString.copyFrom(key))
                    .addAllValue(Arrays.asList(values))
                    .build())
                .build();

            return doRequest(req);
        });
    }

    /**
     * remove ints from a bitmap
     *
     * @param key key
     * @param values int array
     * @return Future Result, use {@link Result#checkError} to check has a error
     */
    public Future<Result> removeFromBitmap(byte[] key, Integer... values) {
        return CompletableFuture.supplyAsync(() -> {
            Request req = Request.newBuilder()
                .setId(id.incrementAndGet())
                .setType(Type.BMRemove)
                .setBmRemove(BMRemoveRequest.newBuilder()
                    .setKey(ByteString.copyFrom(key))
                    .addAllValue(Arrays.asList(values))
                    .build())
                .build();

            return doRequest(req);
        });
    }

    /**
     * clear the bitmap
     *
     * @param key key
     * @return Future Result, use {@link Result#checkError} to check has a error
     */
    public Future<Result> clearBitmap(byte[] key) {
        return CompletableFuture.supplyAsync(() -> {
            Request req = Request.newBuilder()
                .setId(id.incrementAndGet())
                .setType(Type.BMClear)
                .setBmClear(BMClearRequest.newBuilder()
                    .setKey(ByteString.copyFrom(key))
                    .build())
                .build();

            return doRequest(req);
        });
    }

    /**
     * count of the bitmap
     *
     * @param key key
     * @return Future Result, use {@link Result#longResponse} to get long result
     */
    public Future<Result> countOfBitmap(byte[] key) {
        return CompletableFuture.supplyAsync(() -> {
            Request req = Request.newBuilder()
                .setId(id.incrementAndGet())
                .setType(Type.BMCount)
                .setBmCount(BMCountRequest.newBuilder()
                    .setKey(ByteString.copyFrom(key))
                    .build())
                .build();

            return doRequest(req);
        });
    }

    /**
     * is the int values in the bitmap
     *
     * @param key key
     * @param values value
     * @return Future Result, use {@link Result#booleanResponse()} to get boolean result
     */
    public Future<Result> inBitmap(byte[] key, Integer... values) {
        return CompletableFuture.supplyAsync(() -> {
            Request req = Request.newBuilder()
                .setId(id.incrementAndGet())
                .setType(Type.BMContains)
                .setBmContains(BMContainsRequest.newBuilder()
                    .setKey(ByteString.copyFrom(key))
                    .addAllValue(Arrays.asList(values))
                    .build())
                .build();

            return doRequest(req);
        });
    }

    /**
     * init tenant, create the input and output queues
     *
     * @param tenantId tenantId
     * @param inputPartitions partition of the tenantId input queue
     * @return Future Result, use {@link Result#checkError} to check has a error
     */
    public Future<Result> initTenant(long tenantId, long inputPartitions) {
        return CompletableFuture.supplyAsync(() -> {
            Request req = Request.newBuilder()
                .setId(id.incrementAndGet())
                .setType(Type.TenantInit)
                .setTenantInit(TenantInitRequest.newBuilder()
                    .setId(tenantId)
                    .setInputQueuePartitions(inputPartitions)
                    .build())
                .build();

            return doRequest(req);
        });
    }

    /**
     * start the workflow
     *
     * @param wf workflow
     * @param bm crowd bitmap
     * @param maxPerShard max users per shard
     * @return Future Result, use {@link Result#checkError} to check has a error
     */
    public Future<Result> startInstance(Workflow wf, RoaringBitmap bm, long maxPerShard) {
        byte[] value = new byte[bm.serializedSizeInBytes()];
        bm.serialize(ByteBuffer.wrap(value));

        return CompletableFuture.supplyAsync(() -> {
            Request req = Request.newBuilder()
                .setId(id.incrementAndGet())
                .setType(Type.StartingInstance)
                .setStartInstance(StartingInstanceRequest.newBuilder()
                    .setInstance(WorkflowInstance.newBuilder()
                        .setMaxPerShard(maxPerShard)
                        .setSnapshot(wf)
                        .setCrowd(ByteString.copyFrom(value))
                        .build())
                    .build())
                .build();

            return doRequest(req);
        });
    }

    /**
     * stop the workflow
     *
     * @param workflowId workflow id
     * @return Future Result, use {@link Result#checkError} to check has a error
     */
    public Future<Result> stopInstance(long workflowId) {
        return CompletableFuture.supplyAsync(() -> {
            Request req = Request.newBuilder()
                .setId(id.incrementAndGet())
                .setType(Type.StopInstance)
                .setStopInstance(StopInstanceRequest.newBuilder()
                    .setWorkflowID(workflowId)
                    .build())
                .build();

            return doRequest(req);
        });
    }

    /**
     * the count state of the workflow, contains total and count per step.
     *
     * @param workflowId workflow id
     * @return Future Result, use {@link Result#countStateResponse} to get {@link InstanceCountState} response
     */
    public Future<Result> countState(long workflowId) {
        return CompletableFuture.supplyAsync(() -> {
            Request req = Request.newBuilder()
                .setId(id.incrementAndGet())
                .setType(Type.InstanceCountState)
                .setCountInstance(InstanceCountStateRequest.newBuilder()
                    .setWorkflowID(workflowId)
                    .build())
                .build();

            return doRequest(req);
        });
    }

    /**
     * the crowd step state of the workflow, contains step and crowd users on the step.
     *
     * @param workflowId workflow id
     * @param step step name
     * @return Future Result, use {@link Result#stepCrowdStateResponse} to get {@link StepState} response
     */
    public Future<Result> stepCrowdState(long workflowId, String step) {
        return CompletableFuture.supplyAsync(() -> {
            Request req = Request.newBuilder()
                .setId(id.incrementAndGet())
                .setType(Type.InstanceCrowdState)
                .setCrowdInstance(InstanceCrowdStateRequest.newBuilder()
                    .setWorkflowID(workflowId)
                    .setName(step)
                    .build())
                .build();

            return doRequest(req);
        });
    }

    /**
     * added event to the tenant's input queue.
     *
     * @param tenantId tenant id
     * @param userId user id
     * @param data event kv data, key1, value1, key2, value2, must pow of 2.
     * @return Future Result, use {@link Result#checkError} to check has a error
     */
    public Future<Result> addEvent(long tenantId, int userId, byte[]... data) {
        if (data.length % 2 != 0) {
            throw new IllegalArgumentException("data length must pow of 2, but " + data.length);
        }

        Event.Builder builder = Event.newBuilder()
            .setTenantID(tenantId)
            .setUserID(userId);

        for (int i = 0; i < data.length / 2; i++) {
            builder.addData(KV.newBuilder()
                .setKey(ByteString.copyFrom(data[2 * i]))
                .setValue(ByteString.copyFrom(data[2 * i + 1]))
                .build());
        }

        return CompletableFuture.supplyAsync(() -> {
            Request req = Request.newBuilder()
                .setId(id.incrementAndGet())
                .setType(Type.AddEvent)
                .setAddEvent(AddEventRequest.newBuilder()
                    .setEvent(builder.build())
                    .build())
                .build();

            return doRequest(req);
        });
    }

    /**
     * watch the notifies of the giving tenantId
     *
     * @param tenantId tenant id
     * @param consumer size
     * @param callback callback
     */
    public void watchNotify(long tenantId, String consumer, Consumer<Notify> callback) {
        if (fetchWorkers.containsKey(tenantId)) {
            log.warn("tenant {} already in watching", tenantId);
            return;
        }

        FetchWorker w = new FetchWorker(this, tenantId, consumer, callback, schedulers);
        fetchWorkers.putIfAbsent(tenantId, w);
        schedulers.schedule(fetchWorkers.get(tenantId)::run, 0, TimeUnit.SECONDS);
    }

    /**
     * stop watch the notifies
     *
     * @param tenantId tenant id
     */
    public void stopWatchNotify(long tenantId) {
        FetchWorker w = fetchWorkers.remove(tenantId);
        if (w != null) {
            w.stop();
        }
    }

    private Result doRequest(Request req) {
        Result result = new Result();
        transport.sent(req, result::done, result::done);
        result.waitComplete();
        return result;
    }

    private static class FetchWorker {
        private AtomicBoolean stopped = new AtomicBoolean(false);
        private Client client;
        private long tenantId;
        private long offset;
        private String consumer;
        private Consumer<Notify> callback;
        private ScheduledExecutorService schedulers;

        FetchWorker(Client client, long tenantId, String consumer, Consumer<Notify> callback,
            ScheduledExecutorService schedulers) {
            this.client = client;
            this.tenantId = tenantId;
            this.consumer = consumer;
            this.callback = callback;
            this.schedulers = schedulers;
        }

        void stop() {
            stopped.compareAndSet(false, true);
        }

        void onResponse(Response resp) {
            log.debug("tenant {} fetch result at offset {} is {}",
                tenantId, offset, resp);

            long after = 1;
            try {
                if (resp.hasError() &&
                    null != resp.getError().getError() &&
                    !resp.getError().getError().isEmpty()) {
                    log.error("tenant {} fetch failed at offset {} with error {}",
                        tenantId, offset, resp.getError().getError());
                } else {
                    List<ByteString> items = resp.getBytesSliceResp().getItemsList();
                    if (items.size() > 0) {
                        long value = resp.getBytesSliceResp().getLastOffset() - items.size();
                        for (ByteString bs : items) {
                            callback.accept(Notify.parseFrom(bs));
                            value++;
                            offset = value;
                        }
                        after = 0;
                    }
                }

                schedulers.schedule(this::run, after, TimeUnit.SECONDS);
            } catch (Throwable cause) {
                log.error("tenant " + tenantId + " fetch failed at offset " + offset + " failed", cause);
            }
        }

        void onError(Throwable cause) {
            log.error("tenant " + tenantId + " fetch failed at offset " + offset + " failed", cause);
            schedulers.schedule(this::run, 1, TimeUnit.SECONDS);
        }

        void run() {
            if (stopped.get()) {
                log.debug("tenant {} fetch worker stopped at offset {}", tenantId, offset);
                return;
            }

            log.debug("tenant {} fetch from offset {}", tenantId, offset);
            client.transport.sent(Request.newBuilder()
                .setId(client.id.incrementAndGet())
                .setType(Type.FetchNotify)
                .setFetchNotify(FetchNotifyRequest.newBuilder()
                    .setId(tenantId)
                    .setAfter(offset)
                    .setConsumer(consumer)
                    .setCount(client.fetchCount)
                    .build())
                .build(), this::onResponse, this::onError);
        }
    }
}
