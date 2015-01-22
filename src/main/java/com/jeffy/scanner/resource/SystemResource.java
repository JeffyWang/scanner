package com.jeffy.scanner.resource;

import com.jeffy.scanner.constants.CommonConstants;
import com.jeffy.scanner.constants.ErrorCode;
import com.jeffy.scanner.dao.SystemDao;
import com.jeffy.scanner.mapper.SystemMapper;
import com.jeffy.scanner.model.*;
import com.jeffy.scanner.model.System;
import com.jeffy.scanner.service.SystemService;
import org.apache.log4j.Logger;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jeffy on 2015/1/9 0009.
 */
@Path("/system")
@Produces(MediaType.APPLICATION_JSON)
public class SystemResource {
    private Logger log = Logger.getLogger(this.getClass());
    private SystemService systemService;

    public SystemResource(SystemService systemService) {
        this.systemService = systemService;
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSystem(@PathParam("id") int systemId) {
        System system = null;

        try {
            system = systemService.getSystem(systemId);
        } catch (Exception e) {
            log.error(ErrorCode.GET_SYSTEM_ERROR_MESSAGE, e);
            return Response.ok(new com.jeffy.scanner.bo.Response(ErrorCode.GET_SYSTEM_ERROR_CODE, ErrorCode.GET_SYSTEM_ERROR_MESSAGE + e.getMessage())).status(500).build();
        }

        return Response.ok(system, MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Path("/{order}/{number}/{size}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSystemForPage(@PathParam("order") String order, @PathParam("number") int pageNumber, @PathParam("size") int pageSize) {
        List<System> systemList = null;

        try {
            systemList = systemService.getSystemForPage(order, pageNumber, pageSize);
        } catch (Exception e) {
            log.error(ErrorCode.GET_SYSTEM_PAGE_ERROR_MESSAGE, e);
            return Response.ok(new com.jeffy.scanner.bo.Response(ErrorCode.GET_SYSTEM_PAGE_ERROR_CODE, ErrorCode.GET_SYSTEM_PAGE_ERROR_MESSAGE + e.getMessage())).status(500).build();
        }

        return Response.ok(systemList, MediaType.APPLICATION_JSON).build();
    }

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addSystem(System system) {

        try {
            int status = systemService.addSystem(system);
        } catch (Exception e) {
            log.error(ErrorCode.ADD_SYSTEM_ERROR_MESSAGE, e);
            return Response.ok(new com.jeffy.scanner.bo.Response(ErrorCode.ADD_SYSTEM_ERROR_CODE, ErrorCode.ADD_SYSTEM_ERROR_MESSAGE + e.getMessage())).status(500).build();
        }

        return Response.ok(new com.jeffy.scanner.bo.Response(CommonConstants.SUCCESS_CODE, CommonConstants.SUCCESS_MESSAGE)).build();
    }

    @PUT
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateSystem(System system) {

        try {
            int status = systemService.updateSystem(system);
        } catch (Exception e) {
            log.error(ErrorCode.UPDATE_SYSTEM_ERROR_MESSAGE, e);
            return Response.ok(new com.jeffy.scanner.bo.Response(ErrorCode.UPDATE_SYSTEM_ERROR_CODE, ErrorCode.UPDATE_SYSTEM_ERROR_MESSAGE + e.getMessage())).status(500).build();
        }

        return Response.ok(new com.jeffy.scanner.bo.Response(CommonConstants.SUCCESS_CODE, CommonConstants.SUCCESS_MESSAGE)).build();
    }

    @PUT
    @Path("/start/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response startSystem(@PathParam("id") int systemId) {

        try {
            int status = systemService.startMonitorSystem(systemId);
        } catch (Exception e) {
            log.error(ErrorCode.START_MONITOR_SYSTEM_ERROR_CODE, e);
            return Response.ok(new com.jeffy.scanner.bo.Response(ErrorCode.START_MONITOR_SYSTEM_ERROR_CODE, ErrorCode.START_MONITOR_SYSTEM_ERROR_MESSAGE + e.getMessage())).status(500).build();
        }

        return Response.ok(new com.jeffy.scanner.bo.Response(CommonConstants.SUCCESS_CODE, CommonConstants.SUCCESS_MESSAGE)).build();
    }

    @PUT
    @Path("/stop/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response stopSystem(@PathParam("id") int systemId) {

        try {
            int status = systemService.stopMonitorSystem(systemId);
        } catch (Exception e) {
            log.error(ErrorCode.STOP_MONITOR_SYSTEM_ERROR_CODE, e);
            return Response.ok(new com.jeffy.scanner.bo.Response(ErrorCode.STOP_MONITOR_SYSTEM_ERROR_CODE, ErrorCode.STOP_MONITOR_SYSTEM_ERROR_MESSAGE + e.getMessage())).status(500).build();
        }

        return Response.ok(new com.jeffy.scanner.bo.Response(CommonConstants.SUCCESS_CODE, CommonConstants.SUCCESS_MESSAGE)).build();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteSystem(@PathParam("id") int systemId) {

        try {
            int status = systemService.deleteSystem(systemId);
        } catch (Exception e) {
            log.error(ErrorCode.DELETE_SYSTEM_ERROR_MESSAGE, e);
            return Response.ok(new com.jeffy.scanner.bo.Response(ErrorCode.DELETE_SYSTEM_ERROR_CODE, ErrorCode.DELETE_SYSTEM_ERROR_MESSAGE + e.getMessage())).status(500).build();
        }

        return Response.ok(new com.jeffy.scanner.bo.Response(CommonConstants.SUCCESS_CODE, CommonConstants.SUCCESS_MESSAGE)).build();
    }
}