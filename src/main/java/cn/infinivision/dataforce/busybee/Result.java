package cn.infinivision.dataforce.busybee;

import cn.infinivision.dataforce.busybee.pb.meta.InstanceCountState;
import cn.infinivision.dataforce.busybee.pb.meta.StepState;
import cn.infinivision.dataforce.busybee.pb.rpc.Response;
import com.google.protobuf.InvalidProtocolBufferException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.CountDownLatch;
import org.roaringbitmap.RoaringBitmap;

/**
 * RPC Result
 *
 * @author fagongzi
 */
public class Result {
    private Response resp;
    private RuntimeException err;
    private CountDownLatch countDownLatch = new CountDownLatch(1);

    /**
     * throw a {@link RuntimeException} if has en error
     */
    public void checkError() {
        if (err != null) {
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
     * long response, and throw a {@link RuntimeException} if has en error
     *
     * @return long
     */
    public long longResponse() {
        checkError();

        if (resp.hasUint64Resp()) {
            return resp.getUint64Resp().getValue();
        }

        throw new IllegalAccessError("the response is not bytes response");
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

    void done(Response resp) {
        if (resp.hasError()) {
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
