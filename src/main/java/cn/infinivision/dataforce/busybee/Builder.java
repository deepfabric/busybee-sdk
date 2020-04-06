package cn.infinivision.dataforce.busybee;

import java.util.Arrays;
import java.util.concurrent.ScheduledExecutorService;

/**
 * Busybee client builder
 *
 * @author fagongzi
 */
public class Builder {
    private Options opts = new Options();

    /**
     * response timeout, default is 30 seconds
     *
     * @param value timeout in ms
     * @return Builder
     */
    public Builder rpcTimeout(long value) {
        this.opts.rpcTimeoutMS = value;
        return this;
    }

    /**
     * how many workers to send request, default is number of servers.
     *
     * @param value value
     * @return Builder
     */
    public Builder workers(int value) {
        this.opts.workers = value;
        return this;
    }

    /**
     * number of io threads to handle io events, default is 1
     *
     * @param value value
     * @return Builder
     */
    public Builder ioWorkers(int value) {
        this.opts.ioWorkers = value;
        return this;
    }

    /**
     * busybee servers, each node is stateless to the client.
     *
     * @param addresses server addresses
     * @return Builder
     */
    public Builder addServer(String... addresses) {
        this.opts.servers.addAll(Arrays.asList(addresses));
        return this;
    }

    /**
     * set fetch size  that fetch the notify from busybee
     *
     * @param count count
     * @return Builder
     */
    public Builder fetchSize(long count) {
        return fetchSize(count, 1024 * 1024);
    }

    /**
     * set fetch size and max bytes that fetch the notify from busybee
     *
     * @param count count
     * @param maxBytes max bytes
     * @return Builder
     */
    public Builder fetchSize(long count, long maxBytes) {
        this.opts.fetchCount = count;
        this.opts.fetchBytes = maxBytes;
        return this;
    }

    /**
     * tenant notify queue fetch scheduler threads, default is 1
     *
     * @param value value
     * @return Builder
     */
    public Builder fetchSchedulers(int value) {
        this.opts.fetchSchedulers = value;
        return this;
    }

    /**
     * tenant notify queue fetch heartbeat interval seconds, default is 5
     *
     * @param value value
     * @return Builder
     */
    public Builder fetchHeartbeat(int value) {
        this.opts.fetchHeartbeat = value;
        return this;
    }

    /**
     * set default id mapping row id type, default is row_id
     *
     * @param value value
     * @return Builder
     */
    public Builder defaultMappingType(String value) {
        this.opts.defaultMappingType = value;
        return this;
    }

    /**
     * set biz executor service
     *
     * @param bizService biz executor service
     * @return Builder
     */
    public Builder bizService(ScheduledExecutorService bizService) {
        this.opts.bizService = bizService;
        return this;
    }

    /**
     * create a client
     *
     * @return client
     */
    public Client build() {
        opts.adjust();

        CtxHolder holder = new CtxHolder();
        Transport transport = new Transport(opts.workers, opts.ioWorkers, opts.rpcTimeoutMS, holder);
        opts.servers.forEach(s -> transport.addConnector(s));
        transport.start();

        return new Client(transport, holder, opts);
    }
}
