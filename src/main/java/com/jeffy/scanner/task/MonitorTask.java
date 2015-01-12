package com.jeffy.scanner.task;

import com.jeffy.scanner.constants.ErrorCode;
import com.jeffy.scanner.service.DataService;
import com.jeffy.scanner.util.J4pClientUtil;
import org.apache.log4j.Logger;
import org.jolokia.client.exception.J4pException;
import org.jolokia.client.request.J4pResponse;

import javax.management.MalformedObjectNameException;
import java.util.TimerTask;

/**
 * Created by Jeffy on 2015/1/12 0012.
 */
public class MonitorTask extends TimerTask {
    private Logger log = Logger.getLogger(this.getClass());
    private DataService dataService;
    private String url;
    private String object;
    private String attribute;

    public MonitorTask(DataService dataService, String url, String object, String attribute) {
        this.dataService = dataService;
        this.url = url;
        this.object = object;
        this.attribute = attribute;
    }

    @Override
    public void run() {
        try {
            log.debug("url : "+ url +" , object : " + object + ", attribute : " + attribute);
            J4pResponse response = J4pClientUtil.getData(url, object, attribute);
            log.info(response.asJSONObject());
        } catch (MalformedObjectNameException e) {
            log.error(ErrorCode.GET_MONITOR_DATA_ERROR_MESSAGE, e);
        } catch (J4pException e) {
            log.error(ErrorCode.GET_MONITOR_DATA_ERROR_MESSAGE, e);
        }
    }
}
