package com.jeffy.scanner.util;

import org.jolokia.client.J4pClient;
import org.jolokia.client.exception.J4pException;
import org.jolokia.client.request.J4pReadRequest;
import org.jolokia.client.request.J4pRequest;
import org.jolokia.client.request.J4pResponse;

import javax.management.MalformedObjectNameException;

/**
 * Created by Jeffy on 2015/1/12 0012.
 */
public class J4pClientUtil {
    public static J4pResponse getData(String url, String object, String attribute) throws MalformedObjectNameException, J4pException {
        J4pClient client = new J4pClient(url);
        J4pRequest request = new J4pReadRequest(object, attribute);
        return client.execute(request);
    }
}
