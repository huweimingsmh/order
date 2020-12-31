package com.orders.dao;

import java.util.Date;

public class TransferWater {
    private long id;
    private String phone;
    private int wMoney;
    private String bankName;
    private String bankNo;
    private String bankPerson;
    private int state;
    private String aDes;
    private Date sTime;
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



    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankNo() {
        return bankNo;
    }

    public void setBankNo(String bankNo) {
        this.bankNo = bankNo;
    }

    public String getBankPerson() {
        return bankPerson;
    }

    public void setBankPerson(String bankPerson) {
        this.bankPerson = bankPerson;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getaDes() {
        return aDes;
    }

    public void setaDes(String aDes) {
        this.aDes = aDes;
    }

    public int getwMoney() {
        return wMoney;
    }

    public void setwMoney(int wMoney) {
        this.wMoney = wMoney;
    }

    public Date getsTime() {
        return sTime;
    }

    public void setsTime(Date sTime) {
        this.sTime = sTime;
    }

    public Date getcTime() {
        return cTime;
    }

    public void setcTime(Date cTime) {
        this.cTime = cTime;
    }
}
