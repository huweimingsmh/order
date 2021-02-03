package com.orders.vo.order;

public class OrderStateCountVo {
    private int runing;
    private int daiFanKuan;
    private int shouHuo;
    private int daiYongJin;
    private int wanCheng;

    public void addRuning(int runing){
        this.runing+=runing;
    }

    public void addDaiFanKuan(int daiFanKuan){
        this.daiFanKuan+=daiFanKuan;
    }

    public void addShouHuo(int shouHuo){
        this.shouHuo+=shouHuo;
    }

    public void addDaiYongJin(int daiYongJin){
        this.daiYongJin+=daiYongJin;
    }
    public void addWanCheng(int wanCheng){
        this.wanCheng+=wanCheng;
    }

    public int getRuning() {
        return runing;
    }

    public void setRuning(int runing) {
        this.runing = runing;
    }

    public int getDaiFanKuan() {
        return daiFanKuan;
    }

    public void setDaiFanKuan(int daiFanKuan) {
        this.daiFanKuan = daiFanKuan;
    }

    public int getShouHuo() {
        return shouHuo;
    }

    public void setShouHuo(int shouHuo) {
        this.shouHuo = shouHuo;
    }

    public int getDaiYongJin() {
        return daiYongJin;
    }

    public void setDaiYongJin(int daiYongJin) {
        this.daiYongJin = daiYongJin;
    }

    public int getWanCheng() {
        return wanCheng;
    }

    public void setWanCheng(int wanCheng) {
        this.wanCheng = wanCheng;
    }
}
