package com.jeffy.scanner.model;

import org.jolokia.client.request.J4pReadRequest;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2015/1/10.
 */
public class Item  extends Model implements Serializable {
    private static final long serialVersionUID = -3770046401893643662L;
    private String name;
    private int systemId;
    private String object;
    private String attribute;

    public Item() {
        super();
    }

    public Item(int id, String name, int systemId, String object, String attribute, Date createTime, Date updateTime) {
        super(id, createTime, updateTime);
        this.name = name;
        this.systemId = systemId;
        this.object = object;
        this.attribute = attribute;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSystemId() {
        return systemId;
    }

    public void setSystemId(int systemId) {
        this.systemId = systemId;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }
}
