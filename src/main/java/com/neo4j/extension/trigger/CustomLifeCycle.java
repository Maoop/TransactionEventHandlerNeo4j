package com.neo4j.extension.trigger;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.event.TransactionEventHandler;
import org.neo4j.kernel.lifecycle.LifecycleAdapter;

/**
 * handle the setup of auto indexing for UUIDs and registers a {@link UUIDTransactionEventHandler}
 */
class CustomLifeCycle extends LifecycleAdapter {

    private TransactionEventHandler transactionEventHandler;
    private GraphDatabaseService graphDatabaseService;

    CustomLifeCycle(GraphDatabaseService graphDatabaseService) {
        System.out.println("2");
        this.graphDatabaseService = graphDatabaseService;
    }

    @Override
    public void start() throws Throwable {
        System.out.println("3");
        transactionEventHandler = new CustomTransactionEventHandler();
        graphDatabaseService.registerTransactionEventHandler(transactionEventHandler);

    }

    @Override
    public void stop() throws Throwable {
        graphDatabaseService.unregisterTransactionEventHandler(transactionEventHandler);
    }

}
