// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: rpc.proto

package cn.infinivision.dataforce.busybee.pb.rpc;

public interface QueueFetchRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:rpcpb.QueueFetchRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>bytes key = 1;</code>
   */
  com.google.protobuf.ByteString getKey();

  /**
   * <code>bytes consumer = 2;</code>
   */
  com.google.protobuf.ByteString getConsumer();

  /**
   * <code>uint64 completedOffset = 3;</code>
   */
  long getCompletedOffset();

  /**
   * <code>uint64 count = 4;</code>
   */
  long getCount();
}
