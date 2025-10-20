package com.logging.platform.consumer;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/hello")
public class ExampleResource {


    private static final Logger log = LoggerFactory.getLogger(ExampleResource.class);
    @Channel("hello")
    Emitter<String> emitter;

    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    public void sendLog(String message) {
        emitter.send(message);
        log.info("Message sent to {}", message);
    }

}
