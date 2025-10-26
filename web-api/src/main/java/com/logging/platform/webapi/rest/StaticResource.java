package com.logging.platform.webapi.rest;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("/")
public class StaticResource {

    @GET
    public Response staticResoursesServe(){
        return Response.ok().build();
    }
}