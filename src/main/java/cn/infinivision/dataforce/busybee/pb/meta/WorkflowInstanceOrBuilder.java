// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: meta.proto

package cn.infinivision.dataforce.busybee.pb.meta;

public interface WorkflowInstanceOrBuilder extends
    // @@protoc_insertion_point(interface_extends:metapb.WorkflowInstance)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.metapb.Workflow snapshot = 1;</code>
   */
  boolean hasSnapshot();
  /**
   * <code>.metapb.Workflow snapshot = 1;</code>
   */
  cn.infinivision.dataforce.busybee.pb.meta.Workflow getSnapshot();
  /**
   * <code>.metapb.Workflow snapshot = 1;</code>
   */
  cn.infinivision.dataforce.busybee.pb.meta.WorkflowOrBuilder getSnapshotOrBuilder();

  /**
   * <code>uint64 instanceID = 2;</code>
   */
  long getInstanceID();

  /**
   * <code>bytes loaderMeta = 3;</code>
   */
  com.google.protobuf.ByteString getLoaderMeta();

  /**
   * <code>.metapb.BMLoader loader = 4;</code>
   */
  int getLoaderValue();
  /**
   * <code>.metapb.BMLoader loader = 4;</code>
   */
  cn.infinivision.dataforce.busybee.pb.meta.BMLoader getLoader();

  /**
   * <code>uint64 totalCrowd = 5;</code>
   */
  long getTotalCrowd();

  /**
   * <code>int64 startedAt = 6;</code>
   */
  long getStartedAt();

  /**
   * <code>int64 stoppedAt = 7;</code>
   */
  long getStoppedAt();

  /**
   * <code>uint64 version = 8;</code>
   */
  long getVersion();

  /**
   * <code>.metapb.WorkflowInstanceState state = 9;</code>
   */
  int getStateValue();
  /**
   * <code>.metapb.WorkflowInstanceState state = 9;</code>
   */
  cn.infinivision.dataforce.busybee.pb.meta.WorkflowInstanceState getState();
}
