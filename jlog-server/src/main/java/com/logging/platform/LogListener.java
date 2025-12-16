package com.logging.platform;

import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Incoming;

@ApplicationScoped
public class LogListener {

    @Incoming("logs")
    public void processLogEntry(String logEntry) {
        System.out.println("New log: " + logEntry);
    }
}