package com.orders.vo;

import com.orders.dao.Dao;

public class YongJiRechangeVo implements Dao {
    private double selfMoney;
    private double yongJiMoney;

    public YongJiRechangeVo(double selfMoney, double yongJiMoney) {
        this.selfMoney = selfMoney;
        this.yongJiMoney = yongJiMoney;
    }

    public YongJiRechangeVo(){

    }

    public double getSelfMoney() {
        return selfMoney;
    }

    public void setSelfMoney(double selfMoney) {
        this.selfMoney = selfMoney;
    }

    public double getYongJiMoney() {
        return yongJiMoney;
    }

    public void setYongJiMoney(double yongJiMoney) {
        this.yongJiMoney = yongJiMoney;
    }
}
