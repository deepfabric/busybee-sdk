// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: meta.proto

package cn.infinivision.dataforce.busybee.pb.meta;

public interface QueueStateOrBuilder extends
    // @@protoc_insertion_point(interface_extends:metapb.QueueState)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>uint32 partitions = 1;</code>
   */
  int getPartitions();

  /**
   * <code>uint32 consumers = 2;</code>
   */
  int getConsumers();

  /**
   * <code>repeated .metapb.Partiton states = 3;</code>
   */
  java.util.List<cn.infinivision.dataforce.busybee.pb.meta.Partiton> 
      getStatesList();
  /**
   * <code>repeated .metapb.Partiton states = 3;</code>
   */
  cn.infinivision.dataforce.busybee.pb.meta.Partiton getStates(int index);
  /**
   * <code>repeated .metapb.Partiton states = 3;</code>
   */
  int getStatesCount();
  /**
   * <code>repeated .metapb.Partiton states = 3;</code>
   */
  java.util.List<? extends cn.infinivision.dataforce.busybee.pb.meta.PartitonOrBuilder> 
      getStatesOrBuilderList();
  /**
   * <code>repeated .metapb.Partiton states = 3;</code>
   */
  cn.infinivision.dataforce.busybee.pb.meta.PartitonOrBuilder getStatesOrBuilder(
      int index);

  /**
   * <code>int64 timeout = 4;</code>
   */
  long getTimeout();

  /**
   * <code>int64 maxAlive = 5;</code>
   */
  long getMaxAlive();

  /**
   * <code>uint64 cleanBatch = 6;</code>
   */
  long getCleanBatch();
}
