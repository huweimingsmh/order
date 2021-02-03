package com.orders.service.orders;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.orders.dao.Order;
import com.orders.dao.ShenSu;
import com.orders.dao.Tasks;
import com.orders.dao.maishou.Buyer;
import com.orders.dao.maishou.Tabbao;
import com.orders.mapper.OrderMapper;
import com.orders.service.BuyService;
import com.orders.service.OrderService;
import com.orders.service.ShenSuService;
import com.orders.service.TaskService;
import com.orders.service.account.AccountServiceImp;
import com.orders.utils.statecode.OrderState;
import com.orders.utils.statecode.ShenSuType;
import com.orders.utils.statecode.TaskType;
import com.orders.utils.tools.ToolsUtils;
import com.orders.vo.ShenSuRVo;
import com.orders.vo.order.*;
import com.orders.vo.shensu.OrderShenSuShowVo;
import com.orders.vo.task.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value="orderService")
public class OrderServiceImpl implements OrderService {
    private static Logger log= LoggerFactory.getLogger(OrderServiceImpl.class);
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private TaskService taskService;
    @Autowired
    private BuyService buyService;
    @Autowired
    private ShenSuService shenSuService;
    @Override
    public OrderShowVo getOrderByStid(String stid) {
        try {
            Order order=orderMapper.getOrderByStid(stid);
            if(null!=order){
                return getOrderShowObj(order);
            }

        }catch (Exception e){
            log.error(e.getMessage());
        }
        return null;
    }

    @Override
    public OrderShowVo getOrderSTID(String oid) {
        try{
            Order order=orderMapper.getOrderSTID(oid);
            if(null!=order) {
                return getOrderShowObj(order);
            }
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return null;
    }

    @Override
    public List<OrderShowVo> getOrderByDownTime(String phone, String startTime, String endTime) {
        try{
            List<Order> order=orderMapper.getOrderByDownTime(phone,startTime,endTime);
            return getOrderShowList(order);
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return new ArrayList<>();
    }

    @Override
    public List<OrderShowVo> getOrderBySubmitTime(String phone, String startTime, String endTime) {
        try{
            List<Order> order=orderMapper.getOrderBySubmitTime(phone,startTime,endTime);
            return getOrderShowList(order);
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return new ArrayList<>();
    }

    @Override
    public List<OrderShowVo> getOrderByState(String phone, int state) {
        try{
            List<Order> order=orderMapper.getOrderByState(phone,state);
            return getOrderShowList(order);
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return new ArrayList<>();
    }

    @Override
    public List<OrderShowVo> getOrderByGoodsName(String phone, String goodsName) {
        try{
            List<Order> order=orderMapper.getOrderByGoodsName(phone,goodsName);
            return getOrderShowList(order);
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return new ArrayList<>();
    }

    @Override
    public List<OrderShowVo> getOrderByShopName(String phone, String shopName) {
        try{
            List<Order> order=orderMapper.getOrderByShopName(phone,shopName);
            return getOrderShowList(order);
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return new ArrayList<>();
    }

    @Override
    public List<OrderShowVo> getOrderByVip(String phone, String vip) {
        try{
            List<Order> order=orderMapper.getOrderByVip(phone,vip);
            return getOrderShowList(order);
        }catch (Exception e){
            log.error(e.getMessage());
        }
       return new ArrayList<>();
    }

    private List<OrderShowVo> getOrderShowList(List<Order> orders){
        List<OrderShowVo> orderShowList=new ArrayList<>();
        if(null!=orders && orders.size()>0){
            for(Order temp:orders){
                orderShowList.add(getOrderShowObj(temp));
            }

        }
        return orderShowList;

    }

    public OrderShowVo getOrderShowObj(Order order){
        if(null!=order){
            OrderShowVo osVo=new OrderShowVo();
            osVo.setId(order.getId());
            osVo.setcTime(ToolsUtils.showDate(order.getcTime()));
            osVo.setGoodsName(order.getGoodsName());
            osVo.setPlatform(order.getPlatform());
            osVo.setShopName(order.getShopName());
            osVo.setTaobaoVip(order.getTaobaoVip());
            osVo.setOid(order.getoId());
            osVo.setYaJin(order.getYaJin());
            osVo.setsMoney(order.getsMoney());
            osVo.setYongJin(order.getYongJin());
            osVo.setsTime(ToolsUtils.showDate(order.getsTime()));
            osVo.setrTime(ToolsUtils.showDate(order.getrTime()));
            osVo.setImg(order.getImage());
            osVo.setState(order.getState());
            if(OrderState.RUNING==order.getState()){
                osVo.setStateStr("进行中");
            }else if(OrderState.DAIFANKUAN==order.getState()){
                osVo.setStateStr("待返款");

            }else if(OrderState.SHOUHUO==order.getState()){
                osVo.setStateStr("收货中");
            }else if(OrderState.DAIYONGJIN==order.getState()){
                osVo.setStateStr("待返佣金");
            }else if(OrderState.WANCHENG==order.getState()){
                osVo.setStateStr("已完成");
            }else if(OrderState.FANKUANNOTPASS==order.getState()){
                osVo.setStateStr("返款不通过");
            }else if(OrderState.YONGJINNOTPASS==order.getState()){
                osVo.setStateStr("佣金不通过");
            }
            return osVo;
        }
        return null;
    }

    public OrderInfo getOrderInfo(Order order){
        OrderInfo info=new OrderInfo();
        info.setStid(order.getId());
        TaskInfo taskInfo=taskService.getTaskInfo(order.gettId());
        info.setAdAn(taskInfo.getAnswer());
        setBuyerInfo(info,order.getbPhone());
        setTaskInfo(info,order.gettId());
        info.setSjMoneySet(String.valueOf(order.getYaJin()));
        info.setBpMoney(String.valueOf(order.getsMoney()));
        info.setOid(order.getoId());
        info.setSjFanKuan(String.valueOf(order.getYaJin()));
        info.setHsTime(ToolsUtils.showDate(order.getsTime()));
        info.setrTime(ToolsUtils.showDate(order.getrTime()));
        setShenSuInfo(info,order.getId());
        return info;
    }

    private void setShenSuInfo(OrderInfo info,String stid){
        ShenSu shenSu= shenSuService.getShenSuBystid(stid);
        if(null!=shenSu ){
            OrderShenSuShowVo ossSv=new OrderShenSuShowVo();
            ossSv.setChuLi(shenSu.getChuLi()+"/"+shenSu.getChuLiTime());
            ossSv.setChuLiJieGuo(shenSu.getChuLiRes());
         //   String[] imgs=shenSu.getImage().split(",");
            ObjectMapper objMapper = new ObjectMapper();
            try {
                List<String> imgs = objMapper.readValue(shenSu.getImage(), new TypeReference<List<String>>() {
                });
              ossSv.setImgs(imgs);
              ossSv.setContext(shenSu.getAsk());
              ossSv.setTitle(shenSu.getTitle());
              if(shenSu.getBuilder()== ShenSuType.BUY_BUILDER){
                  ossSv.setShenSuer("买手申诉:"+shenSu.getSsTime());
              }else{
                  ossSv.setShenSuer("商家申诉:"+shenSu.getSsTime());
              }
              info.setShenSu(ossSv);
            }catch (Exception e){
                log.error(e.getMessage());
            }

        }
    }

    private void setTaskInfo(OrderInfo info,String tid){
        Tasks task=taskService.getTasks(tid);
        if(null!=task){
//            List<GoodsInfoVo> goodsInfo=taskService.getOrderGoodsInfo(task);
//            info.setgMoney(String.valueOf(goodsInfo.getSku()));
            List<SouSuoVo> souSuos=taskService.getOrderSouSuo(task);
            OrderSouSuoVo ossv=null;
            List<OrderSouSuoVo> ossvList=new ArrayList<>();
            for(SouSuoVo ssVo:souSuos){
                ossv=new OrderSouSuoVo();
                if(ssVo.getWay()== TaskType.WAY_KEY){
                    ossv.setSouSuo("关键搜索");
                    ossv.setSouSuoContext("关键词:"+ssVo.getWords());
                }else{
                    ossv.setSouSuo("淘口令搜索");
                    ossv.setSouSuoContext("淘口令:"+ssVo.getWords());
                }
                ossvList.add(ossv);
            }
            info.setSouSuos(ossvList);

            //info.setSouSuo(souSuo.getWords());
            PingJiaVo pingJia=taskService.getOrderPingJia(task);
            List<String> pjList=new ArrayList<>();
            if(null!=pingJia.getPuTong()){
                pjList.add("普通好评");
            }else if(null!=pingJia.getWord() && pingJia.getWord().size()>0){
                pjList.add("文字好评");
            }else if(null!=pingJia.getImgs() && pingJia.getImgs().size()>0){
                pjList.add("图文好评");
            }else if(null!=pingJia.getVodes() && pingJia.getVodes().size()>0){
                pjList.add("视频好评");
            }
            info.setPingJias(pjList);

        }
    }

    private void setBuyerInfo(OrderInfo info,String phone){
        Buyer buyer=buyService.getBuyer(phone);
        info.setBid(String.valueOf(buyer.getId()));
       // info.setQq(buyer.);
    }

    @Override
    public void createOrder(JieDanVo vo) {
        try {
            if (null != vo) {
                Tasks task = taskService.getTasks(vo.getTid());
                if(null!=task){
                    List<SouSuoVo> souSuos=taskService.getOrderSouSuo(task);
                    int taskCount=0;
                    if(null!=souSuos && souSuos.size()>0){
                        for(SouSuoVo ss:souSuos){
                            taskCount+=ss.getOrderCount();
                        }
                    }
                    if(taskCount==task.getOrderCount()){
                        //任务已被 接完
                    }
//                    TimeTaskVo tt=taskService.getPushTimeTask(task);
//                    if(!ToolsUtils.checkOrderTimeOut(tt.getDate(),tt.getToHour())){
//                        //任务已过期
//                    }
                    Buyer buyer=buyService.getBuyer(vo.getBphone());
                    if(null!=buyer){
                        List<Tabbao> tbs=buyer.getTabbaoList();
                        if(null!=tbs && tbs.size()>0){
                            for(Tabbao tb:tbs){
                                if(tb.getVip().equals(vo.getTaobaoVip())){
                                    if(ToolsUtils.isVIPQuoQi(tb.getDate())){
                                        break;
                                    }else{
                                        //该账号在一个月内已接过该店铺的任务
                                    }
                                }
                            }
                        }
                    }
                    
                    Order order=new Order();
                    order.setbPhone(vo.getBphone());
                    order.setTaobaoVip(vo.getTaobaoVip());
                    order.settId(vo.getTid());
                    order.setPlatform(task.getPlatform());
                   taskService.setOrderGoodInfo(order,task);
                   order.setState(OrderState.RUNING);
                   order.setGoodsName(task.getGoodsName());
                   order.setShopName(task.getShopName());
                   order.settType(task.getTaskType());
                   order.setsMoney(0);
                   order.setSjPhone(task.getPhone());
                   order.setcTime(ToolsUtils.newToDay());
                   order.setoId(String.valueOf(ToolsUtils.getCurrentTime()));
                   String tempId=task.getId()+ToolsUtils.showDate();
                   order.setId(tempId);
                   taskService.getOrderServiceCost(order,task);
                   orderMapper.createOrder(order);
                }
            }
        }catch(Exception e){
            log.error(e.getMessage());
        }
    }


    @Override
    public OrderStateCountVo getOrderRefundCount(String phone) {
        try {
            List<Order> orderList = orderMapper.getOrderRefundCount(phone);
            OrderStateCountVo stateCount = new OrderStateCountVo();
            if (null != orderList && orderList.size() > 0) {
                //  OrderStateCountVo stateCount=new OrderStateCountVo();
                for (Order tempOrder : orderList) {
                    switch (tempOrder.getState()) {
//                        case OrderState.RUNING:
//                            stateCount.addRuning(1);
//                            break;
                        case OrderState.DAIFANKUAN:
                            stateCount.addDaiFanKuan(1);
                            break;
//                        case OrderState.SHOUHUO:
//                            stateCount.addShouHuo(1);
//                            break;
                        case OrderState.DAIYONGJIN:
                            stateCount.addDaiYongJin(1);
                            break;
//                        case OrderState.WANCHENG:
//                            stateCount.addWanCheng(1);
//                            break;

                    }
                }

            }
            return stateCount;
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return null;
    }



    @Override
    public OrderInfo showOrderInfo(String stid) {
        try{
            Order order=orderMapper.getOrderByStid(stid);
            if(null!=order){
                return getOrderInfo(order);
            }
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return null;
    }

    @Override
    public void faFangKuan(String stid) {
        try {
            Order order = orderMapper.getOrderByStid(stid);
            if(null!=order){
                if(order.getState()==OrderState.DAIFANKUAN){
                    orderMapper.updateState(stid,OrderState.DAIYONGJIN);
                }else if(order.getState()==OrderState.DAIYONGJIN){
                    orderMapper.updateState(stid,OrderState.WANCHENG);
                }else if(order.getState()==OrderState.RUNING){
                    orderMapper.updateState(stid,OrderState.SHOUHUO);
                }else if(order.getState()==OrderState.SHOUHUO){
                    orderMapper.updateState(stid,OrderState.DAIFANKUAN);
                }
            }
        }catch(Exception e){
            log.error(e.getMessage());
        }
    }

    @Override
    public void notFaFangKuan(String stid) {
        try {
            Order order = orderMapper.getOrderByStid(stid);
            if(null!=order){
                if(order.getState()==OrderState.DAIFANKUAN){
                    orderMapper.updateState(stid,OrderState.FANKUANNOTPASS);
                }else if(order.getState()==OrderState.DAIYONGJIN){
                    orderMapper.updateState(stid,OrderState.YONGJINNOTPASS);
                }
            }
        }catch(Exception e){
            log.error(e.getMessage());
        }
    }

    @Override
    public OrderStateCountVo getOrderStateTongJi(String tid) {
        List<Order> orderList=orderMapper.getOrderByTid(tid);
        OrderStateCountVo stateCount=new OrderStateCountVo();
        if(null!=orderList && orderList.size()>0){
          //  OrderStateCountVo stateCount=new OrderStateCountVo();
            for(Order tempOrder:orderList){
               switch (tempOrder.getState()){
                   case OrderState.RUNING:
                       stateCount.addRuning(1);
                       break;
                   case OrderState.DAIFANKUAN:
                       stateCount.addDaiFanKuan(1);
                       break;
                   case OrderState.SHOUHUO:
                       stateCount.addShouHuo(1);
                       break;
                   case OrderState.DAIYONGJIN:
                       stateCount.addDaiYongJin(1);
                       break;
                   case OrderState.WANCHENG:
                       stateCount.addWanCheng(1);
                       break;

               }
            }

        }
        return stateCount;

    }

    @Override
    public List<OrderShowVo> getOrderByBuyer(String phone) {
        try{
            List<Order> orderList=orderMapper.getOrderByBuyer(phone);
            List<OrderShowVo> orderShows=new ArrayList<>();
            if(null!=orderList && orderList.size()>0){
                OrderShowVo os=null;
                for(Order temp:orderList) {
                    os=this.getOrderShowObj(temp);
                    orderShows.add(os);
                }
            }
            return orderShows;
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return new ArrayList<>();
    }

    @Override
    public void downOrder(JieDanVo jieDan) {

    }
}
