package com.orders.dao.shops;

import com.orders.dao.Dao;

import java.util.Date;

public class Shop implements Dao {
    private long id;
    private String phone;
    private String name;
    private String wangWang;
    private int state;
    private String sDesc;
    private String sWhere;
    private String address;
    private String sPhone;
    private String platform;
    private String image;
    private Date sTime;


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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWangWang() {
        return wangWang;
    }

    public void setWangWang(String wangWang) {
        this.wangWang = wangWang;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getsDesc() {
        return sDesc;
    }

    public void setsDesc(String sDesc) {
        this.sDesc = sDesc;
    }

    public String getsWhere() {
        return sWhere;
    }

    public void setsWhere(String sWhere) {
        this.sWhere = sWhere;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getsPhone() {
        return sPhone;
    }

    public void setsPhone(String sPhone) {
        this.sPhone = sPhone;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getsTime() {
        return sTime;
    }

    public void setsTime(Date sTime) {
        this.sTime = sTime;
    }
}
