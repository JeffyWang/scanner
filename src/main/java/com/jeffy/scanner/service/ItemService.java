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

    public Item getItem(int itemId) {
        return itemDao.getById(itemId);
    }

    public List<Item> getSystemItems(int systemId) {
        return itemDao.getSystemItems(systemId);
    }

    public List<Item> getSystemItemsForPage(int systemId, String order, int pageNumber, int pageSize) {
        return itemDao.getSystemItemsForPage(systemId, order, pageNumber * pageSize, pageSize);
    }

    public int addItem(Item item) {
        return itemDao.add(item);
    }

    public int updateItem(Item item) {
        return itemDao.update(item);
    }

    public int deleteItem(int itemId) {
        return itemDao.deleteById(itemId);
    }
}
