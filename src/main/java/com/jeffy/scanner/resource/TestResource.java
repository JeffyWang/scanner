package com.jeffy.scanner.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jeffy on 2015/1/9 0009.
 */
@Path("/test")
@Produces(MediaType.APPLICATION_JSON)
public class TestResource {

    @GET
    public Response test() {
        Map<String, String> data = new HashMap<String, String>();
        data.put("date", new Date().toString());

        return Response.ok(data, MediaType.APPLICATION_JSON).build();
    }
}
