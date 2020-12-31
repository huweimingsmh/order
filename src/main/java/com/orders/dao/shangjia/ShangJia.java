package com.orders.dao.shangjia;

import java.util.Date;

public class ShangJia {
    private long id;
    private String phone;
    private String pwd;
    private String qq;
    private int selfMoney;
    private int yongjinMoney;
    private int zengzhiMoney;
    private int yaoqingMoney;
    private String superCode;
    private String branchNo;
    private byte sCheck;
    private Date cTime;

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

    public int getSelfMoney() {
        return selfMoney;
    }

    public void setSelfMoney(int selfMoney) {
        this.selfMoney = selfMoney;
    }

    public int getYongjinMoney() {
        return yongjinMoney;
    }

    public void setYongjinMoney(int yongjinMoney) {
        this.yongjinMoney = yongjinMoney;
    }

    public int getZengzhiMoney() {
        return zengzhiMoney;
    }

    public void setZengzhiMoney(int zengzhiMoney) {
        this.zengzhiMoney = zengzhiMoney;
    }

    public int getYaoqingMoney() {
        return yaoqingMoney;
    }

    public void setYaoqingMoney(int yaoqingMoney) {
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

    public byte getsCheck() {
        return sCheck;
    }

    public void setsCheck(byte sCheck) {
        this.sCheck = sCheck;
    }

    public Date getcTime() {
        return cTime;
    }

    public void setcTime(Date cTime) {
        this.cTime = cTime;
    }
}
