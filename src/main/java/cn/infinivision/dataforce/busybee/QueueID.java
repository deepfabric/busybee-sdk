package cn.infinivision.dataforce.busybee;

import lombok.Getter;
import lombok.Setter;

/**
 * Description:
 * <pre>
 * Date: 2020-03-25
 * Time: 15:03
 * </pre>
 *
 * @author fagongzi
 */
@Getter
@Setter
public class QueueID {
    private int partition;
    private long offset;
    private long tenantId;
    private String group;

    public QueueID() {
    }

    public QueueID(long tenantId, String group, int partition, long offset) {
        this.tenantId = tenantId;
        this.group = group;
        this.partition = partition;
        this.offset = offset;
    }
}
