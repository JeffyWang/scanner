package com.jeffy.scanner.handler;

import com.jeffy.scanner.constants.CommonConstants;
import com.jeffy.scanner.dao.DataDao;
import com.jeffy.scanner.model.Item;
import com.jeffy.scanner.model.System;
import com.jeffy.scanner.service.ItemService;
import com.jeffy.scanner.service.SystemService;
import com.jeffy.scanner.service.TimerManageService;
import com.jeffy.scanner.task.MonitorTask;
import com.jeffy.scanner.util.MonitorItemUtil;

import java.util.List;
import java.util.Timer;

/**
 * Created by Jeffy on 2015/1/12 0012.
 */
public class MonitorHandler {
    private SystemService systemService;
    private ItemService itemService;
    private DataDao dataDao;

    public MonitorHandler(SystemService systemService, ItemService itemService, DataDao dataDao) {
        this.systemService = systemService;
        this.itemService = itemService;
        this.dataDao = dataDao;
    }

    public void execute() {
        List<System> systemList = systemService.getAllSystem();

        for (System system : systemList) {
            if(system.getStatus().equals(CommonConstants.MONITOR_STATUS_ON)){
                String monitorUrl = MonitorItemUtil.getMonitorUrl(system);
                List<Item> itemList = itemService.getSystemItems(system.getId());
                for (Item item : itemList) {
                    Timer timer = new Timer();
                    timer.schedule(new MonitorTask(dataDao, item, monitorUrl), item.getDelay(), item.getPeriod());
                    TimerManageService.addTimer(item, timer);
                }
            }
        }
    }
}
