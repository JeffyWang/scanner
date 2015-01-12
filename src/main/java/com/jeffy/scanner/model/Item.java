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
    private long delay;
    private long period;

    public Item() {
        super();
    }

    public Item(int id, String name, int systemId, String object, String attribute, long delay, long period, Date createTime, Date updateTime) {
        super(id, createTime, updateTime);
        this.name = name;
        this.systemId = systemId;
        this.object = object;
        this.attribute = attribute;
        this.delay = delay;
        this.period = period;
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

    public long getDelay() {
        return delay;
    }

    public void setDelay(long delay) {
        this.delay = delay;
    }

    public long getPeriod() {
        return period;
    }

    public void setPeriod(long period) {
        this.period = period;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", systemId=" + systemId +
                ", object='" + object + '\'' +
                ", attribute='" + attribute + '\'' +
                ", delay=" + delay +
                ", period=" + period +
                ", createTime=" + getCreateTime() +
                ", updateTime=" + getUpdateTime() +
                '}';
    }
}
