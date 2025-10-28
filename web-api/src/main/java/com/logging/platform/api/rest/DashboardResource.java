package com.logging.platform.api.rest;

import com.logging.platform.api.entity.LogEntity;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Path("/api/dashboard")
@Produces(MediaType.APPLICATION_JSON)
public class DashboardResource {

    @GET
    @Path("/recent")
    public List<LogEntity> getRecentLogs() {
        return LogEntity.findRecentLogs(20);
    }

    @GET
    @Path("/levels")
    public Map<String, Long> getLevels() {
        List<Object[]> results = LogEntity.getEntityManager()
                .createQuery("SELECT level, COUNT(*) FROM LogEntity GROUP BY level", Object[].class)
                .getResultList();

        return results.stream()
                .collect(Collectors.toMap(
                        result -> (String) result[0],
                        result -> (Long) result[1]
                ));
    }
}