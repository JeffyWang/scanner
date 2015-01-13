package com.jeffy.scanner.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2015/1/10.
 */
public class Data extends Model implements Serializable {
    private static final long serialVersionUID = -2568631041439260399L;
    private String monitorKey;
    private String monitorValue;
    private int itemId;

    public Data() {
        super();
    }

    public Data(int id, String monitorKey, String monitorValue, int itemId, Date createTime, Date updateTime) {
        super(id, createTime, updateTime);
        this.monitorKey = monitorKey;
        this.monitorValue = monitorValue;
        this.itemId = itemId;
    }

    public String getMonitorKey() {
        return monitorKey;
    }

    public void setMonitorKey(String monitorKey) {
        this.monitorKey = monitorKey;
    }

    public String getMonitorValue() {
        return monitorValue;
    }

    public void setMonitorValue(String monitorValue) {
        this.monitorValue = monitorValue;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    @Override
    public String toString() {
        return "Data{" +
                "monitorKey='" + monitorKey + '\'' +
                ", monitorValue='" + monitorValue + '\'' +
                ", itemId=" + itemId +
                ", createTime=" + getCreateTime() +
                ", updateTime=" + getUpdateTime() +
                '}';
    }
}
