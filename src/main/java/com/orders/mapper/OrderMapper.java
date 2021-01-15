package com.orders.mapper;

import com.orders.dao.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {

    public Order getOrderByStid(String stid);

    public String getOrderSTID(String oid);

    public List<Order> getOrderByDownTime(String phone, String startTime, String endTime);

    public List<Order> getOrderBySubmitTime(String phone,String startTime,String endTime);

    public List<Order> getOrderByState(String phone,int state);

    public List<Order> getOrderByGoodsName(String phone,String goodsName);

    public List<Order>  getOrderByShopName(String phone,String shopName);

    public List<Order> getOrderByVip(String phone,String vip);

    public void createOrder();

    public int getOrderRefundCount(String phone);

    public int getOrderRewardCount(String phone);


}