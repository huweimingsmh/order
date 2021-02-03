package com.orders.controller.orders;

import com.orders.service.OrderService;
import com.orders.vo.order.JieDanVo;
import com.orders.vo.order.OrderInfo;
import com.orders.vo.order.OrderShowVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class OrdersController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/gobstid", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public OrderShowVo getOrderByStid(@RequestBody Map<String,Object> param){
        String stid=(String)param.get("stid");
        return orderService.getOrderByStid(stid);
    }

    @RequestMapping(value = "/gooid", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public OrderShowVo getOrderSTID(@RequestBody Map<String,Object> param){
        String oid=(String)param.get("oid");
        return orderService.getOrderSTID(oid);
    }

    @RequestMapping(value = "/gobdt", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<OrderShowVo> getOrderByDownTime(@RequestBody Map<String,Object> param){
        String phone=(String)param.get("phone");
        String startTime=(String)param.get("startTime");
        String endTime=(String)param.get("endTime");
        return orderService.getOrderByDownTime(phone,startTime,endTime);

    }

    @RequestMapping(value = "/gobst", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<OrderShowVo> getOrderBySubmitTime(@RequestBody Map<String,Object> param){
        String phone=(String)param.get("phone");
        String startTime=(String)param.get("startTime");
        String endTime=(String)param.get("endTime");
        return orderService.getOrderBySubmitTime(phone,startTime,endTime);
    }

    @RequestMapping(value = "/gobstate", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<OrderShowVo> getOrderByState(@RequestBody Map<String,Object> param){
        String phone=(String)param.get("phone");
        int state=Integer.valueOf((String)param.get("state"));
        return orderService.getOrderByState(phone,state);
    }

    @RequestMapping(value = "/gobgn", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<OrderShowVo> getOrderByGoodsName(@RequestBody Map<String,Object> param){
        String phone=(String)param.get("phone");
        String goodsName=(String)param.get("goodsName");
        return orderService.getOrderByGoodsName(phone,goodsName);

    }

    @RequestMapping(value = "/gobsn", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<OrderShowVo>  getOrderByShopName(@RequestBody Map<String,Object> param){
        String phone=(String)param.get("phone");
        String shopName=(String)param.get("shopName");
        return orderService.getOrderByShopName(phone,shopName);
    }

    @RequestMapping(value = "/gobvip", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<OrderShowVo> getOrderByVip(@RequestBody Map<String,Object> param){
        String phone=(String)param.get("phone");
        String vip=(String)param.get("vip");
        return orderService.getOrderByVip(phone,vip);
    }

    @RequestMapping(value = "/cojd", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public void createOrder(@RequestBody JieDanVo vo){
        if(null!=vo) {
            orderService.createOrder(vo);
        }
    }

    @RequestMapping(value = "/goinfo", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public OrderInfo getOrderInfo(@RequestBody Map<String,Object> param){
        String stid=(String)param.get("stid");
        return orderService.showOrderInfo(stid);
    }

    @RequestMapping(value = "/fafan", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public void faFan(@RequestBody Map<String,Object> param){
        //同意发放
        String stid=(String)param.get("stid");
         orderService.faFangKuan(stid);
    }

    @RequestMapping(value = "/notfafan", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public void notFaFan(@RequestBody Map<String,Object> param){
        //拒绝发放
        String stid=(String)param.get("stid");
        orderService.notFaFangKuan(stid);
    }


    @RequestMapping(value = "/gborders", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<OrderShowVo> getOrderByBuyer(@RequestBody Map<String,Object> param){
        String bphone=(String)param.get("bphone");
        return orderService.getOrderByBuyer(bphone);
    }




}
