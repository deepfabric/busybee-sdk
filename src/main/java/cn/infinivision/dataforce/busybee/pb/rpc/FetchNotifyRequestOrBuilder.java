// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: rpc.proto

package cn.infinivision.dataforce.busybee.pb.rpc;

public interface FetchNotifyRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:rpcpb.FetchNotifyRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>uint64 id = 1;</code>
   */
  long getId();

  /**
   * <code>uint64 after = 2;</code>
   */
  long getAfter();

  /**
   * <code>uint64 count = 3;</code>
   */
  long getCount();

  /**
   * <code>string consumer = 4;</code>
   */
  java.lang.String getConsumer();
  /**
   * <code>string consumer = 4;</code>
   */
  com.google.protobuf.ByteString
      getConsumerBytes();
}
