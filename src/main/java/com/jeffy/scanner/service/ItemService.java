package com.jeffy.scanner.service;

import com.jeffy.scanner.dao.DataDao;
import com.jeffy.scanner.dao.ItemDao;
import com.jeffy.scanner.dao.SystemDao;
import com.jeffy.scanner.model.*;
import com.jeffy.scanner.model.System;
import com.jeffy.scanner.task.MonitorTask;
import com.jeffy.scanner.util.MonitorItemUtil;

import java.util.List;
import java.util.Timer;

/**
 * Created by Jeffy on 2015/1/12 0012.
 */
public class ItemService {
    private ItemDao itemDao;
    private SystemDao systemDao;
    private DataDao dataDao;

    public ItemService(ItemDao itemDao, SystemDao systemDao, DataDao dataDao) {
        this.itemDao = itemDao;
        this.systemDao = systemDao;
        this.dataDao = dataDao;
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
        int status = itemDao.update(item);
        System system = systemDao.getById(item.getSystemId());
        String monitorUrl = MonitorItemUtil.getMonitorUrl(system);

        Timer t = TimerManageService.getTimer(item);
        t.cancel();
        TimerManageService.deleteTimer(item);
        Timer timer = new Timer();
        timer.schedule(new MonitorTask(dataDao, item, monitorUrl), item.getDelay(), item.getPeriod());
        TimerManageService.addTimer(item, timer);

        return status;
    }

    public int deleteItem(int itemId) {
        return itemDao.deleteById(itemId);
    }
}
