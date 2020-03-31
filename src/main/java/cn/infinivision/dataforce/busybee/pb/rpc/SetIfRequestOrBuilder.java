// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: rpc.proto

package cn.infinivision.dataforce.busybee.pb.rpc;

public interface SetIfRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:rpcpb.SetIfRequest)
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

  /**
   * <code>repeated .rpcpb.ConditionGroup conditions = 4;</code>
   */
  java.util.List<cn.infinivision.dataforce.busybee.pb.rpc.ConditionGroup> 
      getConditionsList();
  /**
   * <code>repeated .rpcpb.ConditionGroup conditions = 4;</code>
   */
  cn.infinivision.dataforce.busybee.pb.rpc.ConditionGroup getConditions(int index);
  /**
   * <code>repeated .rpcpb.ConditionGroup conditions = 4;</code>
   */
  int getConditionsCount();
  /**
   * <code>repeated .rpcpb.ConditionGroup conditions = 4;</code>
   */
  java.util.List<? extends cn.infinivision.dataforce.busybee.pb.rpc.ConditionGroupOrBuilder> 
      getConditionsOrBuilderList();
  /**
   * <code>repeated .rpcpb.ConditionGroup conditions = 4;</code>
   */
  cn.infinivision.dataforce.busybee.pb.rpc.ConditionGroupOrBuilder getConditionsOrBuilder(
      int index);
}