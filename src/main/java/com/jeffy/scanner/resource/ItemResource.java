package com.jeffy.scanner.resource;

import com.jeffy.scanner.service.ItemService;

/**
 * Created by Jeffy on 2015/1/12 0012.
 */
public class ItemResource {
    private ItemService itemService;

    public ItemResource(ItemService itemService) {
        this.itemService = itemService;
    }
}
