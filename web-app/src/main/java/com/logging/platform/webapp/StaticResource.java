package com.logging.platform.webapp;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("/")
public class StaticResource {

    @GET
    public Response static_resorces_serve(){
        return Response.ok().build();
    }
}