package com.neo4j.extension.trigger;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.kernel.extension.KernelExtensionFactory;
import org.neo4j.kernel.lifecycle.Lifecycle;

/**
 * Neo4j kernel extension for initializing a {@link UUIDTransactionEventHandler} and setting up autoindexing appropriately.
 */
public class CustomKernelExtensionFactory extends KernelExtensionFactory<CustomKernelExtensionFactory.Dependencies> {

    public interface Dependencies
    {
        GraphDatabaseService getGraphDatabaseService();
    }

    public CustomKernelExtensionFactory() {
        super("trigger");
        System.out.println("0");
    }

    @Override
    public Lifecycle newKernelExtension(final Dependencies dependencies) throws Throwable {
        System.out.println("1");
        return new CustomLifeCycle(dependencies.getGraphDatabaseService());
    }

}
