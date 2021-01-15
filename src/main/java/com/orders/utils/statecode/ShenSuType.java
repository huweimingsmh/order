package com.orders.utils.statecode;

public interface ShenSuType {
    //1:商家发起,2:买手发起'
    public int SJ_BUILDER=1;
    public int BUY_BUILDER=2;
    //1:平台价入,0:平台没有介入'
    public int P_IN=1;
    public int P_NO=0;

    //1:申诉中,0:申诉关闭,-1:申诉取消',

    public int SS_ING=1;
    public int SS_CLOSE=0;
    public int SS_CANCEL=-1;
}
