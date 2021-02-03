package com.orders.dao.shangjia;

import java.util.Date;

public class ShangJia {
    private long id;
    private String phone;
    private String pwd;
    private String qq;
    private double selfMoney;
    private double yongjinMoney;
    private double zengzhiMoney;
    private double yaoqingMoney;
    private String superCode;
    private String branchNo;
    private int sCheck;
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

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public double getSelfMoney() {
        return selfMoney;
    }

    public void setSelfMoney(double selfMoney) {
        this.selfMoney = selfMoney;
    }

    public double getYongjinMoney() {
        return yongjinMoney;
    }

    public void setYongjinMoney(double yongjinMoney) {
        this.yongjinMoney = yongjinMoney;
    }

    public double getZengzhiMoney() {
        return zengzhiMoney;
    }

    public void setZengzhiMoney(double zengzhiMoney) {
        this.zengzhiMoney = zengzhiMoney;
    }

    public double getYaoqingMoney() {
        return yaoqingMoney;
    }

    public void setYaoqingMoney(double yaoqingMoney) {
        this.yaoqingMoney = yaoqingMoney;
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

    public int getsCheck() {
        return sCheck;
    }

    public void setsCheck(int sCheck) {
        this.sCheck = sCheck;
    }

    public Date getcTime() {
        return cTime;
    }

    public void setcTime(Date cTime) {
        this.cTime = cTime;
    }
}
