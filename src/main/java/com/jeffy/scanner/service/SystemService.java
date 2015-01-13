package com.jeffy.scanner.service;

import com.jeffy.scanner.constants.CommonConstants;
import com.jeffy.scanner.dao.ItemDao;
import com.jeffy.scanner.dao.SystemDao;
import com.jeffy.scanner.model.Item;
import com.jeffy.scanner.model.System;
import com.jeffy.scanner.util.MonitorItemUtil;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Administrator on 2015/1/10.
 */
public class SystemService {
    private SystemDao systemDao;
    private ItemDao itemDao;

    public SystemService(SystemDao systemDao, ItemDao itemDao) {
        this.systemDao = systemDao;
        this.itemDao = itemDao;
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
        int status = systemDao.add(system);
        System s = systemDao.getByName(system.getName());

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
}
