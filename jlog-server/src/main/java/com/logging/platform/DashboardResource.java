package com.logging.platform;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import com.logging.platform.entity.ExceptionEntity;
import com.logging.platform.dto.ExceptionDto;
import com.logging.platform.service.ExceptionService;


@Path("/v1/log")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DashboardResource {

    @GET
    public String getLogList() {
        return "Log list";
    }

    @GET
    @Path("{id}")
    public String getLog(String id) {
        return "log" + id;
    }

    @DELETE
    @Path("{id}")
    public void deleteLog(String id) {
    }

    @Inject
    ExceptionService exceptionService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ExceptionDto getSmt() {
        ExceptionEntity entity = new ExceptionEntity();
        entity.
        entity.setMessage("Something went wrong");

        return exceptionService.convertEntityToDto(entity);
    }
}


