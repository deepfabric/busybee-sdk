// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: rpc.proto

package cn.infinivision.dataforce.busybee.pb.rpc;

public interface GetMappingRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:rpcpb.GetMappingRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>uint64 id = 1;</code>
   */
  long getId();

  /**
   * <code>.metapb.IDValue from = 2;</code>
   */
  boolean hasFrom();
  /**
   * <code>.metapb.IDValue from = 2;</code>
   */
  cn.infinivision.dataforce.busybee.pb.meta.IDValue getFrom();
  /**
   * <code>.metapb.IDValue from = 2;</code>
   */
  cn.infinivision.dataforce.busybee.pb.meta.IDValueOrBuilder getFromOrBuilder();

  /**
   * <code>string to = 3;</code>
   */
  java.lang.String getTo();
  /**
   * <code>string to = 3;</code>
   */
  com.google.protobuf.ByteString
      getToBytes();
}
