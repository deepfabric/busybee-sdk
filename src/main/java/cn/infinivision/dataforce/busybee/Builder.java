package cn.infinivision.dataforce.busybee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Busybee client builder
 *
 * @author fagongzi
 */
public class Builder {
    private Options opts = new Options();

    private static class Options {
        private int ioWorkers;
        private int workers;
        private long rpcTimeoutMS;
        private List<String> servers = new ArrayList<>();

        private void adjust() {
            if (rpcTimeoutMS == 0) {
                rpcTimeoutMS = 30000;
            }

            if (ioWorkers == 0) {
                ioWorkers = 1;
            }

            if (workers == 0) {
                workers = servers.size();
            }
        }
    }

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
     * create a client
     *
     * @return client
     */
    public Client build() {
        opts.adjust();

        Transport transport = new Transport(opts.workers, opts.ioWorkers, opts.rpcTimeoutMS);
        transport.start();

        return new Client(transport);
    }
}
