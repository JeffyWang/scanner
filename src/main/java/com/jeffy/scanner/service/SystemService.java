package com.jeffy.scanner.service;

import com.jeffy.scanner.dao.SystemDao;
import com.jeffy.scanner.model.System;

/**
 * Created by Administrator on 2015/1/10.
 */
public class SystemService {
    private SystemDao systemDao;

    public SystemService(SystemDao systemDao) {
        this.systemDao = systemDao;
    }

    public System getSystem(int id) {
        return systemDao.getById(id);
    }

    public System getSystem(String name) {
        return systemDao.getByName(name);
    }
}
