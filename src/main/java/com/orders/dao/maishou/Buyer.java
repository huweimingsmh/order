package com.orders.dao.maishou;

import java.util.Date;

public class Buyer {
    private long id;
    private String phone;
    private String weiXin;
    private String taobaoVip;
    private String pwd;
    private byte sex;
    private String superCode;
    private String branchNo;
    private Date cTime;
    private int msgCount;
    private int shensuCount;

    public int getMsgCount() {
        return msgCount;
    }

    public void setMsgCount(int msgCount) {
        this.msgCount = msgCount;
    }

    public int getShensuCount() {
        return shensuCount;
    }

    public void setShensuCount(int shensuCount) {
        this.shensuCount = shensuCount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWeiXin() {
        return weiXin;
    }

    public void setWeiXin(String weiXin) {
        this.weiXin = weiXin;
    }

    public String getTaobaoVip() {
        return taobaoVip;
    }

    public void setTaobaoVip(String taobaoVip) {
        this.taobaoVip = taobaoVip;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public byte getSex() {
        return sex;
    }

    public void setSex(byte sex) {
        this.sex = sex;
    }

    public String getSuperCode() {
        return superCode;
    }

    public void setSuperCode(String superCode) {
        this.superCode = superCode;
    }

    public String getBranchNo() {
        return branchNo;
    }

    public void setBranchNo(String branchNo) {
        this.branchNo = branchNo;
    }

    public Date getcTime() {
        return cTime;
    }

    public void setcTime(Date cTime) {
        this.cTime = cTime;
    }
}
