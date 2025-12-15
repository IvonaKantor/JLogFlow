package com.logging.platform;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.logging.platform.models.LogData;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.reactive.messaging.Incoming;

@ApplicationScoped
public class LogListener {

    @Inject
    ObjectMapper objectMapper;

    @Incoming("logs")
    public void processLogEntry(String message) throws JsonProcessingException {
        final var logEntry = objectMapper.readValue(message, LogData.class);
    }


}