package com.jeffy.scanner.service;

import com.jeffy.scanner.dao.ItemDao;
import com.jeffy.scanner.dao.SystemDao;
import com.jeffy.scanner.model.Item;

import java.util.List;

/**
 * Created by Jeffy on 2015/1/12 0012.
 */
public class ItemService {
    private ItemDao itemDao;
    private SystemDao systemDao;

    public ItemService(SystemDao systemDao, ItemDao itemDao) {
        this.systemDao = systemDao;
        this.itemDao = itemDao;
    }

    public Item getSystem(int systemId) {
        return itemDao.getById(systemId);
    }

    public Item getSystem(String name) {
        return itemDao.getByName(name);
    }

    public List<Item> getAllSystem() {
        return itemDao.getAll();
    }

    public List<Item> getSystemForPage(String order, int pageNumber, int pageSize) {
        return null;
    }
}
