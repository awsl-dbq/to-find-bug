package app.findbug;

import io.dgraph.DgraphClient;
import io.dgraph.DgraphGrpc;
import io.dgraph.DgraphProto;
import io.dgraph.Transaction;
import io.grpc.*;
import io.grpc.netty.NettyChannelBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;


public class DGraphService {

    private static final int DEFAULT_DEADLINE_SECS = 10;
    private int defaultDeadlineSecs = DEFAULT_DEADLINE_SECS;
    private String dgraphHost = "localhost";


    private static final int DEFAULTDGRAPHPORT = 9080;
    private int port = DEFAULTDGRAPHPORT;
    private static final Logger LOGGER
            = LoggerFactory.getLogger(DGraphService.class);

    public DgraphClient client() {
        return clientWithTimeout(defaultDeadlineSecs);
    }

    public DgraphClient clientWithTimeoutAndMaxBody(
            final int deadlineSecs,
            final int maxBody
    ) {

        ManagedChannel channel = NettyChannelBuilder
                .forAddress(dgraphHost, port)
                .usePlaintext()
                .maxInboundMessageSize(maxBody)
                .build();
        DgraphGrpc.DgraphStub stub = DgraphGrpc.newStub(channel);
        stub.withDeadlineAfter(deadlineSecs, TimeUnit.MILLISECONDS);
        stub.withInterceptors(new TimeOutInterceptor(deadlineSecs));
        return new DgraphClient(stub);
    }

    public DgraphClient clientWithTimeout(final int deadlineSecs) {
        ManagedChannel channel = NettyChannelBuilder
                .forAddress(dgraphHost, port)
                .usePlaintext()
                .build();
        DgraphGrpc.DgraphStub stub = DgraphGrpc.newStub(channel);
        stub.withDeadlineAfter(deadlineSecs, TimeUnit.MILLISECONDS);
        stub.withInterceptors(new TimeOutInterceptor((deadlineSecs)));
        return new DgraphClient(stub);
    }

    /**
     */
    public void setDgraphHost(final String xdgraphHost) {
        this.dgraphHost = xdgraphHost;
    }

    /**
     */
    public void setPort(final int xport) {
        this.port = xport;
    }


    /**
     */
    public String response(
            final String query,
            final Map<String, String> vars) {
        return response(client(), query, vars);
    }

    /**
     * @param query  query
     * @param client client
     * @param vars   vars
     * @return String
     */
    public String response(
            final DgraphClient client,
            final String query,
            final Map<String, String> vars) {
        try (
                Transaction trx = client.newTransaction();
        ) {
            StopWatch sw = new StopWatch();
            sw.start("Query and Response ");
            String ret = trx.queryWithVars(query, vars)
                    .getJson().toStringUtf8();
            sw.stop();
            String sp = sw.prettyPrint();
            LOGGER.info("query is \n{}\n ,and response time is: \n{}",
                    query, sp);
            return ret;
        } catch (StatusRuntimeException e) {
            LOGGER.error(
                    "error query is\n {} \nand params is {}"
                            +
                            ",and hostinfo is {},{} ",
                    query, vars, dgraphHost, port);
            throw e;
        }
    }

    /**
     * @param query   query
     * @param timeout timeout
     * @param maxBody maxbody
     * @param vars    vars
     * @return response
     */
    public String responseWithTimeoutAndMaxBody(
            final String query,
            final int timeout,
            final int maxBody,
            final Map<String, String> vars) {
        DgraphClient client = clientWithTimeoutAndMaxBody(timeout, maxBody);
        return response(client, query, vars);
    }

    /**
     * @param query   query
     * @param timeout timeoutSec
     * @param vars    vars
     * @return String
     */
    public String responseWithTimeout(
            final String query,
            final int timeout,
            final Map<String, String> vars) {
        try (
                Transaction trx = clientWithTimeout(timeout).newTransaction();
        ) {
            StopWatch sw = new StopWatch();
            sw.start("Query and Response ");
            String ret = trx
                    .queryWithVars(query, vars)
                    .getJson().toStringUtf8();
            sw.stop();
            String sp = sw.prettyPrint();
            LOGGER.info("query is {} ,and response time is {}",
                    query, sp);
            return ret;
        } catch (StatusRuntimeException e) {
            LOGGER.error(
                    "error query is\n {} \nand params is {}"
                            +
                            ",and hostinfo is {},{} ",
                    query, vars, dgraphHost, port);
            throw e;
        }
    }

    /**
     * @param query   query
     * @param keyVals keyVals
     * @return String
     */
    public String response(final String query, final String... keyVals) {
        return response(client(), query, keyVals);
    }

    /**
     * @param query   query
     * @param client  client
     * @param keyVals keyVals
     * @return String
     */
    public String response(
            final DgraphClient client,
            final String query, final String... keyVals) {
        Map<String, String> vars = new HashMap<>();
        for (int i = 0; i < keyVals.length; i = i + 2) {
            vars.put(keyVals[i], keyVals[i + 1]);
        }
        return response(client, query, vars);
    }

    /**
     * @param query   query
     * @param timeout 超時時間
     * @param keyVals keyVals
     * @return String
     */
    public String responseWithTimeout(
            final String query, final int timeout, final String... keyVals) {
        Map<String, String> vars = new HashMap<>();
        for (int i = 0; i < keyVals.length; i = i + 2) {
            vars.put(keyVals[i], keyVals[i + 1]);
        }
        return responseWithTimeout(query, timeout, vars);
    }

    /**
     * @param mutation mutation
     */
    public void doMutate(final DgraphProto.Mutation mutation) {
        try (
                Transaction ts = this.client().newTransaction();
        ) {
            ts.mutate(mutation);
            ts.commit();
            ts.discard();
        } catch (Exception e) {
            LOGGER.error(
                    "exception when domutation {},and the error mutation is {}",
                    e, mutation.getSetJson().toStringUtf8());
        }
    }


}

/**
 *
 */
class TimeOutInterceptor implements ClientInterceptor {

    private int deadlineSecs = 0;

    /**
     * @param deadline deadline in seconds.
     */
    TimeOutInterceptor(final int deadline) {
        this.deadlineSecs = deadline;
    }


    @Override
    public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(MethodDescriptor<ReqT, RespT> methodDescriptor, CallOptions callOptions, io.grpc.Channel channel) {
        return channel.newCall(methodDescriptor, callOptions.withDeadlineAfter(
                deadlineSecs, TimeUnit.MILLISECONDS));
    }
}
