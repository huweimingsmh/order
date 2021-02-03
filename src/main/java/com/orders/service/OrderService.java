package com.orders.service;

import com.orders.dao.Order;
import com.orders.dao.ShenSu;
import com.orders.vo.order.JieDanVo;
import com.orders.vo.order.OrderInfo;
import com.orders.vo.order.OrderShowVo;
import com.orders.vo.order.OrderStateCountVo;

import java.util.List;

public interface OrderService {

    public OrderShowVo getOrderByStid(String stid);

    public OrderShowVo getOrderSTID(String oid);

    public List<OrderShowVo> getOrderByDownTime(String phone, String startTime, String endTime);

    public List<OrderShowVo> getOrderBySubmitTime(String phone,String startTime,String endTime);

    public List<OrderShowVo> getOrderByState(String phone,int state);

    public List<OrderShowVo> getOrderByGoodsName(String phone,String goodsName);

    public List<OrderShowVo>  getOrderByShopName(String phone,String shopName);

    public List<OrderShowVo> getOrderByVip(String phone,String vip);

    public void createOrder(JieDanVo vo);

    public OrderStateCountVo getOrderRefundCount(String phone);

    //public int getOrderRewardCount(String phone);

    public OrderInfo showOrderInfo(String stid);

    public void faFangKuan(String stid);

    public void notFaFangKuan(String stid);

    public OrderStateCountVo getOrderStateTongJi(String tid);

    public List<OrderShowVo> getOrderByBuyer(String phone);

    public void downOrder(JieDanVo jieDan);


}
