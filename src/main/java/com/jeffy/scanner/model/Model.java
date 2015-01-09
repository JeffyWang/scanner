package com.jeffy.scanner.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.lang.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by jeffy on 2015/1/9 0009.
 */
public class Model {
    private int id;
    private Date createTime;
    private Date updateTime;

    public Model() {
        Date now = new Date();
        this.createTime = now;
        this.updateTime = now;
    }

    public Model(int id, Date createTime, Date updateTime) {
        this.id = id;
        this.createTime =  createTime;
        this.updateTime = updateTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
