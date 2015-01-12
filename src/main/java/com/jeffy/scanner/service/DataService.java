package com.jeffy.scanner.service;

import com.jeffy.scanner.dao.DataDao;
import com.jeffy.scanner.dao.ItemDao;
import com.jeffy.scanner.dao.SystemDao;

/**
 * Created by Jeffy on 2015/1/12 0012.
 */
public class DataService {
    private SystemDao systemDao;
    private ItemDao itemDao;
    private DataDao dataDao;

    public DataService(SystemDao systemDao, ItemDao itemDao, DataDao dataDao) {
        this.systemDao = systemDao;
        this.itemDao = itemDao;
        this.dataDao = dataDao;
    }
}
