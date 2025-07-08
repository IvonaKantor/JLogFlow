package org.jlog.flow;

import org.eclipse.microprofile.reactive.messaging.Incoming;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class ExampleResource {

    public static final String TOPIC_HELLO = "hello";

    public static final List<String> events = new ArrayList<>();

    @Incoming(TOPIC_HELLO)
    public void processLog(String message) {
        events.add(message);
        System.out.println("Log received: " + message);
    }
}