// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: meta.proto

package cn.infinivision.dataforce.busybee.pb.meta;

public interface EventOrBuilder extends
    // @@protoc_insertion_point(interface_extends:metapb.Event)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>uint32 userID = 1;</code>
   */
  int getUserID();

  /**
   * <code>uint64 tenantID = 2;</code>
   */
  long getTenantID();

  /**
   * <code>uint64 workflowID = 3;</code>
   */
  long getWorkflowID();

  /**
   * <code>repeated .metapb.KV data = 4;</code>
   */
  java.util.List<cn.infinivision.dataforce.busybee.pb.meta.KV> 
      getDataList();
  /**
   * <code>repeated .metapb.KV data = 4;</code>
   */
  cn.infinivision.dataforce.busybee.pb.meta.KV getData(int index);
  /**
   * <code>repeated .metapb.KV data = 4;</code>
   */
  int getDataCount();
  /**
   * <code>repeated .metapb.KV data = 4;</code>
   */
  java.util.List<? extends cn.infinivision.dataforce.busybee.pb.meta.KVOrBuilder> 
      getDataOrBuilderList();
  /**
   * <code>repeated .metapb.KV data = 4;</code>
   */
  cn.infinivision.dataforce.busybee.pb.meta.KVOrBuilder getDataOrBuilder(
      int index);
}
