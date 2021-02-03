package com.orders.vo.order;

import com.orders.vo.ShenSuRVo;
import com.orders.vo.shensu.OrderShenSuShowVo;

import java.util.List;

public class OrderInfo {
    private String stid;
    private String shopName;
    private String bid;
    private String qq;
    private String bphone;
    private String bvip;
    private List<OrderSouSuoVo> souSuos;
    private String adAn;
    private String sjMoneySet;
    private String bpMoney;
    private String oid;
    private List<String> pingJias;
    private String sjFanKuan;
    private String hsTime;
    //奖励核实时间
    private String rTime;
    private OrderShenSuShowVo shenSu;


    public String getStid() {
        return stid;
    }

    public void setStid(String stid) {
        this.stid = stid;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getBphone() {
        return bphone;
    }

    public void setBphone(String bphone) {
        this.bphone = bphone;
    }

    public String getBvip() {
        return bvip;
    }

    public void setBvip(String bvip) {
        this.bvip = bvip;
    }

    public List<OrderSouSuoVo> getSouSuos() {
        return souSuos;
    }

    public void setSouSuos(List<OrderSouSuoVo> souSuos) {
        this.souSuos = souSuos;
    }

    public String getAdAn() {
        return adAn;
    }

    public void setAdAn(String adAn) {
        this.adAn = adAn;
    }



    public List<String> getPingJias() {
        return pingJias;
    }

    public void setPingJias(List<String> pingJias) {
        this.pingJias = pingJias;
    }

    public String getSjMoneySet() {
        return sjMoneySet;
    }

    public void setSjMoneySet(String sjMoneySet) {
        this.sjMoneySet = sjMoneySet;
    }

    public String getBpMoney() {
        return bpMoney;
    }

    public void setBpMoney(String bpMoney) {
        this.bpMoney = bpMoney;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getSjFanKuan() {
        return sjFanKuan;
    }

    public void setSjFanKuan(String sjFanKuan) {
        this.sjFanKuan = sjFanKuan;
    }

    public String getHsTime() {
        return hsTime;
    }

    public void setHsTime(String hsTime) {
        this.hsTime = hsTime;
    }

    public String getrTime() {
        return rTime;
    }

    public void setrTime(String rTime) {
        this.rTime = rTime;
    }

    public OrderShenSuShowVo getShenSu() {
        return shenSu;
    }

    public void setShenSu(OrderShenSuShowVo shenSu) {
        this.shenSu = shenSu;
    }
}
