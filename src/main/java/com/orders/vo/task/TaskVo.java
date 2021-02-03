package com.orders.vo.task;

import javax.naming.ldap.PagedResultsControl;
import java.util.List;

public class TaskVo {
    private int taskType;
    private List<GoodsInfoVo> goodsInfo;
    private List<SouSuoVo> souSuo;
    private FindGoodsVo findGoods;
    private PingJiaVo pingJia;
    private ZengZhiVo zengZhi;
    private TimeTaskVo pushTime;
    private String liuYan;
    private String shenHe;

    private int fanKuan;
    private String phone;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getTaskType() {
        return taskType;
    }

    public void setTaskType(int taskType) {
        this.taskType = taskType;
    }

    public List<GoodsInfoVo> getGoodsInfo() {
        return goodsInfo;
    }

    public void setGoodsInfo(List<GoodsInfoVo> goodsInfo) {
        this.goodsInfo = goodsInfo;
    }

    public List<SouSuoVo> getSouSuo() {
        return souSuo;
    }

    public void setSouSuo(List<SouSuoVo> souSuo) {
        this.souSuo = souSuo;
    }

    public FindGoodsVo getFindGoods() {
        return findGoods;
    }

    public void setFindGoods(FindGoodsVo findGoods) {
        this.findGoods = findGoods;
    }

    public PingJiaVo getPingJia() {
        return pingJia;
    }

    public void setPingJia(PingJiaVo pingJia) {
        this.pingJia = pingJia;
    }

    public ZengZhiVo getZengZhi() {
        return zengZhi;
    }

    public void setZengZhi(ZengZhiVo zengZhi) {
        this.zengZhi = zengZhi;
    }

    public TimeTaskVo getPushTime() {
        return pushTime;
    }

    public void setPushTime(TimeTaskVo pushTime) {
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
}
