package com.logging.platform;

import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.reactive.messaging.Channel;
import io.smallrye.reactive.messaging.kafka.Record;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import jakarta.ws.rs.*;
import jakarta.inject.Inject;

@Path("/logs")
public class Resource {

    @Inject
    @Channel("message")
    Emitter<Record<String, Message>> emitter;

    @POST
    @Path("/request")
    @Produces(MediaType.TEXT_PLAIN)
    public Response writeLog(Message message) {
        emitter.send(Record.of(message.getServiceName(), message));
        return Response.ok().entity("log sent").build();
    }

    @GET
    @Path("/health")
    public Response health() {
        return Response.ok().build();
    }
}