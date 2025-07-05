package org.jlog.flow;

import org.eclipse.microprofile.reactive.messaging.Incoming;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ExampleResource {

    @Incoming("hello")
    public void processLog(String message) {
        System.out.println("Log received: " + message);
    }
}