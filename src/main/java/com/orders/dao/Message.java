package com.orders.dao;

import java.util.Date;

public class Message {
    private long id;
    private String senderPhone;
    private String receiverPhone;

    private String context;
    private String stId;
    private String taobaoVip;
    //private String wangWang;
    private int builder;
    private String cTime;
    //private int isRead;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSenderPhone() {
        return senderPhone;
    }

    public void setSenderPhone(String senderPhone) {
        this.senderPhone = senderPhone;
    }

    public String getReceiverPhone() {
        return receiverPhone;
    }

    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone;
    }



    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getStId() {
        return stId;
    }

    public void setStId(String stId) {
        this.stId = stId;
    }

    public String getTaobaoVip() {
        return taobaoVip;
    }

    public void setTaobaoVip(String taobaoVip) {
        this.taobaoVip = taobaoVip;
    }

//    public String getWangWang() {
//        return wangWang;
//    }
//
//    public void setWangWang(String wangWang) {
//        this.wangWang = wangWang;
//    }


//    public int getIsRead() {
//        return isRead;
//    }
//
//    public void setIsRead(int isRead) {
//        this.isRead = isRead;
//    }

    public int getBuilder() {
        return builder;
    }

    public void setBuilder(int builder) {
        this.builder = builder;
    }

    public String getcTime() {
        return cTime;
    }

    public void setcTime(String cTime) {
        this.cTime = cTime;
    }
}

