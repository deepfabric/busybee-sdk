// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: rpc.proto

package cn.infinivision.dataforce.busybee.pb.rpc;

public interface DeleteIfRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:rpcpb.DeleteIfRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>bytes key = 1;</code>
   */
  com.google.protobuf.ByteString getKey();

  /**
   * <code>repeated .rpcpb.ConditionGroup conditions = 2;</code>
   */
  java.util.List<cn.infinivision.dataforce.busybee.pb.rpc.ConditionGroup> 
      getConditionsList();
  /**
   * <code>repeated .rpcpb.ConditionGroup conditions = 2;</code>
   */
  cn.infinivision.dataforce.busybee.pb.rpc.ConditionGroup getConditions(int index);
  /**
   * <code>repeated .rpcpb.ConditionGroup conditions = 2;</code>
   */
  int getConditionsCount();
  /**
   * <code>repeated .rpcpb.ConditionGroup conditions = 2;</code>
   */
  java.util.List<? extends cn.infinivision.dataforce.busybee.pb.rpc.ConditionGroupOrBuilder> 
      getConditionsOrBuilderList();
  /**
   * <code>repeated .rpcpb.ConditionGroup conditions = 2;</code>
   */
  cn.infinivision.dataforce.busybee.pb.rpc.ConditionGroupOrBuilder getConditionsOrBuilder(
      int index);
}
