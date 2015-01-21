package com.jeffy.scanner.task;

import com.jeffy.scanner.constants.ErrorCode;
import com.jeffy.scanner.dao.DataDao;
import com.jeffy.scanner.model.Data;
import com.jeffy.scanner.model.Item;
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
    private DataDao dataDao;
    private Item item;
    private String url;

    public MonitorTask(DataDao dataDao, Item item, String url) {
        this.dataDao = dataDao;
        this.item = item;
        this.url = url;
    }

    @Override
    public void run() {
        try {
            log.debug("url : "+ url +" , object : " + item.getObject() + ", attribute : " + item.getAttribute());
            J4pResponse response = J4pClientUtil.getData(url, item.getObject(), item.getAttribute());
            log.info(response.asJSONObject());

            Data data = new Data();
            data.setItemId(item.getId());
            data.setMonitorKey(item.getObject() + "/" + item.getAttribute());
            data.setMonitorValue(response.asJSONObject().get("value").toString());

            dataDao.add(data);

        } catch (MalformedObjectNameException e) {
            log.error(ErrorCode.GET_MONITOR_DATA_ERROR_MESSAGE, e);
        } catch (J4pException e) {
            log.error(ErrorCode.GET_MONITOR_DATA_ERROR_MESSAGE, e);
        }
    }
}
