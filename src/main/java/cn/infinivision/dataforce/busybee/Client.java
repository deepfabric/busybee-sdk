package cn.infinivision.dataforce.busybee;

import cn.infinivision.dataforce.busybee.pb.meta.BMLoader;
import cn.infinivision.dataforce.busybee.pb.meta.ConditionExecution;
import cn.infinivision.dataforce.busybee.pb.meta.DirectExecution;
import cn.infinivision.dataforce.busybee.pb.meta.ExectuionType;
import cn.infinivision.dataforce.busybee.pb.meta.Execution;
import cn.infinivision.dataforce.busybee.pb.meta.Expr;
import cn.infinivision.dataforce.busybee.pb.meta.ExprResultType;
import cn.infinivision.dataforce.busybee.pb.meta.Group;
import cn.infinivision.dataforce.busybee.pb.meta.IDSet;
import cn.infinivision.dataforce.busybee.pb.meta.IDValue;
import cn.infinivision.dataforce.busybee.pb.meta.InstanceCountState;
import cn.infinivision.dataforce.busybee.pb.meta.KV;
import cn.infinivision.dataforce.busybee.pb.meta.Notify;
import cn.infinivision.dataforce.busybee.pb.meta.ShardBitmapLoadMeta;
import cn.infinivision.dataforce.busybee.pb.meta.Step;
import cn.infinivision.dataforce.busybee.pb.meta.StepState;
import cn.infinivision.dataforce.busybee.pb.meta.TimerExecution;
import cn.infinivision.dataforce.busybee.pb.meta.UserEvent;
import cn.infinivision.dataforce.busybee.pb.meta.Workflow;
import cn.infinivision.dataforce.busybee.pb.meta.WorkflowInstance;
import cn.infinivision.dataforce.busybee.pb.meta.WorkflowInstanceState;
import cn.infinivision.dataforce.busybee.pb.rpc.AddEventRequest;
import cn.infinivision.dataforce.busybee.pb.rpc.AllocIDRequest;
import cn.infinivision.dataforce.busybee.pb.rpc.BMClearRequest;
import cn.infinivision.dataforce.busybee.pb.rpc.BMContainsRequest;
import cn.infinivision.dataforce.busybee.pb.rpc.BMCountRequest;
import cn.infinivision.dataforce.busybee.pb.rpc.BMCreateRequest;
import cn.infinivision.dataforce.busybee.pb.rpc.BMRemoveRequest;
import cn.infinivision.dataforce.busybee.pb.rpc.DeleteRequest;
import cn.infinivision.dataforce.busybee.pb.rpc.FetchNotifyRequest;
import cn.infinivision.dataforce.busybee.pb.rpc.GetIDSetRequest;
import cn.infinivision.dataforce.busybee.pb.rpc.GetMappingRequest;
import cn.infinivision.dataforce.busybee.pb.rpc.GetProfileRequest;
import cn.infinivision.dataforce.busybee.pb.rpc.GetRequest;
import cn.infinivision.dataforce.busybee.pb.rpc.HistoryInstanceRequest;
import cn.infinivision.dataforce.busybee.pb.rpc.InstanceCountStateRequest;
import cn.infinivision.dataforce.busybee.pb.rpc.InstanceCrowdStateRequest;
import cn.infinivision.dataforce.busybee.pb.rpc.LastInstanceRequest;
import cn.infinivision.dataforce.busybee.pb.rpc.Request;
import cn.infinivision.dataforce.busybee.pb.rpc.ResetIDRequest;
import cn.infinivision.dataforce.busybee.pb.rpc.Response;
import cn.infinivision.dataforce.busybee.pb.rpc.ScanMappingRequest;
import cn.infinivision.dataforce.busybee.pb.rpc.ScanRequest;
import cn.infinivision.dataforce.busybee.pb.rpc.SetRequest;
import cn.infinivision.dataforce.busybee.pb.rpc.StartingInstanceRequest;
import cn.infinivision.dataforce.busybee.pb.rpc.StopInstanceRequest;
import cn.infinivision.dataforce.busybee.pb.rpc.TenantInitRequest;
import cn.infinivision.dataforce.busybee.pb.rpc.Type;
import cn.infinivision.dataforce.busybee.pb.rpc.UpdateCrowdRequest;
import cn.infinivision.dataforce.busybee.pb.rpc.UpdateMappingRequest;
import cn.infinivision.dataforce.busybee.pb.rpc.UpdateProfileRequest;
import cn.infinivision.dataforce.busybee.pb.rpc.UpdateWorkflowRequest;
import com.google.protobuf.ByteString;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import java.io.Closeable;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.BiConsumer;
import lombok.extern.slf4j.Slf4j;
import org.roaringbitmap.RoaringBitmap;

/**
 * busybee java client
 *
 * @author fagongzi
 */
@Slf4j(topic = "busybee")
public class Client implements Closeable {
    private AtomicLong id = new AtomicLong(0);
    private Transport transport;
    private Options opts;
    private Map<Long, FetchWorker> fetchWorkers = new ConcurrentHashMap<>();
    private ScheduledExecutorService schedulers;
    private CtxHolder holder;

    Client(Transport transport, CtxHolder holder, Options opts) {
        this.transport = transport;
        this.opts = opts;
        this.holder = holder;
        schedulers = Executors.newScheduledThreadPool(opts.fetchSchedulers);
    }

    @Override
    public void close() throws IOException {
        fetchWorkers.values().stream().forEach(w -> w.stop());
        schedulers.shutdownNow();
        try {
            transport.stop();
        } catch (InterruptedException e) {
            throw new IOException(e);
        }

        holder.stop();
        log.info("client closed");
    }

    /**
     * alloc a unsigned int range [from, to]
     *
     * @param key key
     * @param batch value
     * @return Future Result, use {@link Result#unsignedIntRangeResponse()} to get a unsigned int range response
     */
    public Future<Result> allocId(byte[] key, long batch) {
        Request req = Request.newBuilder()
            .setId(id.incrementAndGet())
            .setType(Type.AllocID)
            .setAllocID(AllocIDRequest.newBuilder()
                .setKey(ByteString.copyFrom(key))
                .setBatch(batch)
                .build())
            .build();

        return doRequest(req);
    }

    /**
     * reset id generator
     *
     * @param key key
     * @return Future Result, use {@link Result#checkError} to check has a error
     */
    public Future<Result> resetId(byte[] key) {
        Request req = Request.newBuilder()
            .setId(id.incrementAndGet())
            .setType(Type.ResetID)
            .setResetID(ResetIDRequest.newBuilder()
                .setKey(ByteString.copyFrom(key))
                .build())
            .build();

        return doRequest(req);
    }

    /**
     * get current alloc value
     *
     * @param key key
     * @return Future Result, use {@link Result#unsignedIntResponse()} to get a unsigned int response
     */
    public Future<Result> currentId(byte[] key) {
        return get(key);
    }

    /**
     * reset id generator with start value
     *
     * @param key key
     * @param startWith start value
     * @return Future Result, use {@link Result#checkError} to check has a error
     */
    public Future<Result> resetId(byte[] key, long startWith) {
        Request req = Request.newBuilder()
            .setId(id.incrementAndGet())
            .setType(Type.ResetID)
            .setResetID(ResetIDRequest.newBuilder()
                .setKey(ByteString.copyFrom(key))
                .setStartWith(startWith)
                .build())
            .build();

        return doRequest(req);
    }

    /**
     * set the key-value
     *
     * @param key key
     * @param value value
     * @return Future Result, use {@link Result#checkError} to check has a error
     */
    public Future<Result> set(byte[] key, byte[] value) {
        return set(key, value, 0);
    }

    /**
     * set the key-value with a ttl in seconds
     *
     * @param key key
     * @param value value
     * @param ttl ttl in seconds
     * @return Future Result, use {@link Result#checkError} to check has a error
     */
    public Future<Result> set(byte[] key, byte[] value, long ttl) {
        Request req = Request.newBuilder()
            .setId(id.incrementAndGet())
            .setType(Type.Set)
            .setSet(SetRequest.newBuilder()
                .setKey(ByteString.copyFrom(key))
                .setValue(ByteString.copyFrom(value))
                .setTtl(ttl)
                .build())
            .build();
        return doRequest(req);
    }

    /**
     * get value
     *
     * @param key key
     * @return Future Result, use {@link Result#bytesResponse()} to get []byte result
     */
    public Future<Result> get(byte[] key) {
        Request req = Request.newBuilder()
            .setId(id.incrementAndGet())
            .setType(Type.Get)
            .setGet(GetRequest.newBuilder()
                .setKey(ByteString.copyFrom(key))
                .build())
            .build();

        return doRequest(req);
    }

    /**
     * delete the key-value
     *
     * @param key key
     * @return Future Result, use {@link Result#checkError} to check has a error
     */
    public Future<Result> delete(byte[] key) {
        Request req = Request.newBuilder()
            .setId(id.incrementAndGet())
            .setType(Type.Delete)
            .setDelete(DeleteRequest.newBuilder()
                .setKey(ByteString.copyFrom(key))
                .build())
            .build();

        return doRequest(req);
    }

    /**
     * scanKeys scan keys in range [start,end)
     *
     * @param starInclude start key, include
     * @param endExclude end key, exclude
     * @param limit limit batch size
     * @return Future Result, use {@link Result#bytesListResponse} to get bytes list response
     */
    public Future<Result> scanKeys(byte[] starInclude, byte[] endExclude, long limit) {
        return scan(starInclude, endExclude, limit, Group.DefaultGroup);
    }

    /**
     * update the id mappings
     *
     * @param tenantId tenant id
     * @param userId user id
     * @param ids id of different types
     * @return Future Result, use {@link Result#checkError} to check has a error
     */
    public Future<Result> updateIDMapping(long tenantId, long userId, IDValue... ids) {
        Request req = Request.newBuilder()
            .setId(id.incrementAndGet())
            .setType(Type.UpdateMapping)
            .setUpdateMapping(UpdateMappingRequest.newBuilder()
                .setId(tenantId)
                .setUserID(userId)
                .setSet(IDSet.newBuilder()
                    .addValues(IDValue.newBuilder()
                        .setValue(String.valueOf(userId))
                        .setType(opts.defaultMappingType)
                        .build())
                    .addAllValues(Arrays.asList(ids))
                    .build())
                .build())
            .build();

        return doRequest(req);
    }

    /**
     * get user id set
     *
     * @param tenantId tenant id
     * @param userId user id
     * @return Future Result, use {@link Result#idSetResponse} to get id set response
     */
    public Future<Result> getIDSet(long tenantId, long userId) {
        Request req = Request.newBuilder()
            .setId(id.incrementAndGet())
            .setType(Type.GetIDSet)
            .setGetIDSet(GetIDSetRequest.newBuilder()
                .setId(tenantId)
                .setUserID(userId)
                .build())
            .build();

        return doRequest(req);
    }

    /**
     * scan tenant user id mapping in range [start,end)
     *
     * @param tenantId tenant id
     * @param fromInclude start user id, include
     * @param toExclude end user id, exclude
     * @param limit limit batch size
     * @return Future Result, use {@link Result#bytesListResponse} to get bytes list response
     */
    public Future<Result> scanIDMapping(long tenantId, long fromInclude, long toExclude, long limit) {
        Request req = Request.newBuilder()
            .setId(id.incrementAndGet())
            .setType(Type.ScanMapping)
            .setScanMapping(ScanMappingRequest.newBuilder()
                .setId(tenantId)
                .setFrom(fromInclude)
                .setTo(toExclude)
                .setLimit(limit)
                .build())
            .build();

        return doRequest(req);
    }

    /**
     * get id
     *
     * @param tenantId tenant id
     * @param from from id
     * @param to to id type
     * @return Future Result, use {@link Result#stringResponse()} to get string result
     */
    public Future<Result> getID(long tenantId, IDValue from, String to) {
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
    }

    /**
     * get user profile info
     *
     * @param tenantId tenant id
     * @param userId user id
     * @return Future Result, use {@link Result#bytesResponse()} ()} to get byte array result
     */
    public Future<Result> getProfile(long tenantId, int userId) {
        Request req = Request.newBuilder()
            .setId(id.incrementAndGet())
            .setType(Type.GetProfile)
            .setGetProfile(GetProfileRequest.newBuilder()
                .setId(tenantId)
                .setUserID(userId)
                .build())
            .build();

        return doRequest(req);
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
     * @param values uint32 array
     * @return Future Result, use {@link Result#checkError} to check has a error
     */
    public Future<Result> addToBitmap(byte[] key, Long... values) {
        Request req = Request.newBuilder()
            .setId(id.incrementAndGet())
            .setType(Type.BMCreate)
            .setBmCreate(BMCreateRequest.newBuilder()
                .setKey(ByteString.copyFrom(key))
                .addAllValue(Arrays.asList(values))
                .build())
            .build();

        return doRequest(req);
    }

    /**
     * remove ints from a bitmap
     *
     * @param key key
     * @param values int array
     * @return Future Result, use {@link Result#checkError} to check has a error
     */
    public Future<Result> removeFromBitmap(byte[] key, Long... values) {
        Request req = Request.newBuilder()
            .setId(id.incrementAndGet())
            .setType(Type.BMRemove)
            .setBmRemove(BMRemoveRequest.newBuilder()
                .setKey(ByteString.copyFrom(key))
                .addAllValue(Arrays.asList(values))
                .build())
            .build();

        return doRequest(req);
    }

    /**
     * clear the bitmap
     *
     * @param key key
     * @return Future Result, use {@link Result#checkError} to check has a error
     */
    public Future<Result> clearBitmap(byte[] key) {
        Request req = Request.newBuilder()
            .setId(id.incrementAndGet())
            .setType(Type.BMClear)
            .setBmClear(BMClearRequest.newBuilder()
                .setKey(ByteString.copyFrom(key))
                .build())
            .build();

        return doRequest(req);
    }

    /**
     * count of the bitmap
     *
     * @param key key
     * @return Future Result, use {@link Result#longResponse} to get long result
     */
    public Future<Result> countOfBitmap(byte[] key) {
        Request req = Request.newBuilder()
            .setId(id.incrementAndGet())
            .setType(Type.BMCount)
            .setBmCount(BMCountRequest.newBuilder()
                .setKey(ByteString.copyFrom(key))
                .build())
            .build();

        return doRequest(req);
    }

    /**
     * is the int values in the bitmap
     *
     * @param key key
     * @param values value
     * @return Future Result, use {@link Result#booleanResponse()} to get boolean result
     */
    public Future<Result> inBitmap(byte[] key, Long... values) {
        Request req = Request.newBuilder()
            .setId(id.incrementAndGet())
            .setType(Type.BMContains)
            .setBmContains(BMContainsRequest.newBuilder()
                .setKey(ByteString.copyFrom(key))
                .addAllValue(Arrays.asList(values))
                .build())
            .build();

        return doRequest(req);
    }

    /**
     * init tenant, create the input and output queues
     *
     * @param tenantId tenantId
     * @param inputPartitions partition of the tenantId input queue
     * @return Future Result, use {@link Result#checkError} to check has a error
     */
    public Future<Result> initTenant(long tenantId, long inputPartitions) {
        Request req = Request.newBuilder()
            .setId(id.incrementAndGet())
            .setType(Type.TenantInit)
            .setTenantInit(TenantInitRequest.newBuilder()
                .setId(tenantId)
                .setInputQueuePartitions(inputPartitions)
                .build())
            .build();

        return doRequest(req);
    }

    /**
     * start the workflow
     *
     * @param wf workflow
     * @param bm crowd bitmap
     * @param workers number of workers to run this workflow
     * @return Future Result, use {@link Result#checkError} to check has a error
     */
    public Future<Result> startInstance(Workflow wf, RoaringBitmap bm, long workers) {
        byte[] value = new byte[bm.serializedSizeInBytes()];
        bm.serialize(ByteBuffer.wrap(value));

        Request req = Request.newBuilder()
            .setId(id.incrementAndGet())
            .setType(Type.StartingInstance)
            .setStartInstance(StartingInstanceRequest.newBuilder()
                .setInstance(WorkflowInstance.newBuilder()
                    .setWorkers(workers)
                    .setSnapshot(wf)
                    .setLoader(BMLoader.RawLoader)
                    .setLoaderMeta(ByteString.copyFrom(value))
                    .build())
                .build())
            .build();

        return doRequest(req);
    }

    /**
     * start the workflow using CK Sql
     *
     * @param wf workflow
     * @param sql load bitmap from ck sql
     * @param workers number of workers to run this workflow
     * @return Future Result, use {@link Result#checkError} to check has a error
     */
    public Future<Result> startInstanceWithCK(Workflow wf, String sql, long workers) {
        Request req = Request.newBuilder()
            .setId(id.incrementAndGet())
            .setType(Type.StartingInstance)
            .setStartInstance(StartingInstanceRequest.newBuilder()
                .setInstance(WorkflowInstance.newBuilder()
                    .setWorkers(workers)
                    .setSnapshot(wf)
                    .setLoader(BMLoader.ClickhouseLoader)
                    .setLoaderMeta(ByteString.copyFrom(sql.getBytes()))
                    .build())
                .build())
            .build();

        return doRequest(req);
    }

    /**
     * start the workflow using CK Sql
     *
     * @param wf workflow
     * @param key load bitmap from kv
     * @param workers number of workers to run this workflow
     * @return Future Result, use {@link Result#checkError} to check has a error
     */
    public Future<Result> startInstanceWithKV(Workflow wf, String key, long workers) {
        Request req = Request.newBuilder()
            .setId(id.incrementAndGet())
            .setType(Type.StartingInstance)
            .setStartInstance(StartingInstanceRequest.newBuilder()
                .setInstance(WorkflowInstance.newBuilder()
                    .setWorkers(workers)
                    .setSnapshot(wf)
                    .setLoader(BMLoader.KVLoader)
                    .setLoaderMeta(ByteString.copyFrom(key.getBytes()))
                    .build())
                .build())
            .build();

        return doRequest(req);
    }

    /**
     * get the workflow last instance
     *
     * @param workflowId workflow id
     * @return Future Result, use {@link Result#lastInstanceResponse} to get response
     */
    public Future<Result> lastInstance(long workflowId) {
        Request req = Request.newBuilder()
            .setId(id.incrementAndGet())
            .setType(Type.LastInstance)
            .setLastInstance(LastInstanceRequest.newBuilder()
                .setWorkflowID(workflowId)
                .build())
            .build();

        return doRequest(req);
    }

    /**
     * get the workflow history instance snapshot
     *
     * @param workflowId workflow id
     * @param instanceId workflow instance id
     * @return Future Result, use {@link Result#historyInstanceResponse} to get response
     */
    public Future<Result> historyInstance(long workflowId, long instanceId) {
        Request req = Request.newBuilder()
            .setId(id.incrementAndGet())
            .setType(Type.HistoryInstance)
            .setHistoryInstance(HistoryInstanceRequest.newBuilder()
                .setWorkflowID(workflowId)
                .setInstanceID(instanceId)
                .build())
            .build();

        return doRequest(req);
    }

    /**
     * update the workflow definition
     *
     * @param wf workflow definition
     * @return Future Result, use {@link Result#checkError} to check has a error
     */
    public Future<Result> updateWorkflow(Workflow wf) {
        Request req = Request.newBuilder()
            .setId(id.incrementAndGet())
            .setType(Type.UpdateWorkflow)
            .setUpdateWorkflow(UpdateWorkflowRequest.newBuilder()
                .setWorkflow(wf)
                .build())
            .build();

        return doRequest(req);
    }

    /**
     * update the workflow crowd
     *
     * @param workflowId workflow id
     * @param bm crowd bitmap
     * @return Future Result, use {@link Result#checkError} to check has a error
     */
    public Future<Result> updateWorkflowCrowd(long workflowId, RoaringBitmap bm) {
        byte[] value = new byte[bm.serializedSizeInBytes()];
        bm.serialize(ByteBuffer.wrap(value));

        Request req = Request.newBuilder()
            .setId(id.incrementAndGet())
            .setType(Type.UpdateCrowd)
            .setUpdateCrowd(UpdateCrowdRequest.newBuilder()
                .setId(workflowId)
                .setLoader(BMLoader.RawLoader)
                .setLoaderMeta(ByteString.copyFrom(value))
                .build())
            .build();

        return doRequest(req);
    }

    /**
     * update the workflow crowd
     *
     * @param workflowId workflow id
     * @param sql crowd query sql
     * @return Future Result, use {@link Result#checkError} to check has a error
     */
    public Future<Result> updateWorkflowCrowdWithCKSQL(long workflowId, String sql) {
        Request req = Request.newBuilder()
            .setId(id.incrementAndGet())
            .setType(Type.UpdateCrowd)
            .setUpdateCrowd(UpdateCrowdRequest.newBuilder()
                .setId(workflowId)
                .setLoader(BMLoader.ClickhouseLoader)
                .setLoaderMeta(ByteString.copyFrom(sql.getBytes()))
                .build())
            .build();

        return doRequest(req);
    }

    /**
     * update the workflow crowd
     *
     * @param workflowId workflow id
     * @param key crowd key in the KV
     * @return Future Result, use {@link Result#checkError} to check has a error
     */
    public Future<Result> updateWorkflowCrowdWithKV(long workflowId, String key) {
        Request req = Request.newBuilder()
            .setId(id.incrementAndGet())
            .setType(Type.UpdateCrowd)
            .setUpdateCrowd(UpdateCrowdRequest.newBuilder()
                .setId(workflowId)
                .setLoader(BMLoader.KVLoader)
                .setLoaderMeta(ByteString.copyFrom(key.getBytes()))
                .build())
            .build();

        return doRequest(req);
    }

    /**
     * stop the workflow
     *
     * @param workflowId workflow id
     * @return Future Result, use {@link Result#checkError} to check has a error
     */
    public Future<Result> stopInstance(long workflowId) {
        Request req = Request.newBuilder()
            .setId(id.incrementAndGet())
            .setType(Type.StopInstance)
            .setStopInstance(StopInstanceRequest.newBuilder()
                .setWorkflowID(workflowId)
                .build())
            .build();

        return doRequest(req);
    }

    /**
     * the count state of the workflow, contains total and count per step.
     *
     * @param workflowId workflow id
     * @return Future Result, use {@link Result#countStateResponse} to get {@link InstanceCountState} response
     */
    public Future<Result> countState(long workflowId) {
        Request req = Request.newBuilder()
            .setId(id.incrementAndGet())
            .setType(Type.InstanceCountState)
            .setCountInstance(InstanceCountStateRequest.newBuilder()
                .setWorkflowID(workflowId)
                .build())
            .build();

        return doRequest(req);
    }

    /**
     * added event to the tenant's input queue.
     *
     * @param tenantId tenant id
     * @param userId user id
     * @param data event kv data, key1, value1, key2, value2, must pow of 2.
     * @return Future Result, use {@link Result#checkError} to check has a error
     */
    public Future<Result> addEvent(long tenantId, long userId, byte[]... data) {
        if (data.length % 2 != 0) {
            throw new IllegalArgumentException("data length must pow of 2, but " + data.length);
        }

        UserEvent.Builder builder = UserEvent.newBuilder()
            .setTenantID(tenantId)
            .setUserID(userId);

        for (int i = 0; i < data.length / 2; i++) {
            builder.addData(KV.newBuilder()
                .setKey(ByteString.copyFrom(data[2 * i]))
                .setValue(ByteString.copyFrom(data[2 * i + 1]))
                .build());
        }

        Request req = Request.newBuilder()
            .setId(id.incrementAndGet())
            .setType(Type.AddEvent)
            .setAddEvent(AddEventRequest.newBuilder()
                .setEvent(builder.build())
                .build())
            .build();

        return doRequest(req);
    }

    /**
     * the crowd step state of the workflow, contains step and crowd users on the step.
     *
     * @param workflowId workflow id
     * @param step step name
     * @return Future Result, use {@link Result#stepCrowdStateResponse} to get {@link StepState} response
     */
    public Future<Result> stepCrowdState(long workflowId, String step) {
        Request req = Request.newBuilder()
            .setId(id.incrementAndGet())
            .setType(Type.InstanceCrowdState)
            .setCrowdInstance(InstanceCrowdStateRequest.newBuilder()
                .setWorkflowID(workflowId)
                .setName(step)
                .build())
            .build();

        return doRequest(req);
    }

    /**
     * watch the notifies of the giving tenantId
     *
     * @param tenantId tenant id
     * @param consumer size
     * @param callback callback
     */
    public void watchNotify(long tenantId, String consumer, BiConsumer<Long, Notify> callback) {
        if (fetchWorkers.containsKey(tenantId)) {
            log.warn("tenant {} already in watching", tenantId);
            return;
        }

        FetchWorker w = new FetchWorker(this, tenantId, consumer, callback, null, schedulers);
        fetchWorkers.putIfAbsent(tenantId, w);
        schedulers.schedule(fetchWorkers.get(tenantId)::run, 0, TimeUnit.SECONDS);
    }

    /**
     * watch the notifies of the giving tenantId
     *
     * @param tenantId tenant id
     * @param consumer size
     * @param callback batch callback
     */
    public void watchBatchNotify(long tenantId, String consumer, BiConsumer<Long, List<Notify>> callback) {
        if (fetchWorkers.containsKey(tenantId)) {
            log.warn("tenant {} already in watching", tenantId);
            return;
        }

        FetchWorker w = new FetchWorker(this, tenantId, consumer, null, callback, schedulers);
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

    /**
     * get bitmap by loader and loaderMeta
     *
     * @param loader loader
     * @param loadMeta loader meta
     * @return
     */
    public RoaringBitmap loadBitmap(BMLoader loader, ByteString loadMeta) {
        switch (loader) {
            case KVShardLoader:
                try {
                    ShardBitmapLoadMeta meta = ShardBitmapLoadMeta.parseFrom(loadMeta);
                    int pos = 0;
                    byte[] data = new byte[(int) meta.getTotal()];
                    ByteBuf buf = ByteBufAllocator.DEFAULT.buffer();
                    for (int i = 0; i < meta.getShards(); i++) {
                        buf.clear();
                        buf.writeBytes(meta.getKey().toByteArray());
                        buf.writeInt(i);

                        byte[] key = new byte[buf.readableBytes()];
                        buf.readBytes(key);

                        byte[] shard = get(key).get().bytesResponse();
                        System.arraycopy(shard, 0, data, pos, shard.length);
                        pos += shard.length;
                    }

                    RoaringBitmap bm = RoaringBitmap.bitmapOf();
                    bm.deserialize(ByteBuffer.wrap(data));
                    return bm;
                } catch (Throwable e) {
                    throw new RuntimeException(e);
                }
            case RawLoader:
                RoaringBitmap bm = RoaringBitmap.bitmapOf();
                try {
                    bm.deserialize(ByteBuffer.wrap(loadMeta.toByteArray()));
                    return bm;
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            default:
                throw new RuntimeException("not support loader " + loader);
        }
    }

    private Future<Result> scan(byte[] starInclude, byte[] endExclude, long limit, Group group) {
        Request req = Request.newBuilder()
            .setId(id.incrementAndGet())
            .setType(Type.Scan)
            .setScan(ScanRequest.newBuilder()
                .setStart(ByteString.copyFrom(starInclude))
                .setEnd(ByteString.copyFrom(endExclude))
                .setLimit(limit)
                .setGroup(group)
                .build())
            .build();

        return doRequest(req);
    }

    private Future<Result> doRequest(Request req) {
        Result result = new Result();
        transport.sent(req, result::done, result::done);
        return CompletableFuture.supplyAsync(() -> {
            result.waitComplete();
            return result;
        });
    }

    private static class FetchWorker {
        private AtomicBoolean stopped = new AtomicBoolean(false);
        private Client client;
        private long tenantId;
        private long offset;
        private String consumer;
        private BiConsumer<Long, Notify> callback;
        private BiConsumer<Long, List<Notify>> batchCallback;
        private ScheduledExecutorService schedulers;

        FetchWorker(Client client, long tenantId, String consumer, BiConsumer<Long, Notify> callback,
            BiConsumer<Long, List<Notify>> batchCallback,
            ScheduledExecutorService schedulers) {
            this.client = client;
            this.tenantId = tenantId;
            this.consumer = consumer;
            this.callback = callback;
            this.batchCallback = batchCallback;
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
                    List<ByteString> items = resp.getBytesSliceResp().getValuesList();
                    if (items.size() > 0) {
                        long value = resp.getBytesSliceResp().getLastValue() - items.size() + 1;
                        List<Notify> values = new ArrayList<>();
                        for (ByteString bs : items) {
                            values.add(Notify.parseFrom(bs));
                        }

                        if (callback != null) {
                            for (Notify nt : values) {
                                callback.accept(value, nt);
                                offset = value;
                                value++;
                            }
                        } else {
                            batchCallback.accept(value, values);
                            offset = resp.getBytesSliceResp().getLastValue();
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
                    .setCompletedOffset(offset)
                    .setConsumer(consumer)
                    .setCount(client.opts.fetchCount)
                    .setConcurrency(client.opts.consumerConcurrency)
                    .build())
                .build(), this::onResponse, this::onError);
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException, IOException {
        Client c = new Builder().rpcTimeout(5000).addServer("172.19.0.106:8091",
            "172.19.0.106:8092",
            "172.19.0.106:8093",
            "172.19.0.106:8094").build();

//        c.initTenant(1, 2).get().checkError();
        timerWorkflow(c);

    }

    public static void keys(Client c) throws ExecutionException, InterruptedException {
        for (int i = 0; i < 10; i++) {
            c.set(("key0" + i).getBytes(), ("value" + i).getBytes()).get().checkError();
        }

        System.out.println(c.scanKeys("key0".getBytes(), "key1".getBytes(), 10).get().bytesListResponse());
    }

    public static void alloc(Client c) throws ExecutionException, InterruptedException {
        byte[] key = "key-id".getBytes();

        System.out.println(c.currentId(key).get().unsignedIntResponse());
        c.allocId(key, 10).get().checkError();
        System.out.println(c.currentId(key).get().unsignedIntResponse());
        c.resetId(key, 5).get().checkError();
        System.out.println(c.currentId(key).get().unsignedIntResponse());
    }

    public static void mapping(Client c) throws ExecutionException, InterruptedException {
        long tid = 10000;
        c.updateIDMapping(tid, 1, IDValue.newBuilder().setType("1").setValue("u1-1").build()).get().checkError();
        c.updateIDMapping(tid, 2, IDValue.newBuilder().setType("1").setValue("u2-1").build()).get().checkError();

        System.out.println(c.scanIDMapping(tid, 1, 3, 4).get().idSetListResponse());
        System.out.println(c.getIDSet(tid, 1).get().idSetResponse());
        System.out.println(c.getIDSet(tid, 2).get().idSetResponse());
    }

    public static void bitmap(Client c) throws ExecutionException, InterruptedException {
        byte[] key = "key1".getBytes();

        c.addToBitmap(key, 1L, 2L, 3L, 4L, 5L).get().checkError();
        System.out.println(c.getBitmap(key).get().bitmapResponse().getCardinality());
    }

    public static void workflowWithBigBM(Client c) throws ExecutionException, InterruptedException {
        byte[] key = "bm1".getBytes();
        Long[] values = new Long[40000];
        int index = 0;
        for (long i = 0; i < 400000000L; i++) {
            if (i % 333 == 0) {
                values[index] = i;
                index++;

                if (index == 40000) {
                    c.addToBitmap(key, values).get().checkError();
                    index = 0;
                }
            }
        }

        if (index > 0) {
            c.addToBitmap(key, values).get().checkError();
        }

        Workflow wf = Workflow.newBuilder()
            .setId(1000)
            .setName("test")
            .setTenantID(1)
            .addSteps(Step.newBuilder()
                .setName("step-0")
                .setExecution(Execution.newBuilder()
                    .setType(ExectuionType.Branch)
                    .addBranches(ConditionExecution.newBuilder()
                        .setCondition(Expr.newBuilder()
                            .setType(ExprResultType.BoolResult)
                            .setValue(ByteString.copyFrom("{num: event.uid} == 1".getBytes()))
                            .build())
                        .setNextStep("step_end_1"))
                    .addBranches(ConditionExecution.newBuilder()
                        .setCondition(Expr.newBuilder()
                            .setType(ExprResultType.BoolResult)
                            .setValue(ByteString.copyFrom("{num: event.uid} == 2".getBytes()))
                            .build())
                        .setNextStep("step_end_2"))
                    .addBranches(ConditionExecution.newBuilder()
                        .setCondition(Expr.newBuilder()
                            .setType(ExprResultType.BoolResult)
                            .setValue(ByteString.copyFrom("{num: event.uid} == 3".getBytes()))
                            .build())
                        .setNextStep("step_end_3"))
                    .addBranches(ConditionExecution.newBuilder()
                        .setCondition(Expr.newBuilder()
                            .setType(ExprResultType.BoolResult)
                            .setValue(ByteString.copyFrom("{num: event.uid} == 4".getBytes()))
                            .build())
                        .setNextStep("step_end_4"))
                    .build())
                .build())
            .addSteps(Step.newBuilder()
                .setName("step_end_1")
                .setExecution(Execution.newBuilder()
                    .setType(ExectuionType.Direct)
                    .setDirect(DirectExecution.newBuilder().build())
                    .build()))
            .addSteps(Step.newBuilder()
                .setName("step_end_2")
                .setExecution(Execution.newBuilder()
                    .setType(ExectuionType.Direct)
                    .setDirect(DirectExecution.newBuilder().build())
                    .build()))
            .addSteps(Step.newBuilder()
                .setName("step_end_3")
                .setExecution(Execution.newBuilder()
                    .setType(ExectuionType.Direct)
                    .setDirect(DirectExecution.newBuilder().build())
                    .build()))
            .addSteps(Step.newBuilder()
                .setName("step_end_4")
                .setExecution(Execution.newBuilder()
                    .setType(ExectuionType.Direct)
                    .setDirect(DirectExecution.newBuilder().build())
                    .build()))
            .build();

        c.initTenant(1, 2).get().checkError();
        Thread.sleep(15000);
        c.startInstanceWithKV(wf, "bm1", 256).get().checkError();
        c.addEvent(1, 1, "uid".getBytes(), "1".getBytes()).get().checkError();
        c.addEvent(1, 2, "uid".getBytes(), "2".getBytes()).get().checkError();
        c.addEvent(1, 3, "uid".getBytes(), "3".getBytes()).get().checkError();

        for (; ; ) {
            System.out.println("************************** send last instance");
            WorkflowInstance last = c.lastInstance(1000).get().lastInstanceResponse();
            if (last.getState() == WorkflowInstanceState.Running) {
                break;
            }

            Thread.sleep(1000);
        }

        System.out.println("countState: " + c.countState(1000).get().countStateResponse());
        System.out.println("updateWorkflowCrowd*********** ");
        c.updateWorkflowCrowd(1000, RoaringBitmap.bitmapOf(1, 2, 3, 4)).get().checkError();
        Thread.sleep(2000);
        c.addEvent(1, 4, "uid".getBytes(), "4".getBytes()).get().checkError();
        Thread.sleep(2000);
        System.out.println(c.countState(1000).get().countStateResponse());

        c.updateWorkflow(Workflow.newBuilder()
            .setId(1000)
            .setName("test")
            .setTenantID(1)
            .addSteps(Step.newBuilder()
                .setName("step-0")
                .setExecution(Execution.newBuilder()
                    .setType(ExectuionType.Branch)
                    .addBranches(ConditionExecution.newBuilder()
                        .setCondition(Expr.newBuilder()
                            .setType(ExprResultType.BoolResult)
                            .setValue(ByteString.copyFrom("{num: event.uid} == 1".getBytes()))
                            .build())
                        .setNextStep("step_end_1"))
                    .addBranches(ConditionExecution.newBuilder()
                        .setCondition(Expr.newBuilder()
                            .setType(ExprResultType.BoolResult)
                            .setValue(ByteString.copyFrom("{num: event.uid} == 2".getBytes()))
                            .build())
                        .setNextStep("step_end_2"))
                    .addBranches(ConditionExecution.newBuilder()
                        .setCondition(Expr.newBuilder()
                            .setType(ExprResultType.BoolResult)
                            .setValue(ByteString.copyFrom("{num: event.uid} == 3".getBytes()))
                            .build())
                        .setNextStep("step_end_3"))
                    .addBranches(ConditionExecution.newBuilder()
                        .setCondition(Expr.newBuilder()
                            .setType(ExprResultType.BoolResult)
                            .setValue(ByteString.copyFrom("{num: event.uid} == 4".getBytes()))
                            .build())
                        .setNextStep("step_end_4"))
                    .build())
                .build())
            .addSteps(Step.newBuilder()
                .setName("step_end_1")
                .setExecution(Execution.newBuilder()
                    .setType(ExectuionType.Direct)
                    .setDirect(DirectExecution.newBuilder().build())
                    .build()))
            .addSteps(Step.newBuilder()
                .setName("step_end_4")
                .setExecution(Execution.newBuilder()
                    .setType(ExectuionType.Direct)
                    .setDirect(DirectExecution.newBuilder().build())
                    .build()))
            .build()).get().checkError();

        Thread.sleep(2000);
        System.out.println(c.countState(1000).get().countStateResponse());

        StepState state = c.stepCrowdState(1000, "step-0").get().stepCrowdStateResponse();
        System.out.println("************************* state: " + state);
        RoaringBitmap bm = c.loadBitmap(state.getLoader(), state.getLoaderMeta());
        System.out.println("####************************* state: " + state + ", " + bm.getLongCardinality());

        c.stopInstance(1000).get();

        Thread.sleep(1000);
        WorkflowInstance last = c.lastInstance(1000).get().lastInstanceResponse();
        System.out.println(last);
        System.out.println(c.historyInstance(1000, last.getInstanceID()).get().historyInstanceResponse());

    }

    public static void workflow(Client c) throws ExecutionException, InterruptedException {
        c.initTenant(1, 2).get().checkError();
        Thread.sleep(15000);
        Workflow wf = Workflow.newBuilder()
            .setId(1000)
            .setName("test")
            .setTenantID(1)
            .addSteps(Step.newBuilder()
                .setName("step-0")
                .setExecution(Execution.newBuilder()
                    .setType(ExectuionType.Branch)
                    .addBranches(ConditionExecution.newBuilder()
                        .setCondition(Expr.newBuilder()
                            .setType(ExprResultType.BoolResult)
                            .setValue(ByteString.copyFrom("{num: event.uid} == 1".getBytes()))
                            .build())
                        .setNextStep("step_end_1"))
                    .addBranches(ConditionExecution.newBuilder()
                        .setCondition(Expr.newBuilder()
                            .setType(ExprResultType.BoolResult)
                            .setValue(ByteString.copyFrom("{num: event.uid} == 2".getBytes()))
                            .build())
                        .setNextStep("step_end_2"))
                    .addBranches(ConditionExecution.newBuilder()
                        .setCondition(Expr.newBuilder()
                            .setType(ExprResultType.BoolResult)
                            .setValue(ByteString.copyFrom("{num: event.uid} == 3".getBytes()))
                            .build())
                        .setNextStep("step_end_3"))
                    .addBranches(ConditionExecution.newBuilder()
                        .setCondition(Expr.newBuilder()
                            .setType(ExprResultType.BoolResult)
                            .setValue(ByteString.copyFrom("{num: event.uid} == 4".getBytes()))
                            .build())
                        .setNextStep("step_end_4"))
                    .build())
                .build())
            .addSteps(Step.newBuilder()
                .setName("step_end_1")
                .setExecution(Execution.newBuilder()
                    .setType(ExectuionType.Direct)
                    .setDirect(DirectExecution.newBuilder().build())
                    .build()))
            .addSteps(Step.newBuilder()
                .setName("step_end_2")
                .setExecution(Execution.newBuilder()
                    .setType(ExectuionType.Direct)
                    .setDirect(DirectExecution.newBuilder().build())
                    .build()))
            .addSteps(Step.newBuilder()
                .setName("step_end_3")
                .setExecution(Execution.newBuilder()
                    .setType(ExectuionType.Direct)
                    .setDirect(DirectExecution.newBuilder().build())
                    .build()))
            .addSteps(Step.newBuilder()
                .setName("step_end_4")
                .setExecution(Execution.newBuilder()
                    .setType(ExectuionType.Direct)
                    .setDirect(DirectExecution.newBuilder().build())
                    .build()))
            .build();
        c.startInstance(wf, RoaringBitmap.bitmapOf(1, 2, 3), 4).get().checkError();
        c.addEvent(1, 1, "uid".getBytes(), "1".getBytes()).get().checkError();
        c.addEvent(1, 2, "uid".getBytes(), "2".getBytes()).get().checkError();
        c.addEvent(1, 3, "uid".getBytes(), "3".getBytes()).get().checkError();

        Thread.sleep(2000);
        System.out.println(c.lastInstance(1000).get().lastInstanceResponse());
        System.out.println(c.countState(1000).get().countStateResponse());

        c.updateWorkflowCrowd(1000, RoaringBitmap.bitmapOf(1, 2, 3, 4)).get().checkError();
        Thread.sleep(2000);
        c.addEvent(1, 4, "uid".getBytes(), "4".getBytes()).get().checkError();
        Thread.sleep(2000);
        System.out.println(c.countState(1000).get().countStateResponse());

        c.updateWorkflow(Workflow.newBuilder()
            .setId(1000)
            .setName("test")
            .setTenantID(1)
            .addSteps(Step.newBuilder()
                .setName("step-0")
                .setExecution(Execution.newBuilder()
                    .setType(ExectuionType.Branch)
                    .addBranches(ConditionExecution.newBuilder()
                        .setCondition(Expr.newBuilder()
                            .setType(ExprResultType.BoolResult)
                            .setValue(ByteString.copyFrom("{num: event.uid} == 1".getBytes()))
                            .build())
                        .setNextStep("step_end_1"))
                    .addBranches(ConditionExecution.newBuilder()
                        .setCondition(Expr.newBuilder()
                            .setType(ExprResultType.BoolResult)
                            .setValue(ByteString.copyFrom("{num: event.uid} == 2".getBytes()))
                            .build())
                        .setNextStep("step_end_2"))
                    .addBranches(ConditionExecution.newBuilder()
                        .setCondition(Expr.newBuilder()
                            .setType(ExprResultType.BoolResult)
                            .setValue(ByteString.copyFrom("{num: event.uid} == 3".getBytes()))
                            .build())
                        .setNextStep("step_end_3"))
                    .addBranches(ConditionExecution.newBuilder()
                        .setCondition(Expr.newBuilder()
                            .setType(ExprResultType.BoolResult)
                            .setValue(ByteString.copyFrom("{num: event.uid} == 4".getBytes()))
                            .build())
                        .setNextStep("step_end_4"))
                    .build())
                .build())
            .addSteps(Step.newBuilder()
                .setName("step_end_1")
                .setExecution(Execution.newBuilder()
                    .setType(ExectuionType.Direct)
                    .setDirect(DirectExecution.newBuilder().build())
                    .build()))
            .addSteps(Step.newBuilder()
                .setName("step_end_4")
                .setExecution(Execution.newBuilder()
                    .setType(ExectuionType.Direct)
                    .setDirect(DirectExecution.newBuilder().build())
                    .build()))
            .build()).get().checkError();

        Thread.sleep(2000);
        System.out.println(c.countState(1000).get().countStateResponse());

        c.stopInstance(1000).get();

        Thread.sleep(1000);
        WorkflowInstance last = c.lastInstance(1000).get().lastInstanceResponse();
        System.out.println(last);
        System.out.println(c.historyInstance(1000, last.getInstanceID()).get().historyInstanceResponse());

    }

    public static void timerWorkflow(Client c) throws ExecutionException, InterruptedException {
//        c.initTenant(1, 2).get().checkError();
//        Thread.sleep(15000);
        Workflow wf = Workflow.newBuilder()
            .setId(3000)
            .setName("fagongzi_test1")
            .setTenantID(1)
            .addSteps(Step.newBuilder()
                .setName("step-0")
                .setExecution(Execution.newBuilder()
                    .setType(ExectuionType.Timer)
                    .setTimer(TimerExecution.newBuilder()
                        .setCron("* */1 * * * *")
                        .setCondition(Expr.newBuilder()
                            .setValue(ByteString.copyFrom("((${num: func.date} >= 20200203) && (${num: func.date} <= 20200808)) && ((${num: func.time} >= 014011) && (${num: func.time} <= 234011))".getBytes()))
                            .build())
                        .setNextStep("step_end")
                        .setUseStepCrowdToDrive(true)
                        .build())
                    .build())
                .build())
            .addSteps(Step.newBuilder()
                .setName("step_end")
                .setExecution(Execution.newBuilder()
                    .setType(ExectuionType.Direct)
                    .setDirect(DirectExecution.newBuilder().build())
                    .build()))
            .build();
        c.startInstance(wf, RoaringBitmap.bitmapOf(1, 2, 3), 4).get().checkError();
        Thread.sleep(3000);
        System.out.println(c.countState(2000).get().countStateResponse());
    }
}
