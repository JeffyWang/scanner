package com.jeffy.scanner.resource;

import com.jeffy.scanner.service.DataService;

/**
 * Created by Jeffy on 2015/1/12 0012.
 */
public class DataResource {
    private DataService dataService;

    public DataResource(DataService dataService) {
        this.dataService = dataService;
    }
}
