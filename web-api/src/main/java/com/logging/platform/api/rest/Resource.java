package com.logging.platform.api.rest;

import com.logging.platform.api.entity.LogEntity;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Path("/api")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class Resource {

    @GET
    @Path("/logs")
    public List<LogEntity> getLogs(
            @QueryParam("page") @DefaultValue("0") int page,
            @QueryParam("size") @DefaultValue("50") int size) {
                return LogEntity.findAll().page(page, size).list();
    }

    @GET
    @Path("/logs/{id}")
    public LogEntity getLog(@PathParam("id") Long id) {
        return LogEntity.findById(id);
    }

    @GET
    @Path("/stats")
    public Map<String, Object> getStats() {
        Map<String, Object> stats = new HashMap<>();
        stats.put("total", LogEntity.count());
        stats.put("errors", LogEntity.countByLevel("ERROR"));
        stats.put("warnings", LogEntity.countByLevel("WARN"));
        stats.put("infos", LogEntity.countByLevel("INFO"));
        stats.put("services", LogEntity.findDistinctServices().size());
        return stats;
    }

    @GET
    @Path("/services")
    public List<String> getServices() {
        return LogEntity.findDistinctServices();
    }
}