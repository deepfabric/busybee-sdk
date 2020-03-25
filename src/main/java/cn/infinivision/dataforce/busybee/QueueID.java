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

    public QueueID() {
    }

    public QueueID(int partition, long offset) {
        this.partition = partition;
        this.offset = offset;
    }
}
