package cn.infinivision.dataforce.busybee;

import java.util.Arrays;

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
     * batch size that fetch the notify from busybee
     *
     * @param value batch size
     * @return Builder
     */
    public Builder notifyFetchBatchSize(long value) {
        this.opts.fetchCount = value;
        return this;
    }

    /**
     * how many processor can concurrency consumer the notifies.
     * If we fetch 100 notifies, and this value is 10, so 10 process
     * can concurrent execute, and 10 notifies per process
     *
     * @param value batch size
     * @return Builder
     */
    public Builder consumerConcurrency(long value) {
        this.opts.consumerConcurrency = value;
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
     * create a client
     *
     * @return client
     */
    public Client build() {
        opts.adjust();

        Transport transport = new Transport(opts.workers, opts.ioWorkers, opts.rpcTimeoutMS);
        opts.servers.forEach(s -> transport.addConnector(s));
        transport.start();

        return new Client(transport, opts);
    }
}
