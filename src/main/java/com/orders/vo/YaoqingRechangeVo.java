package com.orders.vo;

import com.orders.dao.Dao;

public class YaoqingRechangeVo implements Dao {

    private double selfMoney;
    private double yaoqingMoney;


    public YaoqingRechangeVo(double selfMoney, double yaoqingMoney) {
        this.selfMoney = selfMoney;
        this.yaoqingMoney = yaoqingMoney;
    }

    public YaoqingRechangeVo(){

    }

    public double getSelfMoney() {
        return selfMoney;
    }

    public void setSelfMoney(double selfMoney) {
        this.selfMoney = selfMoney;
    }

    public double getYaoqingMoney() {
        return yaoqingMoney;
    }

    public void setYaoqingMoney(double yaoqingMoney) {
        this.yaoqingMoney = yaoqingMoney;
    }
}
