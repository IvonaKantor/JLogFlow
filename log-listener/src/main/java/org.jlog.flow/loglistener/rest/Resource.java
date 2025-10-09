package org.jlog.flow.loglistener.rest;

import org.jlog.flow.dto.LogEntry;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.jboss.logging.Logger;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

@Path("/logs")
public class Resource {

    private static final Logger LOG = Logger.getLogger(LogResource.class);

    @Inject
    @Channel("raw-logs")

    @POST
    public Response receiveLog(LogEntry logEntry) {

    }

    @GET
    @Path("/health")
    public Response health() {
    }
}