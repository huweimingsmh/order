package com.orders.mapper;

import com.orders.dao.Order;
import com.orders.vo.order.OrderStateCountVo;
import com.orders.vo.task.TaskStateCountsVo;
import org.apache.ibatis.annotations.Mapper;

import java.sql.SQLException;
import java.util.List;

@Mapper
public interface OrderMapper {

    public Order getOrderByStid(String stid)throws SQLException;

    public Order getOrderSTID(String oid)throws SQLException;

    public List<Order> getOrderByDownTime(String phone, String startTime, String endTime)throws SQLException;

    public List<Order> getOrderBySubmitTime(String phone,String startTime,String endTime)throws SQLException;

    public List<Order> getOrderByState(String phone,int state)throws SQLException;

    public List<Order> getOrderByGoodsName(String phone,String goodsName)throws SQLException;

    public List<Order>  getOrderByShopName(String phone,String shopName)throws SQLException;

    public List<Order> getOrderByVip(String phone,String vip)throws SQLException;

    public void createOrder(Order order)throws SQLException;

    public List<Order> getOrderRefundCount(String phone)throws SQLException;

    public int getOrderRewardCount(String phone)throws SQLException;

    public TaskStateCountsVo getOrderStateCount(String tid)throws SQLException;

    public void updateState(String stid,int state)throws SQLException;


    public List<Order> getOrderByBuyer(String phone)throws SQLException;

    public List<Order> getOrderByTid(String tid);


}