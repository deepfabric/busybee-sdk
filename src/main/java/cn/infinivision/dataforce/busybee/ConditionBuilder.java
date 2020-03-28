package cn.infinivision.dataforce.busybee;

import cn.infinivision.dataforce.busybee.pb.rpc.Cmp;
import cn.infinivision.dataforce.busybee.pb.rpc.Condition;
import cn.infinivision.dataforce.busybee.pb.rpc.ConditionGroup;
import com.google.protobuf.ByteString;
import java.util.ArrayList;
import java.util.List;

/**
 * Build condition groups
 * <pre>
 * Date: 2020-03-28
 * Time: 10:33
 * </pre>
 *
 * @author fagongzi
 */
public class ConditionBuilder {
    private List<ConditionGroup> groups = new ArrayList<>();
    private ConditionGroup.Builder builder = ConditionGroup.newBuilder();

    private ConditionBuilder() {

    }

    /**
     * create builder
     *
     * @return builder
     */
    public static ConditionBuilder newBuilder() {
        return new ConditionBuilder();
    }

    /**
     * create new condition group, eval as <br/>
     *
     * <ul>
     * <li>in a group: cond1 && cond2 && cond3</li>
     * <li>in all groups: group1 || group2 || group3</li>
     * </ul>
     *
     * @return builder
     */
    public ConditionBuilder or() {
        groups.add(builder.build());
        builder = ConditionGroup.newBuilder();
        return this;
    }

    /**
     * the value exist
     *
     * @return builder
     */
    public ConditionBuilder exist() {
        builder.addConditions(Condition.newBuilder()
            .setCmp(Cmp.Exists)
            .build());
        return this;
    }

    /**
     * the value not exist
     *
     * @return builder
     */
    public ConditionBuilder notExist() {
        builder.addConditions(Condition.newBuilder()
            .setCmp(Cmp.NotExists)
            .build());
        return this;
    }

    /**
     * the value in the store == value
     *
     * @param value expect value
     * @return builder
     */
    public ConditionBuilder equal(byte[] value) {
        builder.addConditions(Condition.newBuilder()
            .setCmp(Cmp.Equal)
            .setValue(ByteString.copyFrom(value))
            .build());
        return this;
    }

    /**
     * the value in the store != value
     *
     * @param value expect value
     * @return builder
     */
    public ConditionBuilder notEqual(byte[] value) {
        builder.addConditions(Condition.newBuilder()
            .setCmp(Cmp.NotEqual)
            .setValue(ByteString.copyFrom(value))
            .build());
        return this;
    }

    /**
     * the value in the store >= value
     *
     * @param value expect value
     * @return builder
     */
    public ConditionBuilder ge(byte[] value) {
        builder.addConditions(Condition.newBuilder()
            .setCmp(Cmp.GE)
            .setValue(ByteString.copyFrom(value))
            .build());
        return this;
    }

    /**
     * the value in the store > value
     *
     * @param value expect value
     * @return builder
     */
    public ConditionBuilder gt(byte[] value) {
        builder.addConditions(Condition.newBuilder()
            .setCmp(Cmp.GT)
            .setValue(ByteString.copyFrom(value))
            .build());
        return this;
    }

    /**
     * the value in the store <= value
     *
     * @param value expect value
     * @return builder
     */
    public ConditionBuilder le(byte[] value) {
        builder.addConditions(Condition.newBuilder()
            .setCmp(Cmp.LE)
            .setValue(ByteString.copyFrom(value))
            .build());
        return this;
    }

    /**
     * the value in the store < value
     *
     * @param value expect value
     * @return builder
     */
    public ConditionBuilder lt(byte[] value) {
        builder.addConditions(Condition.newBuilder()
            .setCmp(Cmp.LT)
            .setValue(ByteString.copyFrom(value))
            .build());
        return this;
    }

    /**
     * build groups
     *
     * @return condition groups
     */
    public List<ConditionGroup> build() {
        return groups;
    }
}
