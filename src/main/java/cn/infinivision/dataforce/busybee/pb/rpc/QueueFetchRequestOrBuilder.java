// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: rpc.proto

package cn.infinivision.dataforce.busybee.pb.rpc;

public interface QueueFetchRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:rpcpb.QueueFetchRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>uint64 id = 1;</code>
   */
  long getId();

  /**
   * <code>bytes key = 2;</code>
   */
  com.google.protobuf.ByteString getKey();

  /**
   * <code>bytes group = 3;</code>
   */
  com.google.protobuf.ByteString getGroup();

  /**
   * <code>uint32 partition = 4;</code>
   */
  int getPartition();

  /**
   * <code>uint32 consumer = 5;</code>
   */
  int getConsumer();

  /**
   * <code>uint64 version = 6;</code>
   */
  long getVersion();

  /**
   * <code>uint64 completedOffset = 7;</code>
   */
  long getCompletedOffset();

  /**
   * <code>uint64 count = 8;</code>
   */
  long getCount();

  /**
   * <code>uint64 maxBytes = 9;</code>
   */
  long getMaxBytes();
}
