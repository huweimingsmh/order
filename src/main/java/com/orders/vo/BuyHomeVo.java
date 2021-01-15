package com.orders.vo;

import java.util.List;

public class BuyHomeVo {
    private int refund;
    private int reward;
    private int msgCount;
    private int shenSuCount;
    private String cCode;
    private List<NoticVo> noticList;
    private String phone;
    private long id;

    public int getRefund() {
        return refund;
    }

    public void setRefund(int refund) {
        this.refund = refund;
    }

    public int getReward() {
        return reward;
    }

    public void setReward(int reward) {
        this.reward = reward;
    }

    public int getMsgCount() {
        return msgCount;
    }

    public void setMsgCount(int msgCount) {
        this.msgCount = msgCount;
    }

    public int getShenSuCount() {
        return shenSuCount;
    }

    public void setShenSuCount(int shenSuCount) {
        this.shenSuCount = shenSuCount;
    }

    public String getcCode() {
        return cCode;
    }

    public void setcCode(String cCode) {
        this.cCode = cCode;
    }

    public List<NoticVo> getNoticList() {
        return noticList;
    }

    public void setNoticList(List<NoticVo> noticList) {
        this.noticList = noticList;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
