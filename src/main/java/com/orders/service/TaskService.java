package com.orders.service;

import com.orders.dao.Order;
import com.orders.dao.Tasks;
import com.orders.vo.ServiceCostVo;
import com.orders.vo.order.OrderInfo;
import com.orders.vo.task.*;

import java.util.List;

public interface TaskService {


   public void createNewTask(TaskVo vo);

   public void createNewTask(String tid);

   public void cancelTask(String tid);

   public void setOrderGoodInfo(Order order, Tasks task);

   public TaskShowVo getTaskByState(String phone, int state);

   public TaskShowVo getTaskByType(String phone,int type);
   public TaskShowVo getTaskByGetState(String phone,int getState);
   public TaskShowVo getTaskByShopName(String phone,String shopName);
   public TaskShowVo getTaskByGoodsName(String phone,String goodsName);
   public TaskShowVo getTaskByTid(String tid);

   public TaskShowVo getTaskByCTime(String phone,String startTime,String endTime);
   public TaskShowVo getTaskByTTime(String phone,String startTime,String endTime);

   public TaskInfo getTaskInfo(String tid);
   public Tasks getTasks(String tid);
   public List<GoodsInfoVo> getOrderGoodsInfo(Tasks task);
   public FindGoodsVo getOrderFindGoods(Tasks task);
   public List<SouSuoVo> getOrderSouSuo(Tasks task);
   public PingJiaVo getOrderPingJia(Tasks task);
   public void getOrderServiceCost(Order order,Tasks task);

   public TaskOrderInfoVo getTaskOrder(String tid,long quoQi);

   public TimeTaskVo getPushTimeTask(Tasks task);

   public String getTaskLink(String tid);

   public String getTaskQRCode(String tid);



}
