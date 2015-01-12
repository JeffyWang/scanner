package com.jeffy.scanner.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2015/1/10.
 */
public class Data extends Model implements Serializable {
    private static final long serialVersionUID = -2568631041439260399L;
    private String key;
    private String value;
    private int itemId;

    public Data() {
        super();
    }

    public Data(int id,  String key, String value, int itemId, Date createTime, Date updateTime) {
        super(id, createTime, updateTime);
        this.key = key;
        this.value = value;
        this.itemId = itemId;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }
}
