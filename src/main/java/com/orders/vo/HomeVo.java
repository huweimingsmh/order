package com.orders.vo;

import java.util.List;

public class HomeVo {
    private int refund;
    private int reward;
    private int msgCount;
    private int shenSuCount;
    private String cCode;
    private List<NoticVo> noticList;
    private int sMoney;
    private int yjMoney;
    private int ytMoney;
    private int isC;
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

    public int getsMoney() {
        return sMoney;
    }

    public void setsMoney(int sMoney) {
        this.sMoney = sMoney;
    }

    public int getYjMoney() {
        return yjMoney;
    }

    public void setYjMoney(int yjMoney) {
        this.yjMoney = yjMoney;
    }

    public int getYtMoney() {
        return ytMoney;
    }

    public void setYtMoney(int ytMoney) {
        this.ytMoney = ytMoney;
    }

    public int getIsC() {
        return isC;
    }

    public void setIsC(int isC) {
        this.isC = isC;
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