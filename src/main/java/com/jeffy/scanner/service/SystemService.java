package com.jeffy.scanner.service;

import com.jeffy.scanner.dao.SystemDao;
import com.jeffy.scanner.model.System;

import java.util.List;

/**
 * Created by Administrator on 2015/1/10.
 */
public class SystemService {
    private SystemDao systemDao;

    public SystemService(SystemDao systemDao) {
        this.systemDao = systemDao;
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
        return systemDao.add(system);
    }

    public int updateSystem(System system) {
        return systemDao.update(system);
    }

    public int deleteSystem(int systemId) {
        return systemDao.deleteById(systemId);
    }
}
