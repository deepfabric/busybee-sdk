package cn.infinivision.dataforce.busybee;

import cn.infinivision.dataforce.busybee.pb.api.Request;
import cn.infinivision.dataforce.busybee.pb.meta.InstanceCountState;
import cn.infinivision.dataforce.busybee.pb.meta.StepState;
import cn.infinivision.dataforce.busybee.pb.meta.Workflow;
import cn.infinivision.dataforce.busybee.pb.meta.WorkflowInstance;
import cn.infinivision.dataforce.busybee.pb.rpc.BMAddRequest;
import cn.infinivision.dataforce.busybee.pb.rpc.BMClearRequest;
import cn.infinivision.dataforce.busybee.pb.rpc.BMContainsRequest;
import cn.infinivision.dataforce.busybee.pb.rpc.BMCountRequest;
import cn.infinivision.dataforce.busybee.pb.rpc.BMRemoveRequest;
import cn.infinivision.dataforce.busybee.pb.rpc.DeleteRequest;
import cn.infinivision.dataforce.busybee.pb.rpc.GetRequest;
import cn.infinivision.dataforce.busybee.pb.rpc.InstanceCountStateRequest;
import cn.infinivision.dataforce.busybee.pb.rpc.InstanceCrowdStateRequest;
import cn.infinivision.dataforce.busybee.pb.rpc.SetRequest;
import cn.infinivision.dataforce.busybee.pb.rpc.StartingInstanceRequest;
import cn.infinivision.dataforce.busybee.pb.rpc.StopInstanceRequest;
import cn.infinivision.dataforce.busybee.pb.rpc.TenantInitRequest;
import com.google.protobuf.ByteString;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicLong;
import org.roaringbitmap.RoaringBitmap;

/**
 * busybee java client
 *
 * @author fagongzi
 */
public class Client {
    private AtomicLong id = new AtomicLong(0);
    private Transport transport;

    Client(Transport transport) {
        this.transport = transport;
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
            Request req = Request.newBuilder().setId(id.incrementAndGet()).
                setSet(SetRequest.newBuilder().setKey(ByteString.copyFrom(key)).
                    setValue(ByteString.copyFrom(value)).build()).build();

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
            Request req = Request.newBuilder().setId(id.incrementAndGet()).
                setGet(GetRequest.newBuilder().setKey(ByteString.copyFrom(key)).build()).build();

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
            Request req = Request.newBuilder().setId(id.incrementAndGet()).
                setDelete(DeleteRequest.newBuilder().setKey(ByteString.copyFrom(key)).build()).build();

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
            Request req = Request.newBuilder().setId(id.incrementAndGet()).
                setBmAdd(BMAddRequest.newBuilder().setKey(ByteString.copyFrom(key)).
                    addAllValue(Arrays.asList(values)).build()).build();

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
            Request req = Request.newBuilder().setId(id.incrementAndGet()).
                setBmRemove(BMRemoveRequest.newBuilder().setKey(ByteString.copyFrom(key)).
                    addAllValue(Arrays.asList(values)).build()).build();

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
            Request req = Request.newBuilder().setId(id.incrementAndGet()).
                setBmClear(BMClearRequest.newBuilder().setKey(ByteString.copyFrom(key)).build()).build();

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
            Request req = Request.newBuilder().setId(id.incrementAndGet()).
                setBmCount(BMCountRequest.newBuilder().setKey(ByteString.copyFrom(key)).build()).build();

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
            Request req = Request.newBuilder().setId(id.incrementAndGet()).
                setBmContains(BMContainsRequest.newBuilder().setKey(ByteString.copyFrom(key)).
                    addAllValue(Arrays.asList(values)).build()).build();

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
            Request req = Request.newBuilder().setId(id.incrementAndGet()).
                setTenantInit(TenantInitRequest.newBuilder().setId(tenantId)
                    .setInputQueuePartitions(inputPartitions).build()).build();

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
            Request req = Request.newBuilder().setId(id.incrementAndGet()).
                setStartInstance(StartingInstanceRequest.newBuilder()
                    .setInstance(WorkflowInstance.newBuilder().setMaxPerShard(maxPerShard)
                        .setSnapshot(wf)
                        .setCrowd(ByteString.copyFrom(value)).build())
                    .build()).build();

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
            Request req = Request.newBuilder().setId(id.incrementAndGet()).
                setStopInstance(StopInstanceRequest.newBuilder()
                    .setWorkflowID(workflowId).build())
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
            Request req = Request.newBuilder().setId(id.incrementAndGet()).
                setCountInstance(InstanceCountStateRequest.newBuilder()
                    .setWorkflowID(workflowId).build())
                .build();

            return doRequest(req);
        });
    }

    /**
     * the crowd step state of the workflow, contains step and crowd users on the step.
     *
     * @param workflowId workflow id
     * @return Future Result, use {@link Result#stepCrowdStateResponse} to get {@link StepState} response
     */
    public Future<Result> stepCrowdState(long workflowId) {
        return CompletableFuture.supplyAsync(() -> {
            Request req = Request.newBuilder().setId(id.incrementAndGet()).
                setCrowdInstance(InstanceCrowdStateRequest.newBuilder()
                    .setWorkflowID(workflowId).build())
                .build();

            return doRequest(req);
        });
    }

    private Result doRequest(Request req) {
        Result result = new Result();
        transport.sent(req, result::done, result::done);
        result.waitComplete();
        return result;
    }
}
