package com.jeffy.scanner.resource;

import com.jeffy.scanner.dao.SystemDao;
import com.jeffy.scanner.mapper.SystemMapper;
import com.jeffy.scanner.model.*;
import com.jeffy.scanner.model.System;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jeffy on 2015/1/9 0009.
 */
@Path("/system")
@Produces(MediaType.APPLICATION_JSON)
public class SystemResource {
    private SystemDao dao;

    public SystemResource(SystemDao dao) {
        this.dao = dao;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSystem() {
        return Response.ok(dao.getById(1), MediaType.APPLICATION_JSON).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addSystem(System system) {
        java.lang.System.out.println(system.getCreateTime());
        return Response.ok(dao.add(system), MediaType.APPLICATION_JSON).build();
    }
}
