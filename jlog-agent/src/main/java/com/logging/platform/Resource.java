package com.logging.platform;

import io.smallrye.mutiny.Multi;
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
    @Channel("log-requests")
    Emitter<Record<String, Log>> emitter;

    @POST
    @Path("/request")
    @Produces(MediaType.TEXT_PLAIN)
    public Response writeLog(Log log) {
        emitter.send(Record.of(log.getServiceName(), log));
        return Response.ok().entity("log sent").build();
    }

    @GET
    @Path("/health")
    public Response health() {
        return Response.ok().build();
    }

    @Channel("logs")
    Multi<Log> messages;

    @GET
    @Produces(MediaType.SERVER_SENT_EVENTS)
    public Multi<Log> stream() {
        return messages;
    }
}