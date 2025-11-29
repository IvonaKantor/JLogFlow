package com.logging.platform;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/service1")
@Produces(MediaType.APPLICATION_JSON)
public class Service {

    @Inject
    Resource resource;

    @GET
    @Path("/operation")
    public String operation() {
        Message log = new Message();
        log.setServiceName("service1");
        log.setMessage("Hello World");
        log.setLevel("INFO");

        resource.writeLog(log);

        return "Hello World";
    }
}
