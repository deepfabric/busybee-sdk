// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: rpc.proto

package cn.infinivision.dataforce.busybee.pb.rpc;

public interface QueueScanRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:rpcpb.QueueScanRequest)
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
   * <code>uint32 partition = 3;</code>
   */
  int getPartition();

  /**
   * <code>bytes consumer = 4;</code>
   */
  com.google.protobuf.ByteString getConsumer();

  /**
   * <code>uint64 completedOffset = 5;</code>
   */
  long getCompletedOffset();

  /**
   * <code>uint64 count = 6;</code>
   */
  long getCount();

  /**
   * <code>uint64 maxBytes = 7;</code>
   */
  long getMaxBytes();
}
