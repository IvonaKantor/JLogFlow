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
    public void handle(Message message) {
        EntityData entity = new EntityData();
        entity.level = message.getLevel();
        entity.serviceName = message.getServiceName();
        entity.message = message.getMessage();
        entity.timestamp = message.getTimestamp();
        entity.traceId = message.getTraceId();

        entity.persist();
    }

    private void perform(Message log) {
        if ("ERROR".equals(log.getLevel())) {
        }
    }
}
