// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: rpc.proto

package cn.infinivision.dataforce.busybee.pb.rpc;

public interface SetRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:rpcpb.SetRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>bytes key = 1;</code>
   */
  com.google.protobuf.ByteString getKey();

  /**
   * <code>bytes value = 2;</code>
   */
  com.google.protobuf.ByteString getValue();

  /**
   * <code>int64 ttl = 3;</code>
   */
  long getTtl();
}
