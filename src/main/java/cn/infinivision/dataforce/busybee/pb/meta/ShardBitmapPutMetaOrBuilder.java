// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: meta.proto

package cn.infinivision.dataforce.busybee.pb.meta;

public interface ShardBitmapPutMetaOrBuilder extends
    // @@protoc_insertion_point(interface_extends:metapb.ShardBitmapPutMeta)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>bytes key = 1;</code>
   */
  com.google.protobuf.ByteString getKey();

  /**
   * <code>uint32 ttl = 2;</code>
   */
  int getTtl();

  /**
   * <code>uint32 bytesPerShard = 3;</code>
   */
  int getBytesPerShard();
}
