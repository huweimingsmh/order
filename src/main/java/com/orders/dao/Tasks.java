package com.orders.dao;

import com.orders.vo.task.GoodsInfoVo;
import com.orders.vo.task.SouSuoVo;

import java.util.Date;
import java.util.List;

public class Tasks {

    private String id;
    private String goodsInfo;
    private String souSuo;
    private String findGoods;
    private String pingJia;
    private String zengZhi;
    private String pushTime;
    private String liuYan;
    private String shenHe;
    private int fanKuan;
    private double totalCost;
    private double serviceCost;
    private String phone;
    private int state;
    private int getState;
    private String shopName;
    private String goodsName;
    private int taskType;
    private String taskSet;
    private Date cTime;
    private Date sTime;
    private Date tTime;
    private String platform;
    private String shenHer;
    private int orderCount;


    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public Date gettTime() {
        return tTime;
    }

    public void settTime(Date tTime) {
        this.tTime = tTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGoodsInfo() {
        return goodsInfo;
    }

    public void setGoodsInfo(String goodsInfo) {
        this.goodsInfo = goodsInfo;
    }

    public String getSouSuo() {
        return souSuo;
    }

    public void setSouSuo(String souSuo) {
        this.souSuo = souSuo;
    }

    public String getTaskSet() {
        return taskSet;
    }

    public void setTaskSet(String taskSet) {
        this.taskSet = taskSet;
    }

    public String getFindGoods() {
        return findGoods;
    }

    public void setFindGoods(String findGoods) {
        this.findGoods = findGoods;
    }

    public String getPingJia() {
        return pingJia;
    }

    public void setPingJia(String pingJia) {
        this.pingJia = pingJia;
    }

    public String getZengZhi() {
        return zengZhi;
    }

    public void setZengZhi(String zengZhi) {
        this.zengZhi = zengZhi;
    }

    public String getPushTime() {
        return pushTime;
    }

    public void setPushTime(String pushTime) {
        this.pushTime = pushTime;
    }

    public String getLiuYan() {
        return liuYan;
    }

    public void setLiuYan(String liuYan) {
        this.liuYan = liuYan;
    }

    public String getShenHe() {
        return shenHe;
    }

    public void setShenHe(String shenHe) {
        this.shenHe = shenHe;
    }

    public int getFanKuan() {
        return fanKuan;
    }

    public void setFanKuan(int fanKuan) {
        this.fanKuan = fanKuan;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public double getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(double serviceCost) {
        this.serviceCost = serviceCost;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getGetState() {
        return getState;
    }

    public void setGetState(int getState) {
        this.getState = getState;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public int getTaskType() {
        return taskType;
    }

    public void setTaskType(int taskType) {
        this.taskType = taskType;
    }

    public Date getcTime() {
        return cTime;
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

    public String getShenHer() {
        return shenHer;
    }

    public void setShenHer(String shenHer) {
        this.shenHer = shenHer;
    }

    public int getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(int orderCount) {
        this.orderCount = orderCount;
    }
}
