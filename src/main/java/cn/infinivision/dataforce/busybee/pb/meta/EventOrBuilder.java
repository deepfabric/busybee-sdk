// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: meta.proto

package cn.infinivision.dataforce.busybee.pb.meta;

public interface EventOrBuilder extends
    // @@protoc_insertion_point(interface_extends:metapb.Event)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.metapb.EventType type = 1;</code>
   */
  int getTypeValue();
  /**
   * <code>.metapb.EventType type = 1;</code>
   */
  cn.infinivision.dataforce.busybee.pb.meta.EventType getType();

  /**
   * <code>.metapb.UserEvent user = 2;</code>
   */
  boolean hasUser();
  /**
   * <code>.metapb.UserEvent user = 2;</code>
   */
  cn.infinivision.dataforce.busybee.pb.meta.UserEvent getUser();
  /**
   * <code>.metapb.UserEvent user = 2;</code>
   */
  cn.infinivision.dataforce.busybee.pb.meta.UserEventOrBuilder getUserOrBuilder();

  /**
   * <code>.metapb.UpdateCrowdEvent updateCrowd = 3;</code>
   */
  boolean hasUpdateCrowd();
  /**
   * <code>.metapb.UpdateCrowdEvent updateCrowd = 3;</code>
   */
  cn.infinivision.dataforce.busybee.pb.meta.UpdateCrowdEvent getUpdateCrowd();
  /**
   * <code>.metapb.UpdateCrowdEvent updateCrowd = 3;</code>
   */
  cn.infinivision.dataforce.busybee.pb.meta.UpdateCrowdEventOrBuilder getUpdateCrowdOrBuilder();

  /**
   * <code>.metapb.UpdateWorkflowEvent updateWorkflow = 4;</code>
   */
  boolean hasUpdateWorkflow();
  /**
   * <code>.metapb.UpdateWorkflowEvent updateWorkflow = 4;</code>
   */
  cn.infinivision.dataforce.busybee.pb.meta.UpdateWorkflowEvent getUpdateWorkflow();
  /**
   * <code>.metapb.UpdateWorkflowEvent updateWorkflow = 4;</code>
   */
  cn.infinivision.dataforce.busybee.pb.meta.UpdateWorkflowEventOrBuilder getUpdateWorkflowOrBuilder();
}
