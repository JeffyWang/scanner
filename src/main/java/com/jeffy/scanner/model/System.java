package com.jeffy.scanner.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by jeffy on 2015/1/9 0009.
 */
public class System extends Model implements Serializable {
    private static final long serialVersionUID = 4125817890369701218L;
    private String name;
    private String host;
    private int port;
    private String status;

    public System() {
        super();
    }

    public System(int id, String name, String host, int port, String status, Date createTime, Date updateTime) {
        super(id, createTime, updateTime);
        this.name = name;
        this.host = host;
        this.port = port;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "System{" +
                "id='" + getId() + '\'' +
                "name='" + name + '\'' +
                ", host='" + host + '\'' +
                ", port=" + port +
                ", status=" + status +
                ", createTime=" + getCreateTime() +
                ", updateTime=" + getUpdateTime() +
                '}';
    }
}
