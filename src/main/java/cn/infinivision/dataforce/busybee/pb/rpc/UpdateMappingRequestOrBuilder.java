// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: rpc.proto

package cn.infinivision.dataforce.busybee.pb.rpc;

public interface UpdateMappingRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:rpcpb.UpdateMappingRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>uint64 id = 1;</code>
   */
  long getId();

  /**
   * <code>repeated .metapb.IDValue values = 2;</code>
   */
  java.util.List<cn.infinivision.dataforce.busybee.pb.meta.IDValue> 
      getValuesList();
  /**
   * <code>repeated .metapb.IDValue values = 2;</code>
   */
  cn.infinivision.dataforce.busybee.pb.meta.IDValue getValues(int index);
  /**
   * <code>repeated .metapb.IDValue values = 2;</code>
   */
  int getValuesCount();
  /**
   * <code>repeated .metapb.IDValue values = 2;</code>
   */
  java.util.List<? extends cn.infinivision.dataforce.busybee.pb.meta.IDValueOrBuilder> 
      getValuesOrBuilderList();
  /**
   * <code>repeated .metapb.IDValue values = 2;</code>
   */
  cn.infinivision.dataforce.busybee.pb.meta.IDValueOrBuilder getValuesOrBuilder(
      int index);
}