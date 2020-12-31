package com.orders.vo;

import com.orders.dao.Dao;

public class YaoqingRechangeVo implements Dao {

    private int selfMoney;
    private int yaoqingMoney;


    public YaoqingRechangeVo(int selfMoney, int yaoqingMoney) {
        this.selfMoney = selfMoney;
        this.yaoqingMoney = yaoqingMoney;
    }

    public YaoqingRechangeVo(){

    }

    public int getSelfMoney() {
        return selfMoney;
    }

    public void setSelfMoney(int selfMoney) {
        this.selfMoney = selfMoney;
    }

    public int getYaoqingMoney() {
        return yaoqingMoney;
    }

    public void setYaoqingMoney(int yaoqingMoney) {
        this.yaoqingMoney = yaoqingMoney;
    }
}
