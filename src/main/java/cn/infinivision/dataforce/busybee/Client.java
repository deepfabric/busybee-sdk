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
import cn.infinivision.dataforce.busybee.pb.meta.Tenant;
import cn.infinivision.dataforce.busybee.pb.meta.TenantQueue;
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
import cn.infinivision.dataforce.busybee.pb.rpc.ConditionGroup;
import cn.infinivision.dataforce.busybee.pb.rpc.DeleteIfRequest;
import cn.infinivision.dataforce.busybee.pb.rpc.DeleteRequest;
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
import cn.infinivision.dataforce.busybee.pb.rpc.ScanMappingRequest;
import cn.infinivision.dataforce.busybee.pb.rpc.ScanRequest;
import cn.infinivision.dataforce.busybee.pb.rpc.SetIfRequest;
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
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Lock;
import java.util.function.BiConsumer;
import java.util.stream.IntStream;
import lombok.extern.slf4j.Slf4j;
import org.roaringbitmap.RoaringBitmap;

/**
 * busybee java client
 *
 * @author fagongzi
 */
@Slf4j(topic = "busybee")
public class Client implements Closeable {
    AtomicLong id = new AtomicLong(0);
    Transport transport;
    Options opts;
    private Map<String, Consumer> fetchWorkers = new HashMap<>();
    private ScheduledExecutorService schedulers;
    private CtxHolder holder;

    Client(Transport transport, CtxHolder holder, Options opts) {
        this.transport = transport;
        this.opts = opts;
        this.holder = holder;
        schedulers = Executors.newScheduledThreadPool(opts.fetchSchedulers);
    }

    @Override
    public synchronized void close() throws IOException {
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
     * get a distributed lock to protect resource
     *
     * @param resource target resource
     * @param lease lease seconds
     * @return lock
     */
    public Lock getResourceLock(String resource, int lease) {
        return new Locker(resource, this, lease);
    }

    /**
     * alloc a unsigned int range [from, to]
     *
     * @param key key
     * @param batch value
     * @return Future Result, use {@link Result#unsignedIntRangeResponse()} to get a unsigned int range response
     */
    public Future<Result> allocId(String key, long batch) {
        Request req = Request.newBuilder()
            .setId(id.incrementAndGet())
            .setType(Type.AllocID)
            .setAllocID(AllocIDRequest.newBuilder()
                .setKey(ByteString.copyFromUtf8(key))
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
    public Future<Result> resetId(String key) {
        Request req = Request.newBuilder()
            .setId(id.incrementAndGet())
            .setType(Type.ResetID)
            .setResetID(ResetIDRequest.newBuilder()
                .setKey(ByteString.copyFromUtf8(key))
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
    public Future<Result> currentId(String key) {
        return get(key);
    }

    /**
     * reset id generator with start value
     *
     * @param key key
     * @param startWith start value
     * @return Future Result, use {@link Result#checkError} to check has a error
     */
    public Future<Result> resetId(String key, long startWith) {
        Request req = Request.newBuilder()
            .setId(id.incrementAndGet())
            .setType(Type.ResetID)
            .setResetID(ResetIDRequest.newBuilder()
                .setKey(ByteString.copyFromUtf8(key))
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
    public Future<Result> set(String key, byte[] value) {
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
    public Future<Result> set(String key, byte[] value, long ttl) {
        Request req = Request.newBuilder()
            .setId(id.incrementAndGet())
            .setType(Type.Set)
            .setSet(SetRequest.newBuilder()
                .setKey(ByteString.copyFromUtf8(key))
                .setValue(ByteString.copyFrom(value))
                .setTtl(ttl)
                .build())
            .build();
        return doRequest(req);
    }

    /**
     * set the key-value with a ttl in seconds if the condition matched
     *
     * @param key key
     * @param value value
     * @param ttl ttl in seconds
     * @param groups conditions
     * @return Future Result, use {@link Result#booleanResponse()} to check the operation succeed
     */
    public Future<Result> setIf(String key, byte[] value, long ttl, List<ConditionGroup> groups) {
        Request req = Request.newBuilder()
            .setId(id.incrementAndGet())
            .setType(Type.SetIf)
            .setSetIf(SetIfRequest.newBuilder()
                .setKey(ByteString.copyFromUtf8(key))
                .setValue(ByteString.copyFrom(value))
                .setTtl(ttl)
                .addAllConditions(groups)
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
    public Future<Result> get(String key) {
        Request req = Request.newBuilder()
            .setId(id.incrementAndGet())
            .setType(Type.Get)
            .setGet(GetRequest.newBuilder()
                .setKey(ByteString.copyFromUtf8(key))
                .build())
            .build();

        return doRequest(req);
    }

    private Future<Result> get(byte[] key) {
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
     * @return Future Result, use {@link Result#booleanResponse()} to check has a error
     */
    public Future<Result> delete(String key) {
        Request req = Request.newBuilder()
            .setId(id.incrementAndGet())
            .setType(Type.Delete)
            .setDelete(DeleteRequest.newBuilder()
                .setKey(ByteString.copyFromUtf8(key))
                .build())
            .build();

        return doRequest(req);
    }

    /**
     * delete the key if the conditions matches
     *
     * @param key key
     * @param groups conditions
     * @return Future Result, use {@link Result#checkError} to check the operation succeed
     */
    public Future<Result> deleteIf(String key, List<ConditionGroup> groups) {
        Request req = Request.newBuilder()
            .setId(id.incrementAndGet())
            .setType(Type.DeleteIf)
            .setDeleteIf(DeleteIfRequest.newBuilder()
                .setKey(ByteString.copyFromUtf8(key))
                .addAllConditions(groups)
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
    public Future<Result> setBitmap(String key, RoaringBitmap bm) {
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
    public Future<Result> getBitmap(String key) {
        return get(key);
    }

    /**
     * add ints to a bitmap
     *
     * @param key key
     * @param values uint32 array
     * @return Future Result, use {@link Result#checkError} to check has a error
     */
    public Future<Result> addToBitmap(String key, Long... values) {
        Request req = Request.newBuilder()
            .setId(id.incrementAndGet())
            .setType(Type.BMCreate)
            .setBmCreate(BMCreateRequest.newBuilder()
                .setKey(ByteString.copyFromUtf8(key))
                .addAllValue(Arrays.asList(values))
                .build())
            .build();

        return doRequest(req);
    }

    /**
     * add ints to a bitmap
     *
     * @param key key
     * @param mod [from, to] which mod this == 0
     * @param from from, include
     * @param to to, include
     * @return Future Result, use {@link Result#checkError} to check has a error
     */
    public Future<Result> addToBitmap(String key, long mod, long from, long to) {
        Request req = Request.newBuilder()
            .setId(id.incrementAndGet())
            .setType(Type.BMCreate)
            .setBmCreate(BMCreateRequest.newBuilder()
                .setKey(ByteString.copyFromUtf8(key))
                .setMod(mod)
                .addValue(from)
                .addValue(to)
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
    public Future<Result> removeFromBitmap(String key, Long... values) {
        Request req = Request.newBuilder()
            .setId(id.incrementAndGet())
            .setType(Type.BMRemove)
            .setBmRemove(BMRemoveRequest.newBuilder()
                .setKey(ByteString.copyFromUtf8(key))
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
    public Future<Result> clearBitmap(String key) {
        Request req = Request.newBuilder()
            .setId(id.incrementAndGet())
            .setType(Type.BMClear)
            .setBmClear(BMClearRequest.newBuilder()
                .setKey(ByteString.copyFromUtf8(key))
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
    public Future<Result> countOfBitmap(String key) {
        Request req = Request.newBuilder()
            .setId(id.incrementAndGet())
            .setType(Type.BMCount)
            .setBmCount(BMCountRequest.newBuilder()
                .setKey(ByteString.copyFromUtf8(key))
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
    public Future<Result> inBitmap(String key, Long... values) {
        Request req = Request.newBuilder()
            .setId(id.incrementAndGet())
            .setType(Type.BMContains)
            .setBmContains(BMContainsRequest.newBuilder()
                .setKey(ByteString.copyFromUtf8(key))
                .addAllValue(Arrays.asList(values))
                .build())
            .build();

        return doRequest(req);
    }

    /**
     * init tenant, create the input and output queues
     *
     * @param metadata tenant metadata
     * @return Future Result, use {@link Result#checkError} to check has a error
     */
    public Future<Result> initTenant(Tenant metadata) {
        Request req = Request.newBuilder()
            .setId(id.incrementAndGet())
            .setType(Type.TenantInit)
            .setTenantInit(TenantInitRequest.newBuilder()
                .setMetadata(metadata)
                .build())
            .build();

        return doRequest(req);
    }

    /**
     * start the workflow
     *
     * @param wf workflow
     * @param bm crowd bitmap
     * @return Future Result, use {@link Result#checkError} to check has a error
     */
    public Future<Result> startInstance(Workflow wf, RoaringBitmap bm) {
        byte[] value = new byte[bm.serializedSizeInBytes()];
        bm.serialize(ByteBuffer.wrap(value));

        Request req = Request.newBuilder()
            .setId(id.incrementAndGet())
            .setType(Type.StartingInstance)
            .setStartInstance(StartingInstanceRequest.newBuilder()
                .setInstance(WorkflowInstance.newBuilder()
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
     * @return Future Result, use {@link Result#checkError} to check has a error
     */
    public Future<Result> startInstanceWithCK(Workflow wf, String sql) {
        Request req = Request.newBuilder()
            .setId(id.incrementAndGet())
            .setType(Type.StartingInstance)
            .setStartInstance(StartingInstanceRequest.newBuilder()
                .setInstance(WorkflowInstance.newBuilder()
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
     * @return Future Result, use {@link Result#checkError} to check has a error
     */
    public Future<Result> startInstanceWithKV(Workflow wf, String key) {
        Request req = Request.newBuilder()
            .setId(id.incrementAndGet())
            .setType(Type.StartingInstance)
            .setStartInstance(StartingInstanceRequest.newBuilder()
                .setInstance(WorkflowInstance.newBuilder()
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
     * @param group consumer group
     * @param callback callback
     * @param asyncCommit async commit offset
     */
    public synchronized void watchNotify(long tenantId, String group,
        BiConsumer<QueueID, Notify> callback, boolean asyncCommit) {
        watchNotify(tenantId, group, callback, null, asyncCommit);
    }

    /**
     * watch the notifies of the giving tenantId
     *
     * @param tenantId tenant id
     * @param group consumer group
     * @param callback batch callback
     * @param asyncCommit async commit offset
     */
    public synchronized void watchNotifyWithBatch(long tenantId, String group,
        BiConsumer<QueueID, List<Notify>> callback, boolean asyncCommit) {
        watchNotify(tenantId, group, null, callback, asyncCommit);
    }

    private synchronized void watchNotify(long tenantId, String group,
        BiConsumer<QueueID, Notify> callback,
        BiConsumer<QueueID, List<Notify>> batchCallback, boolean asyncCommit) {
        String key = tenantId + "/" + group;
        if (fetchWorkers.containsKey(key)) {
            log.warn("tenant {} already in watching", key);
            return;
        }

        Consumer w = new Consumer(this, tenantId, group,
            callback, batchCallback,
            schedulers, asyncCommit);
        fetchWorkers.putIfAbsent(key, w);
        w.start();
    }

    /**
     * stop watch the notifies
     *
     * @param tenantId tenant id
     * @param group consumer group
     */
    public synchronized void stopWatchNotify(long tenantId, String group) {
        String key = tenantId + "/" + group;
        Consumer w = fetchWorkers.remove(tenantId);
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

    public static void main6(String[] args) throws ExecutionException, InterruptedException {
        Client c = new Builder().rpcTimeout(5000).addServer("172.19.0.106:8091").build();

        RoaringBitmap bm = new RoaringBitmap();
        c.watchNotify(1, "ccccc1", (id, nt) -> {
            if (nt.getToStep().startsWith("2515196f-aa8e-46d6-ade2-5b59862649f0")) {
                if (nt.getUserID() > 0) {
                    bm.add((int) nt.getUserID());
                } else {
                    RoaringBitmap bm2 = new RoaringBitmap();
                    try {
                        bm2.deserialize(nt.getCrowd().asReadOnlyByteBuffer());
                        bm.or(bm2);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println("############################# count: " + bm.getCardinality());
            }
        }, false);
    }

    public static void main11(String[] args) {
        final RoaringBitmap bm = new RoaringBitmap();
        for (int i = 0; i < 400000000L; i++) {
            if (i % 3 == 0) {
                bm.add(i);
            }
        }

        System.out.println(bm.getCardinality());
        System.out.println(bm.serializedSizeInBytes());
    }

    public static void main13(String[] args) {
        Client c = new Builder().rpcTimeout(100000).fetchSize(1).addServer("172.21.246.250:8081").build();
        for (int i = 1; i <= 1000000; i++) {
            c.addEvent(1, i);
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Client c = new Builder().rpcTimeout(5000).fetchSize(1).addServer("172.18.211.95:8081").build();

        int n = 3;
        if (n == 1) {
            c.initTenant(Tenant.newBuilder()
                .setId(1)
                .setRunners(16)
                .setInput(TenantQueue.newBuilder().setPartitions(5).setConsumerTimeout(60).setMaxAlive(100).setCleanBatch(4096).build())
                .setOutput(TenantQueue.newBuilder().setPartitions(5).setConsumerTimeout(60).setMaxAlive(100).setCleanBatch(4096).build())
                .build()).get().checkError();
            System.exit(0);
        } else if (n == 2) {
            String key = "bm1";
            c.addToBitmap(key, 1, 1, 100000000).get().checkError();
            Workflow value = Workflow
                .newBuilder()
                .setId(1)
                .setTenantID(1)
                .setName("test")
                .addSteps(
                    Step.newBuilder()
                        .setName("step_start")
                        .setExecution(
                            Execution.newBuilder()
                                .setType(ExectuionType.Branch)
                                .addBranches(ConditionExecution.newBuilder()
                                    .setCondition(Expr.newBuilder().setValue(ByteString.copyFromUtf8("{num: dyna.kv_%s.event.uid} == 1")).build())
                                    .setNextStep("step_end")
                                    .build())
                                .addBranches(ConditionExecution.newBuilder()
                                    .setCondition(Expr.newBuilder().setValue(ByteString.copyFromUtf8("1 == 1")).build())
                                    .setNextStep("step_end")
                                    .build())))
                .addSteps(Step.newBuilder()
                    .setName("step_end")
                    .setExecution(
                        Execution.newBuilder()
                            .setType(ExectuionType.Direct)
                            .setDirect(DirectExecution.newBuilder().build())
                            .build())
                    .build())
                .build();

//            c.updateWorkflow(value).get().checkError();
            c.startInstanceWithKV(value, key).get().checkError();
            System.exit(0);
        } else if (n == 3) {
            for (int i = 1; i <= 100000000; i++) {
                c.addEvent(1, i);
                if (i > 0 && i % 20000 == 0) {
                    Thread.sleep(2000);
                }
            }
        } else if (n == 4) {
            for (int i = 1; i <= 1000; i++) {
                String s = i + "";
                c.set(s, s.getBytes());
                if (i > 0 && i % 1000 == 0) {
                    Thread.sleep(1000);
                }
            }
        } else {
            c.stopInstance(1).get().checkError();
            Thread.sleep(10000);

            Workflow value = Workflow
                .newBuilder()
                .setId(2)
                .setTenantID(1)
                .setName("test")
                .addSteps(
                    Step.newBuilder()
                        .setName("step_start")
                        .setExecution(
                            Execution.newBuilder()
                                .setType(ExectuionType.Timer)
                                .setTimer(TimerExecution.newBuilder()
                                    .setUseStepCrowdToDrive(true)
                                    .setCondition(Expr.newBuilder()
                                        .setType(ExprResultType.BoolResult)
                                        .setValue(ByteString.copyFromUtf8("1==1"))
                                        .build())
                                    .setCron("0 */1 * * * *")
                                    .setNextStep("step_end")
                                    .build())))
                .addSteps(Step.newBuilder()
                    .setName("step_end")
                    .setExecution(
                        Execution.newBuilder()
                            .setType(ExectuionType.Direct)
                            .setDirect(DirectExecution.newBuilder().build())
                            .build())
                    .build())
                .build();

            final RoaringBitmap bitmap = new RoaringBitmap();
            IntStream.range(1, 10001).forEach(e -> bitmap.add(e));
            c.startInstance(value, bitmap).get().checkError();
            System.exit(0);
        }

//        c.watchNotify(1, "g1", (id, nt) -> {
//            log.info("{}/{}: {}",
//                id.getPartition(), id.getOffset(), nt.toString());
//            try {
//                Thread.sleep(10000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
    }

    public static void main4(String[] args) throws ExecutionException, InterruptedException {
        Client c = new Builder().rpcTimeout(30000).addServer("172.18.80.9:8081").build();
        int n = 2;
        if (n == 1) {
            c.initTenant(Tenant.newBuilder()
                .setId(1)
                .setOutput(TenantQueue.newBuilder().setPartitions(2).setConsumerTimeout(5).build())
                .build()).get().checkError();
            Thread.sleep(20000);

            Workflow.Builder workflowBuilder = Workflow
                .newBuilder()
                .setId(1)
                .setTenantID(1)
                .setName("测试")
                .addSteps(
                    Step.newBuilder()
                        .setName("开始")
                        .setExecution(
                            Execution.newBuilder()
                                .setType(ExectuionType.Timer)
                                .setTimer(TimerExecution.newBuilder()
                                    .setUseStepCrowdToDrive(true)
                                    .setCondition(Expr.newBuilder()
                                        .setType(ExprResultType.BoolResult)
                                        .setValue(ByteString.copyFromUtf8("1==1"))
                                        .build())
                                    .setCron("0 */1 * * * *")
                                    .setNextStep("优惠券")
                                    .build())
                        )
                )
                .addSteps(
                    Step.newBuilder()
                        .setName("优惠券")
                        .setExecution(
                            Execution.newBuilder()
                                .setType(ExectuionType.Branch)
                                .addBranches(ConditionExecution.newBuilder()
                                    .setCondition(Expr.newBuilder()
                                        .setType(ExprResultType.BoolResult)
                                        .setValue(ByteString.copyFromUtf8("{str: event.__stepName__} == \"优惠券\""))
                                        .build())
                                    .setNextStep("是否领取优惠券")
                                    .build())
                                .addBranches(ConditionExecution.newBuilder()
                                    .setCondition(Expr.newBuilder()
                                        .setType(ExprResultType.BoolResult)
                                        .setValue(ByteString.copyFromUtf8("1!=1"))
                                        .build())
                                    .build())
                        )
                )
                .addSteps(
                    Step.newBuilder()
                        .setName("是否领取优惠券")
                        .setExecution(
                            Execution.newBuilder()
                                .setType(ExectuionType.Branch)
                                .addBranches(ConditionExecution.newBuilder()
                                    .setCondition(Expr.newBuilder()
                                        .setType(ExprResultType.BoolResult)
                                        .setValue(ByteString.copyFromUtf8("{str: event.eventName} == \"领取优惠券\""))
                                        .build())
                                    .build())
                                .addBranches(ConditionExecution.newBuilder()
                                    .setCondition(Expr.newBuilder()
                                        .setType(ExprResultType.BoolResult)
                                        .setValue(ByteString.copyFromUtf8("1!=1"))
                                        .build())
                                    .build())
                        )
                );  // 省略后续的流程步骤
            workflowBuilder.setStopAt(new Date().getTime() + 10 * 60 * 60);
            final RoaringBitmap bitmap = new RoaringBitmap();
            IntStream.range(1, 10001).forEach(e -> bitmap.add(e));
            c.startInstance(workflowBuilder.build(), bitmap).get().checkError();
        } else {
            for (int i = 0; i < 5000; i++) {
                System.out.println(i);
                c.addEvent(1, i, "__stepName__".getBytes(), "优惠券".getBytes()).get().checkError();
            }
        }
    }

    public static void main3(String[] args) throws ExecutionException, InterruptedException, IOException {
        Client c = new Builder().rpcTimeout(5000).addServer("172.18.85.9:8081").build();
        int n = 2;
        if (n == 1) {
            c.initTenant(Tenant.newBuilder()
                .setId(1)
                .setOutput(TenantQueue.newBuilder().setPartitions(2).setConsumerTimeout(15).build())
                .build()).get().checkError();
            Thread.sleep(20000);
            long wid = 1001;
            Workflow wf = Workflow.newBuilder()
                .setId(wid)
                .setName("test")
                .setTenantID(1)
                .addSteps(Step.newBuilder()
                    .setName("start")
                    .setExecution(Execution.newBuilder()
                        .setType(ExectuionType.Branch)
                        .addBranches(ConditionExecution.newBuilder()
                            .setCondition(Expr.newBuilder()
                                .setValue(ByteString.copyFrom("{num: event.data} % 2 == 0".getBytes()))
                                .build())
                            .setNextStep("end1"))
                        .addBranches(ConditionExecution.newBuilder()
                            .setCondition(Expr.newBuilder()
                                .setType(ExprResultType.BoolResult)
                                .setValue(ByteString.copyFrom("{num: event.data} % 2 != 0".getBytes()))
                                .build())
                            .setNextStep("end2"))
                        .build())
                    .build())
                .addSteps(Step.newBuilder()
                    .setName("end1")
                    .setExecution(Execution.newBuilder()
                        .setType(ExectuionType.Direct)
                        .setDirect(DirectExecution.newBuilder().build())
                        .build()))
                .addSteps(Step.newBuilder()
                    .setName("end2")
                    .setExecution(Execution.newBuilder()
                        .setType(ExectuionType.Direct)
                        .setDirect(DirectExecution.newBuilder().build())
                        .build()))
                .build();

            RoaringBitmap bm = new RoaringBitmap();
            for (int i = 1; i <= 10000; i++) {
                bm.add(i);
            }
            c.startInstance(wf, bm).get().checkError();

            for (int i = 1; i < 100; i++) {
                c.addEvent(1, i, "data".getBytes(), String.valueOf(i).getBytes()).get().checkError();
            }
        }

        if (n == 2) {
            c.watchNotify(1, "g1", (id, nt) -> {
                log.info("*********** received  {}/{}", id.getPartition(), id.getOffset());
                throw new RuntimeException("aaaaaaaaaaaaaaaaa");
            }, false);
        }
    }

    public static void keys(Client c) throws ExecutionException, InterruptedException {
        for (int i = 0; i < 10; i++) {
            c.set(("key0" + i), ("value" + i).getBytes()).get().checkError();
        }

        System.out.println(c.scanKeys("key0".getBytes(), "key1".getBytes(), 10).get().bytesListResponse());
    }

    public static void alloc(Client c) throws ExecutionException, InterruptedException {
        String key = "key-id";

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
        String key = "key1";

        c.addToBitmap(key, 1L, 2L, 3L, 4L, 5L).get().checkError();
        System.out.println(c.getBitmap(key).get().bitmapResponse().getCardinality());
    }

    public static void workflowWithBigBM(Client c) throws ExecutionException, InterruptedException {
        String key = "bm1";
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

        c.initTenant(Tenant.newBuilder()
            .setId(1)
            .setOutput(TenantQueue.newBuilder().setPartitions(2).setConsumerTimeout(60).build())
            .build()).get().checkError();
        Thread.sleep(15000);
        c.startInstanceWithKV(wf, "bm1").get().checkError();
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
        c.initTenant(Tenant.newBuilder()
            .setId(1)
            .setOutput(TenantQueue.newBuilder().setPartitions(2).setConsumerTimeout(60).build())
            .build()).get().checkError();
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
        c.startInstance(wf, RoaringBitmap.bitmapOf(1, 2, 3)).get().checkError();
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
        c.initTenant(Tenant.newBuilder()
            .setId(1)
            .setOutput(TenantQueue.newBuilder().setPartitions(2).setConsumerTimeout(60).build())
            .build()).get().checkError();
        Thread.sleep(15000);
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

        RoaringBitmap bm = RoaringBitmap.bitmapOf();
        for (int i = 1; i <= 10000; i++) {
            bm.add(i);
        }

        c.startInstance(wf, bm).get().checkError();
    }
}
