package com.orders.utils.statecode;

//订单状态
public interface OrderState {
    //进行中
    public int  RUNING=1;
    //待返款
    public int DAIFANKUAN=2;
    //收货中
    public int SHOUHUO=3;
    //待返佣金
    public int DAIYONGJIN=4;
    //已完成
    public int WANCHENG=5;
    //返款不通过
    public int FANKUANNOTPASS=6;
    //佣金不通过
    public int YONGJINNOTPASS=7;
}
