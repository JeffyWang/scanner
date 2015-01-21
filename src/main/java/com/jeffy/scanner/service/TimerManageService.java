package com.jeffy.scanner.service;

import com.jeffy.scanner.model.Item;

import java.util.HashMap;
import java.util.Map;
import java.util.Timer;

/**
 * Created by Jeffy on 2015/1/21 0021.
 */
public class TimerManageService {
    public static Map<String, Timer> TIMER_POOL = new HashMap<String, Timer>();

    public static Timer getTimer(Item item) {
        return TIMER_POOL.get(item.getId() + item.getName());
    }

    public static void addTimer(Item item, Timer timer) {
        TIMER_POOL.put(item.getId() + item.getName(), timer);
    }

    public static void deleteTimer(Item item) {
        TIMER_POOL.remove(item.getId() + item.getName());
    }
}
