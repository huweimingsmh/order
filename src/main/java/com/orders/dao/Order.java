package com.orders.dao;

import java.util.Date;

public class Order {
    private long id;
    private String platform;
    private String taobaoVip;
    private String oId;
    private String tId;
    private String sjPhone;
    private String bPhone;
    private String image;
    private int yaJin;
    private int sMoney;
    private int yongJin;
    private int state;
    private int tType;
    private Date cTime;
    private Date sTime;
    private String goodsName;
    private String shopName;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getTaobaoVip() {
        return taobaoVip;
    }

    public void setTaobaoVip(String taobaoVip) {
        this.taobaoVip = taobaoVip;
    }

    public String getoId() {
        return oId;
    }

    public void setoId(String oId) {
        this.oId = oId;
    }

    public String gettId() {
        return tId;
    }

    public void settId(String tId) {
        this.tId = tId;
    }

    public String getSjPhone() {
        return sjPhone;
    }

    public void setSjPhone(String sjPhone) {
        this.sjPhone = sjPhone;
    }

    public String getbPhone() {
        return bPhone;
    }

    public void setbPhone(String bPhone) {
        this.bPhone = bPhone;
    }

    public int getYaJin() {
        return yaJin;
    }

    public void setYaJin(int yaJin) {
        this.yaJin = yaJin;
    }

    public int getsMoney() {
        return sMoney;
    }

    public void setsMoney(int sMoney) {
        this.sMoney = sMoney;
    }

    public int getYongJin() {
        return yongJin;
    }

    public void setYongJin(int yongJin) {
        this.yongJin = yongJin;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Date getcTime() {
        return cTime;
    }

    public String getImage() {
        return image;
    }

    public int gettType() {
        return tType;
    }

    public void settType(int tType) {
        this.tType = tType;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setcTime(Date cTime) {
        this.cTime = cTime;
    }

    public Date getsTime() {
        return sTime;
    }

    public void setsTime(Date sTime) {
        this.sTime = sTime;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }
}
