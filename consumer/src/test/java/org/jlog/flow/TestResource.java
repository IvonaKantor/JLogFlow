package org.jlog.flow;


import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.common.QuarkusTestResourceLifecycleManager;
import io.quarkus.test.junit.QuarkusTest;
import io.smallrye.reactive.messaging.memory.InMemoryConnector;
import io.smallrye.reactive.messaging.memory.InMemorySource;
import jakarta.inject.Inject;
import org.eclipse.microprofile.reactive.messaging.spi.Connector;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.jlog.flow.ExampleResource.TOPIC_HELLO;
import static org.jlog.flow.ExampleResource.events;
import static org.junit.jupiter.api.Assertions.assertFalse;

@QuarkusTest
public class TestResource implements QuarkusTestResourceLifecycleManager {

    @Inject
    @Connector("smallrye-in-memory")
    InMemoryConnector connector;

    @Test
    void test() {
        InMemorySource<String> ordersIn = connector.source(TOPIC_HELLO);

        ordersIn.send("hello world");

        assertFalse(events.isEmpty());
    }

    @Override
    public Map<String, String> start() {
        Map<String, String> props1 = InMemoryConnector.switchIncomingChannelsToInMemory(TOPIC_HELLO);

        return new HashMap<>(props1);
    }

    @Override
    public void stop() {
        InMemoryConnector.clear();
    }
}

