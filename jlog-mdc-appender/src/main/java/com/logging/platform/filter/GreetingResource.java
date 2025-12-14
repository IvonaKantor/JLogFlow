package com.logging.platform.filter;

import io.quarkus.logging.Log;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.slf4j.MDC;

import java.util.UUID;

@Path("test/hello/")
public class GreetingResource {

    @GET
    @Path("/test")
    public String greeting() {
        MDC.put("request.id", UUID.randomUUID().toString());
        MDC.put("request.path", "/hello/test");
        Log.info("request received");
        return "hello world!";
    }
}
