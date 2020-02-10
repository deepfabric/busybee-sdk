package cn.infinivision.dataforce.busybee;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * <pre>
 * Date: 2020-02-10
 * Time: 14:48
 * </pre>
 *
 * @author fagongzi
 */
class Options {
    long fetchCount;
    long consumerConcurrency;
    int ioWorkers;
    int workers;
    long rpcTimeoutMS;
    int fetchSchedulers;
    String defaultMappingType;
    List<String> servers = new ArrayList<>();

    void adjust() {
        if (rpcTimeoutMS == 0) {
            rpcTimeoutMS = 30000;
        }

        if (ioWorkers == 0) {
            ioWorkers = 1;
        }

        if (workers == 0) {
            workers = servers.size();
        }

        if (fetchCount == 0) {
            fetchCount = 16L;
        }

        if (consumerConcurrency == 0) {
            consumerConcurrency = 4;
        }

        if (fetchSchedulers == 0) {
            fetchSchedulers = 1;
        }

        if (defaultMappingType == null) {
            defaultMappingType = "row_id";
        }
    }
}
