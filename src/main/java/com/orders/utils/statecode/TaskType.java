package com.orders.utils.statecode;

public interface TaskType {

    public int BUY_TASK=1;

    //收藏店铺
    public int  ATTACH_1=1;
    //收藏商品
    public int  ATTACH_2=2;
    //商品加入购物车
    public int  ATTACH_3=3;
    //假聊
    public int  ATTACH_4=4;

    //是包邮
    public int  BAOYOU_1=1;
    //不包邮
    public int BAOYOU_0=0;

    //任务未开始
    public int TASK_NOSTART=0;
    //任务进行中
    public int TASK_STARTING=1;
    //任务结束
    public int TASK_END=2;
    //任务待付款
    public int TASK_PAY=3;
    //任务取消
    public int TASK_CANCEL=4;

    //任务未领取
    public int TASK_NOGET=1;
    //任务已领取
    public int TASK_GET=2;

    //余额不足
    public int NOT_YUE=-1;
    //扣费成功
    public int KOUFEI_SUCC=1;

    //关键搜索
    public int WAY_KEY=1;
    //淘宝口令搜索
    public int WAY_TAOBAO=2;

    //平均发布
    public int  FANGSHI_1=1;
    //自定义发布
    public int FANGSHI_2=2;

    public int DAY_28=28;
    public int DAY_29=29;
    public int DAY_30=30;
    public int DAY_31=31;


}
