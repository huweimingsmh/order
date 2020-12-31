package com.orders.dao;

import java.util.Date;

public class AccountWater {
    private long id;
    private String phone;
    private int category;
    private String info;
    private int cMoney;
    private int rMoney;
    private Date tTime;

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

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getcMoney() {
        return cMoney;
    }

    public void setcMoney(int cMoney) {
        this.cMoney = cMoney;
    }

    public int getrMoney() {
        return rMoney;
    }

    public void setrMoney(int rMoney) {
        this.rMoney = rMoney;
    }

    public Date gettTime() {
        return tTime;
    }

    public void settTime(Date tMime) {
        this.tTime = tMime;
    }
}
