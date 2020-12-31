package com.orders.dao;

import java.util.Date;

public class Notice {
    private long id;
    private long sjId;
    private String context;
    private int state;
    private Date nTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getSjId() {
        return sjId;
    }

    public void setSjId(long sjId) {
        this.sjId = sjId;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Date getnTime() {
        return nTime;
    }

    public void setnTime(Date nTime) {
        this.nTime = nTime;
    }
}
