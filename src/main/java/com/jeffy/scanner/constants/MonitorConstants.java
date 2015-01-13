package com.jeffy.scanner.constants;

/**
 * Created by Jeffy on 2015/1/12 0012.
 */
public interface MonitorConstants {
    final static String MEMORY_NAME = "memory";
    final static String MEMORY_OBJECT = "java.lang:type=Memory";
    final static String MEMORY_HEAP_MEMORY_USAGE = "HeapMemoryUsage";

    final static String THREADING_NAME = "threading";
    final static String THREADING_OBJECT = "java.lang:type=Threading";
    final static String THREADING_THREAD_COUNT = "ThreadCount";

    final static String CLASS_NAME = "class";
    final static String CLASS_LOADING_OBJECT = "java.lang:type=ClassLoading";
    final static String CLASS_LOADED_CLASS_COUNT = "LoadedClassCount";

    final static String CPU_NAME = "cpu";
    final static String CPU_OBJECT = "java.lang:type=OperatingSystem";
    final static String CPU_PROCESS_CPU_LOAD = "ProcessCpuLoad";
}
