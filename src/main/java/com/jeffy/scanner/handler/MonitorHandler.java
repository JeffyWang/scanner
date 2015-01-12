package com.jeffy.scanner.handler;

import com.jeffy.scanner.model.Item;
import com.jeffy.scanner.model.System;
import com.jeffy.scanner.service.DataService;
import com.jeffy.scanner.service.ItemService;
import com.jeffy.scanner.service.SystemService;
import com.jeffy.scanner.task.MonitorTask;

import java.util.List;
import java.util.Timer;

/**
 * Created by Jeffy on 2015/1/12 0012.
 */
public class MonitorHandler {
    private SystemService systemService;
    private ItemService itemService;
    private DataService dataService;

    public MonitorHandler(SystemService systemService, ItemService itemService, DataService dataService) {
        this.systemService = systemService;
        this.itemService = itemService;
        this.dataService = dataService;
    }

    public void execute() {
        List<System> systemList = systemService.getAllSystem();

        for (System system : systemList) {
            String monitorUrl = getMonitorUrl(system);
            List<Item> itemList = itemService.getSystemItems(system.getId());
            for (Item item : itemList) {
                Timer timer = new Timer();
                timer.schedule(new MonitorTask(dataService, monitorUrl, item.getObject(), item.getAttribute()), item.getDelay(), item.getPeriod());
            }
        }
    }

    public String getMonitorUrl(System system) {
        return "http://" + system.getHost() + ":" + system.getPort() + "/jolokia";
    }
}
