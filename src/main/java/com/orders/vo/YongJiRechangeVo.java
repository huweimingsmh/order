package com.orders.vo;

import com.orders.dao.Dao;

public class YongJiRechangeVo implements Dao {
    private int selfMoney;
    private int yongJiMoney;

    public YongJiRechangeVo(int selfMoney, int yongJiMoney) {
        this.selfMoney = selfMoney;
        this.yongJiMoney = yongJiMoney;
    }

    public YongJiRechangeVo(){

    }

    public int getSelfMoney() {
        return selfMoney;
    }

    public void setSelfMoney(int selfMoney) {
        this.selfMoney = selfMoney;
    }

    public int getYongJiMoney() {
        return yongJiMoney;
    }

    public void setYongJiMoney(int yongJiMoney) {
        this.yongJiMoney = yongJiMoney;
    }
}
