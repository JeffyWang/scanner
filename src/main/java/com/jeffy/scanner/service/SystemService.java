package com.jeffy.scanner.service;

import com.jeffy.scanner.constants.CommonConstants;
import com.jeffy.scanner.dao.DataDao;
import com.jeffy.scanner.dao.ItemDao;
import com.jeffy.scanner.dao.SystemDao;
import com.jeffy.scanner.model.Item;
import com.jeffy.scanner.model.System;
import com.jeffy.scanner.task.MonitorTask;
import com.jeffy.scanner.util.MonitorItemUtil;

import java.util.*;

/**
 * Created by Administrator on 2015/1/10.
 */
public class SystemService {
    private SystemDao systemDao;
    private ItemDao itemDao;
    private DataDao dataDao;

    public SystemService(SystemDao systemDao, ItemDao itemDao, DataDao dataDao) {
        this.systemDao = systemDao;
        this.itemDao = itemDao;
        this.dataDao = dataDao;
    }

    public System getSystem(int systemId) {
        return systemDao.getById(systemId);
    }

    public System getSystem(String name) {
        return systemDao.getByName(name);
    }

    public List<System> getAllSystem() {
        return systemDao.getAll();
    }

    public List<System> getSystemForPage(String order, int pageNumber, int pageSize) {
        return systemDao.getPage(order, pageNumber * pageSize, pageSize);
    }

    public int addSystem(System system) {
        int status = 0;
        System s = null;

        if (system.getStatus() == null) {
            system.setStatus(CommonConstants.MONITOR_STATUS_OFF);
            status = systemDao.add(system);
            s = systemDao.getByName(system.getName());
            return status;
        }

        status = systemDao.add(system);
        s = systemDao.getByName(system.getName());

        Map<String, String> defaultItem = MonitorItemUtil.getDefaultItem();
        for(Map.Entry<String, String> entry : defaultItem.entrySet()) {
            Item item = new Item();
            item.setObject(entry.getKey());
            item.setAttribute(entry.getValue());
            item.setDelay(CommonConstants.DEFAULT_DELAY);
            item.setPeriod(CommonConstants.DEFAULT_PERIOD);
            item.setSystemId(s.getId());
            itemDao.add(item);
        }

        String monitorUrl = MonitorItemUtil.getMonitorUrl(s);
        List<Item> itemList = itemDao.getSystemItems(s.getId());
        for (Item item : itemList) {
            Timer timer = new Timer();
            timer.schedule(new MonitorTask(dataDao, item, monitorUrl), item.getDelay(), item.getPeriod());
            TimerManageService.addTimer(item, timer);
        }

        return status;
    }

    public int updateSystem(System system) {
        return systemDao.update(system);
    }

    public int deleteSystem(int systemId) {
        int status = systemDao.deleteById(systemId);
        itemDao.deleteSystemItems(systemId);
        return status;
    }

    public int startMonitorSystem(int systemId) {
        System system = systemDao.getById(systemId);
        system.setStatus(CommonConstants.MONITOR_STATUS_ON);

        int status = systemDao.update(system);
        List<Item> itemList = itemDao.getSystemItems(systemId);
        String monitorUrl = MonitorItemUtil.getMonitorUrl(system);

        for(Item item : itemList) {
            Timer timer = new Timer();
            timer.schedule(new MonitorTask(dataDao, item, monitorUrl), item.getDelay(), item.getPeriod());
            TimerManageService.addTimer(item, timer);
        }

        return status;
    }

    public int stopMonitorSystem(int systemId) {
        System system = systemDao.getById(systemId);
        system.setStatus(CommonConstants.MONITOR_STATUS_OFF);

        int status = systemDao.update(system);
        List<Item> itemList = itemDao.getSystemItems(systemId);

        for(Item item : itemList) {
            Timer timer = TimerManageService.getTimer(item);
            timer.cancel();
            TimerManageService.deleteTimer(item);
        }

        return status;
    }
}
