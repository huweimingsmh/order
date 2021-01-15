package com.orders.service.orders;

import com.orders.dao.Order;
import com.orders.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value="orderService")
public class OrderServiceImpl implements OrderService {
    @Override
    public Order getOrderByStid(String stid) {
        return null;
    }

    @Override
    public String getOrderSTID(String oid) {
        return null;
    }

    @Override
    public List<Order> getOrderByDownTime(String phone, String startTime, String endTime) {
        return null;
    }

    @Override
    public List<Order> getOrderBySubmitTime(String phone, String startTime, String endTime) {
        return null;
    }

    @Override
    public List<Order> getOrderByState(String phone, int state) {
        return null;
    }

    @Override
    public List<Order> getOrderByGoodsName(String phone, String goodsName) {
        return null;
    }

    @Override
    public List<Order> getOrderByShopName(String phone, String shopName) {
        return null;
    }

    @Override
    public List<Order> getOrderByVip(String phone, String vip) {
        return null;
    }

    @Override
    public void createOrder() {

    }

    @Override
    public int getOrderRefundCount(String phone) {
        return 0;
    }

    @Override
    public int getOrderRewardCount(String phone) {
        return 0;
    }
}
