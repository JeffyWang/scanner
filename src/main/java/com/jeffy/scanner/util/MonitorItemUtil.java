package com.jeffy.scanner.util;

import com.jeffy.scanner.constants.MonitorConstants;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jeffy on 2015/1/13 0013.
 */
public class MonitorItemUtil {
    public static Map<String, String> getDefaultItem() {
        Map<String, String> defaultItem = new HashMap<String, String>();
        defaultItem.put(MonitorConstants.MEMORY_OBJECT, MonitorConstants.MEMORY_HEAP_MEMORY_USAGE);
        defaultItem.put(MonitorConstants.THREADING_OBJECT, MonitorConstants.THREADING_THREAD_COUNT);
        defaultItem.put(MonitorConstants.CLASS_LOADING_OBJECT, MonitorConstants.CLASS_LOADED_CLASS_COUNT);
        defaultItem.put(MonitorConstants.CPU_OBJECT, MonitorConstants.CPU_PROCESS_CPU_LOAD);

        return defaultItem;
    }
}
