package cn.infinivision.dataforce.busybee;

import cn.infinivision.dataforce.busybee.pb.api.Response;
import com.google.protobuf.MessageLite;
import io.aicloud.tools.netty.Codec;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import lombok.extern.slf4j.Slf4j;

/**
 * Description:
 * <pre>
 * Date: 2018-10-29
 * Time: 13:09
 * </pre>
 *
 * @author fagongzi
 */
@Slf4j(topic = "busybee")
class RPCCodec implements Codec<MessageLite> {
    static final RPCCodec DEFAULT = new RPCCodec();

    private RPCCodec() {
    }

    @Override
    public MessageLite decode(byte[] value) {
        MessageLite message = null;
        try {
            Response.parseFrom(value);
        } catch (Throwable e) {
            log.error("BUG: decode failed", e);
        }

        return message;
    }

    @Override
    public ByteBuf encode(ByteBufAllocator allocator, MessageLite value) {
        ByteBuf buf = allocator.buffer();
        buf.writeBytes(value.toByteArray());
        return buf;
    }
}
