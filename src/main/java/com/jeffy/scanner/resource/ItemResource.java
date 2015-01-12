package com.jeffy.scanner.resource;

import com.jeffy.scanner.constants.CommonConstants;
import com.jeffy.scanner.constants.ErrorCode;
import com.jeffy.scanner.model.*;
import com.jeffy.scanner.service.ItemService;
import org.apache.log4j.Logger;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by Jeffy on 2015/1/12 0012.
 */
@Path("/item")
@Produces(MediaType.APPLICATION_JSON)
public class ItemResource {
    private Logger log = Logger.getLogger(this.getClass());
    private ItemService itemService;

    public ItemResource(ItemService itemService) {
        this.itemService = itemService;
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getItem(@PathParam("id") int itemId) {
        Item item = null;

        try {
            item = itemService.getItem(itemId);
        } catch (Exception e) {
            log.error(ErrorCode.GET_ITEM_ERROR_MESSAGE, e);
            return Response.ok(new com.jeffy.scanner.bo.Response(ErrorCode.GET_ITEM_ERROR_CODE, ErrorCode.GET_ITEM_ERROR_MESSAGE + e.getMessage())).status(500).build();
        }

        return Response.ok(item, MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Path("/system/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSystemItems(@PathParam("id") int systemId) {
        List<Item> itemList = null;

        try {
            itemList = itemService.getSystemItems(systemId);
        } catch (Exception e) {
            log.error(ErrorCode.GET_SYSTEM_ITEMS_ERROR_MESSAGE, e);
            return Response.ok(new com.jeffy.scanner.bo.Response(ErrorCode.GET_SYSTEM_ITEMS_ERROR_CODE, ErrorCode.GET_SYSTEM_ITEMS_ERROR_MESSAGE + e.getMessage())).status(500).build();
        }

        return Response.ok(itemList, MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Path("/system/{id}/{order}/{number}/{size}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSystemItemsForPage(@PathParam("id") int systemId, @PathParam("order") String order, @PathParam("number") int pageNumber, @PathParam("size") int pageSize) {
        List<Item> itemList = null;

        try {
            itemList = itemService.getSystemItemsForPage(systemId, order, pageNumber, pageSize);
        } catch (Exception e) {
            log.error(ErrorCode.GET_SYSTEM_ITEMS_PAGE_ERROR_MESSAGE, e);
            return Response.ok(new com.jeffy.scanner.bo.Response(ErrorCode.GET_SYSTEM_ITEMS_PAGE_ERROR_CODE, ErrorCode.GET_SYSTEM_ITEMS_PAGE_ERROR_MESSAGE + e.getMessage())).status(500).build();
        }

        return Response.ok(itemList, MediaType.APPLICATION_JSON).build();
    }

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addItem(Item item) {

        try {
            int status = itemService.addItem(item);
        } catch (Exception e) {
            log.error(ErrorCode.ADD_ITEM_ERROR_MESSAGE, e);
            return Response.ok(new com.jeffy.scanner.bo.Response(ErrorCode.ADD_ITEM_ERROR_CODE, ErrorCode.ADD_ITEM_ERROR_MESSAGE + e.getMessage())).status(500).build();
        }

        return Response.ok(new com.jeffy.scanner.bo.Response(CommonConstants.SUCCESS_CODE, CommonConstants.SUCCESS_MESSAGE)).build();
    }

    @PUT
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateItem(Item item) {

        try {
            int status = itemService.updateItem(item);
        } catch (Exception e) {
            log.error(ErrorCode.UPDATE_ITEM_ERROR_MESSAGE, e);
            return Response.ok(new com.jeffy.scanner.bo.Response(ErrorCode.UPDATE_ITEM_ERROR_CODE, ErrorCode.UPDATE_ITEM_ERROR_MESSAGE + e.getMessage())).status(500).build();
        }

        return Response.ok(new com.jeffy.scanner.bo.Response(CommonConstants.SUCCESS_CODE, CommonConstants.SUCCESS_MESSAGE)).build();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteItem(@PathParam("id") int itemId) {

        try {
            int status = itemService.deleteItem(itemId);
        } catch (Exception e) {
            log.error(ErrorCode.DELETE_ITEM_ERROR_MESSAGE, e);
            return Response.ok(new com.jeffy.scanner.bo.Response(ErrorCode.DELETE_ITEM_ERROR_CODE, ErrorCode.DELETE_ITEM_ERROR_MESSAGE + e.getMessage())).status(500).build();
        }

        return Response.ok(new com.jeffy.scanner.bo.Response(CommonConstants.SUCCESS_CODE, CommonConstants.SUCCESS_MESSAGE)).build();
    }
}
