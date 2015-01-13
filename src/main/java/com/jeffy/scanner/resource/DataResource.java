package com.jeffy.scanner.resource;

import com.jeffy.scanner.constants.CommonConstants;
import com.jeffy.scanner.constants.ErrorCode;
import com.jeffy.scanner.model.Data;
import com.jeffy.scanner.model.Item;
import com.jeffy.scanner.service.DataService;
import org.apache.log4j.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by Jeffy on 2015/1/12 0012.
 */
@Path("/data")
@Produces(MediaType.APPLICATION_JSON)
public class DataResource {
    private Logger log = Logger.getLogger(this.getClass());
    private DataService dataService;

    public DataResource(DataService dataService) {
        this.dataService = dataService;
    }

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addItem(Data data) {

        try {
            int status = dataService.addData(data);
        } catch (Exception e) {
            log.error(ErrorCode.ADD_ITEM_ERROR_MESSAGE, e);
            return Response.ok(new com.jeffy.scanner.bo.Response(ErrorCode.ADD_ITEM_ERROR_CODE, ErrorCode.ADD_ITEM_ERROR_MESSAGE + e.getMessage())).status(500).build();
        }

        return Response.ok(new com.jeffy.scanner.bo.Response(CommonConstants.SUCCESS_CODE, CommonConstants.SUCCESS_MESSAGE)).build();
    }
}
