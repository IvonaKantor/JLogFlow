package com.logging.platform;

import jakarta.transaction.Transactional;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Processor {

    @Incoming("requests")
    @Outgoing("logs")
    @Transactional
    public Log process(String message) throws InterruptedException {
        return new Log("testService", "INFO", "test");
    }

}
