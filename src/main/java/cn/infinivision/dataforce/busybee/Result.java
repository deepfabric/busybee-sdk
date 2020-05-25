package cn.infinivision.dataforce.busybee;

import cn.infinivision.dataforce.busybee.pb.meta.IDSet;
import cn.infinivision.dataforce.busybee.pb.meta.InstanceCountState;
import cn.infinivision.dataforce.busybee.pb.meta.StepState;
import cn.infinivision.dataforce.busybee.pb.meta.WorkflowInstance;
import cn.infinivision.dataforce.busybee.pb.meta.WorkflowInstanceSnapshot;
import cn.infinivision.dataforce.busybee.pb.rpc.Response;
import com.google.protobuf.InvalidProtocolBufferException;
import io.aicloud.tools.netty.util.BytesUtils;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.roaringbitmap.RoaringBitmap;

/**
 * RPC Result
 *
 * @author fagongzi
 */
@Slf4j(topic = "busybee")
public class Result {
    private Response resp;
    private RuntimeException err;
    private CountDownLatch countDownLatch = new CountDownLatch(1);

    /**
     * throw a {@link RuntimeException} if has en error
     */
    public void checkError() {
        if (err != null) {
            log.error("option failed", err);
            throw err;
        }
    }

    /**
     * bitmap response, and throw a {@link RuntimeException} if has en error
     *
     * @return bitmap
     */
    public RoaringBitmap bitmapResponse() {
        byte[] value = bytesResponse();

        RoaringBitmap bm = RoaringBitmap.bitmapOf();
        try {
            bm.deserialize(ByteBuffer.wrap(value));
            return bm;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * InstanceCountState response, and throw a {@link RuntimeException} if has en error
     *
     * @return InstanceCountState
     */
    public InstanceCountState countStateResponse() {
        InstanceCountState value = null;
        try {
            value = InstanceCountState.parseFrom(bytesResponse());
        } catch (InvalidProtocolBufferException e) {
            throw new RuntimeException(e);
        }
        return value;
    }

    /**
     * StepState response, and throw a {@link RuntimeException} if has en error
     *
     * @return StepState
     */
    public StepState stepCrowdStateResponse() {
        StepState value = null;
        try {
            value = StepState.parseFrom(bytesResponse());
        } catch (InvalidProtocolBufferException e) {
            throw new RuntimeException(e);
        }
        return value;
    }

    /**
     * string response, and throw a {@link RuntimeException} if has en error
     *
     * @return string
     */
    public String stringResponse() {
        return new String(bytesResponse());
    }

    /**
     * byte array response, and throw a {@link RuntimeException} if has en error
     *
     * @return byte array
     */
    public byte[] bytesResponse() {
        checkError();

        if (resp.hasBytesResp()) {
            return resp.getBytesResp().getValue().toByteArray();
        }

        throw new IllegalAccessError("the response is not bytes response");
    }

    /**
     * byte array slice response, and throw a {@link RuntimeException} if has en error
     *
     * @return byte string array
     */
    public List<byte[]> bytesListResponse() {
        checkError();

        if (resp.hasBytesSliceResp()) {
            return resp.getBytesSliceResp().getValuesList().stream()
                .map(e -> e.toByteArray())
                .collect(Collectors.toList());
        }

        throw new IllegalAccessError("the response is not bytes slice response");
    }

    /**
     * byte array slice response, and throw a {@link RuntimeException} if has en error
     *
     * @return byte string array
     */
    public List<byte[]> bytesKeyListResponse() {
        checkError();

        if (resp.hasBytesSliceResp()) {
            return resp.getBytesSliceResp().getKeysList().stream()
                .map(e -> e.toByteArray())
                .collect(Collectors.toList());
        }

        throw new IllegalAccessError("the response is not bytes slice response");
    }

    /**
     * unsigned int response, and throw a {@link RuntimeException} if has en error
     *
     * @return unsigned int
     */
    public long unsignedIntResponse() {
        checkError();

        if (resp.hasBytesResp()) {
            if (resp.getBytesResp().getValue().size() == 0) {
                return 0;
            }

            return BytesUtils.byte2UnsignedInt(resp.getBytesResp().getValue().toByteArray());
        }

        throw new IllegalAccessError("the response is not unsigned int response");
    }

    /**
     * unsigned int array response, and throw a {@link RuntimeException} if has en error
     *
     * @return [from, to] range
     */
    public long[] unsignedIntRangeResponse() {
        checkError();

        if (resp.hasUint32RangeResp()) {
            return new long[] {
                resp.getUint32RangeResp().getFrom(),
                resp.getUint32RangeResp().getTo()};
        }

        throw new IllegalAccessError("the response is not unsigned int range response");
    }

    /**
     * long response, and throw a {@link RuntimeException} if has en error
     *
     * @return long
     */
    public long longResponse() {
        checkError();

        if (resp.hasUint64Resp()) {
            return resp.getUint64Resp().getValue();
        }

        throw new IllegalAccessError("the response is not long response");
    }

    /**
     * boolean response, and throw a {@link RuntimeException} if has en error
     *
     * @return boolean
     */
    public boolean booleanResponse() {
        checkError();

        if (resp.hasBoolResp()) {
            return resp.getBoolResp().getValue();
        }

        throw new IllegalAccessError("the response is not boolean response");
    }

    /**
     * id set list response, and throw a {@link RuntimeException} if has en error
     *
     * @return id set list
     */
    public List<IDSet> idSetListResponse() {
        checkError();

        if (resp.hasBytesSliceResp()) {
            List<IDSet> value = new ArrayList<>(resp.getBytesSliceResp().getValuesCount());
            resp.getBytesSliceResp().getValuesList().forEach(e -> {
                try {
                    value.add(IDSet.parseFrom(e));
                } catch (InvalidProtocolBufferException e1) {
                    log.error("parse failed", e);
                }
            });

            return value;
        }

        throw new IllegalAccessError("the response is not id set list response");
    }

    /**
     * last instance response, and throw a {@link RuntimeException} if has en error
     *
     * @return last workflow instance
     */
    public WorkflowInstance lastInstanceResponse() {
        checkError();

        if (resp.hasBytesResp()) {
            try {
                return WorkflowInstance.parseFrom(resp.getBytesResp().getValue());
            } catch (InvalidProtocolBufferException e) {
                throw new RuntimeException(e);
            }
        }

        throw new IllegalAccessError("the response is not last instance response");
    }

    /**
     * history instance response, and throw a {@link RuntimeException} if has en error
     *
     * @return history workflow instance result
     */
    public WorkflowInstanceSnapshot historyInstanceResponse() {
        checkError();

        if (resp.hasBytesResp()) {
            try {
                return WorkflowInstanceSnapshot.parseFrom(resp.getBytesResp().getValue());
            } catch (InvalidProtocolBufferException e) {
                throw new RuntimeException(e);
            }
        }

        throw new IllegalAccessError("the response is not history instance response");
    }

    /**
     * id set response, and throw a {@link RuntimeException} if has en error
     *
     * @return id set
     */
    public IDSet idSetResponse() {
        checkError();

        if (resp.hasBytesResp()) {
            try {
                return IDSet.parseFrom(resp.getBytesResp().getValue());
            } catch (InvalidProtocolBufferException e) {
                throw new RuntimeException(e);
            }
        }

        throw new IllegalAccessError("the response is not id set response");
    }

    void done(Response resp) {
        if (resp.hasError() &&
            null != resp.getError().getError() &&
            !resp.getError().getError().isEmpty()) {
            err = new RuntimeException(resp.getError().getError());
        } else {
            this.resp = resp;
        }

        countDownLatch.countDown();
    }

    void done(Throwable err) {
        this.err = new RuntimeException(err);
        countDownLatch.countDown();
    }

    void waitComplete() {
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            err = new RuntimeException(e);
        }
    }
}
