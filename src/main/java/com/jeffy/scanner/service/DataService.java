package com.jeffy.scanner.service;

import com.jeffy.scanner.dao.DataDao;
import com.jeffy.scanner.dao.ItemDao;
import com.jeffy.scanner.dao.SystemDao;
import com.jeffy.scanner.model.Data;

import java.util.List;

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

    public List<Data> getItemData(int itemId) {
        return dataDao.getItemData(itemId);
    }

    public List<Data> getItemDataForPeriod(int itemId, String startTime, String endTime) {
        return dataDao.getItemDataForPeriod(itemId, startTime, endTime);
    }

    public int addData(Data data) {
        return dataDao.add(data);
    }

    public int deleteData(int dataId) {
        return dataDao.delete(dataId);
    }
}
