package com.orders.service.task;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.orders.dao.Order;
import com.orders.dao.Tasks;
import com.orders.dao.shangjia.ShangJia;
import com.orders.dao.shops.Shop;
import com.orders.mapper.OrderMapper;
import com.orders.mapper.ShopMapper;
import com.orders.mapper.TaskMapper;
import com.orders.service.OrderService;
import com.orders.service.ServiceCoseService;
import com.orders.service.ShangJiaService;
import com.orders.service.TaskService;
import com.orders.service.shangjia.ShangJiaServiceImp;
import com.orders.utils.code.qrcode.QRCodeUtils;
import com.orders.utils.image.ImageUtils;
import com.orders.utils.statecode.TaskType;
import com.orders.utils.tools.ToolsUtils;
import com.orders.vo.BaseServiceCost;
import com.orders.vo.ServiceCostVo;
import com.orders.vo.order.OrderStateCountVo;
import com.orders.vo.task.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service(value="taskService")
public class TaskServiceImpl implements TaskService {
    private static Logger log= LoggerFactory.getLogger(TaskServiceImpl.class);

    @Autowired
    private ServiceCoseService costService;
    @Autowired
    private ShangJiaService sjService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private TaskMapper taskMapper;
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private ShopMapper shopMapper;
    @Override
    public void createNewTask(TaskVo vo) {
        try {
            if (null != vo) {
                FindGoodsVo fgVo=vo.getFindGoods();
                if (fgVo.getAdAn().equalsIgnoreCase(fgVo.getReDaAn())) {
                    Tasks tasks = new Tasks();
                    double total = taskTotalCost(vo, tasks);
                    tasks.setServiceCost(total);
                    fuZhiTasks(tasks, vo);
                    total = tasks.getTotalCost() + tasks.getServiceCost();
                    kouFei(total, vo.getPhone());
                    taskMapper.addTask(tasks);
                }
            }
        }catch(Exception e){
            log.error(e.getMessage());
        }

    }

    private void kouFei(double total,String phone){
            sjService.kouFeiSj(total,phone);
    }

    private void fuZhiTasks(Tasks tasks,TaskVo vo){
       tasks.setGoodsInfo(toJsonStrValue(vo.getGoodsInfo()));
       tasks.setSouSuo(toJsonStrValue(vo.getSouSuo()));
       tasks.setFindGoods(toJsonStrValue(vo.getFindGoods()));
       tasks.setPingJia(toJsonStrValue(vo.getPingJia()));
       tasks.setZengZhi(toJsonStrValue(vo.getZengZhi()));
       tasks.setPushTime(toJsonStrValue(vo.getPushTime()));
       tasks.setLiuYan(vo.getLiuYan());
       tasks.setPhone(vo.getPhone());
       tasks.setFanKuan(vo.getFanKuan());
        tasks.setState(TaskType.TASK_NOSTART);
        tasks.setGetState(TaskType.TASK_NOGET);
        tasks.setTaskType(vo.getTaskType());
        tasks.setcTime(new Date());
        tasks.setOrderCount(0);
        tasks.setShenHe(vo.getShenHe());
        tasks.settTime(ToolsUtils.toDate(vo.getPushTime().getDate()));
    }

    private String toJsonStrValue(Object obj){
        try {
            ObjectMapper objMapper = new ObjectMapper();
            return objMapper.writeValueAsString(obj);
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return "";
    }

//    private Object toObjectValue(String json){
//        try {
//            ObjectMapper objMapper = new ObjectMapper();
//
////        List<Bean> beanList = mapper.readValue(jsonString, new TypeReference<List<Bean>>() {});
//            objMapper.readvalue(json,new TypeReference<>)
//        }catch (Exception e){
//            log.error(e.getMessage());
//        }
//
//    }


    @Override
    public void createNewTask(String tid) {
        try {
            Tasks task = taskMapper.getTask(tid);
            taskMapper.addTask(task);
        }catch(Exception e){
            log.error(e.getMessage());
        }

    }

    @Override
    public void cancelTask(String tid) {
        try {
            Tasks task = taskMapper.getTask(tid);
            if(null!=task){
              //  if(task.getState()==TaskType.TASK_NOSTART){
                    task.setState(TaskType.TASK_CANCEL);
                    taskMapper.updateTaskState(tid,task.getState());
               // }
            }
        }catch(Exception e){
            log.error(e.getMessage());
        }
    }

    @Override
    public TaskShowVo getTaskByState(String phone, int state) {
        try {
            Tasks tasks=taskMapper.getTaskByState(phone, state);
            return toTaskShowVo(tasks);
        }catch(Exception e){
            log.error(e.getMessage());
        }
        return new TaskShowVo();
    }

    private TaskShowVo toTaskShowVo(Tasks task){
        if(null!=task){
            TaskShowVo vo=new TaskShowVo();
           // ObjectMapper objMapper=new ObjectMapper();
            try {
               GoodsInfoVo goodsInfo=this.getOrderGoodsInfo(task).get(0);
                vo.setGoodsName(goodsInfo.getGoodsName());
                vo.setShopName(goodsInfo.getShop());
                vo.setImage(goodsInfo.getImage());
                vo.setId(task.getId());
                vo.setcTime(ToolsUtils.showDate(task.getcTime()));
                vo.setTypeName("");
//                List<SouSuoVo> souSuos=objMapper.readValue(task.getSouSuo(), new TypeReference<List<SouSuoVo>>() {
//                });
                List<SouSuoVo> souSuos=this.getSouSuo(task.getSouSuo());
                vo.setTaskCount(taskCount(souSuos));
                vo.setDaiLingQu(vo.getTaskCount()-task.getOrderCount());
              //  TaskStateCountsVo stateCount=orderMapper.getOrderStateCount(task.getId());
                OrderStateCountVo stateCount=orderService.getOrderStateTongJi(task.getId());
                vo.setDaiFanKuan(stateCount.getDaiFanKuan());
                vo.setDaiFanYongJin(stateCount.getDaiYongJin());
                vo.setGouMai(stateCount.getRuning());
                vo.setShouHuo(stateCount.getShouHuo());
                vo.setWanCheng(stateCount.getWanCheng());
                return vo;

            }catch (Exception e){
                log.error(e.getMessage());
            }


        }
        return new TaskShowVo();
    }

    private int taskCount(List<SouSuoVo> souSuos){
        if(null!=souSuos){
            int count=0;
            for(SouSuoVo vo:souSuos){
                count+=vo.getOrderCount();
            }
            return count;
        }
        return 0;
    }

    @Override
    public TaskShowVo getTaskByType(String phone, int type) {
        try {
            Tasks tasks=taskMapper.getTaskByType(phone,type);
            return toTaskShowVo(tasks);
        }catch(Exception e){
            log.error(e.getMessage());
        }
        return new TaskShowVo();
    }

    @Override
    public TaskShowVo getTaskByGetState(String phone, int getState) {
        try {
            Tasks tasks=taskMapper.getTaskByGetState(phone,getState);
            return toTaskShowVo(tasks);
        }catch(Exception e){
            log.error(e.getMessage());
        }
        return new TaskShowVo();
    }

    @Override
    public TaskShowVo getTaskByShopName(String phone, String shopName) {
        try {
            Tasks tasks=taskMapper.getTaskByShopName(phone,shopName);
            return toTaskShowVo(tasks);
        }catch(Exception e){
            log.error(e.getMessage());
        }
        return new TaskShowVo();
    }

    @Override
    public TaskShowVo getTaskByGoodsName(String phone, String goodsName) {
        try {
            Tasks tasks=taskMapper.getTaskByGoodsName(phone,goodsName);
            return toTaskShowVo(tasks);
        }catch(Exception e){
            log.error(e.getMessage());
        }
        return new TaskShowVo();
    }

    @Override
    public TaskShowVo getTaskByTid( String tid) {
        try {
            Tasks tasks=taskMapper.getTaskByTid(tid);
            return toTaskShowVo(tasks);
        }catch(Exception e){
            log.error(e.getMessage());
        }
        return new TaskShowVo();
    }

    @Override
    public TaskShowVo getTaskByCTime(String phone, String startTime, String endTime) {
        try {
            Tasks tasks=taskMapper.getTaskByCTime(phone,startTime,endTime);
            return toTaskShowVo(tasks);
        }catch(Exception e){
            log.error(e.getMessage());
        }
        return new TaskShowVo();
    }

    @Override
    public TaskShowVo getTaskByTTime(String phone, String startTime, String endTime) {
        try {
            Tasks tasks=taskMapper.getTaskByTTime(phone,startTime,endTime);
            return toTaskShowVo(tasks);
        }catch(Exception e){
            log.error(e.getMessage());
        }
        return new TaskShowVo();
    }

    @Override
    public TaskInfo getTaskInfo(String tid) {
        try {
            Tasks task = taskMapper.getTask(tid);
            return toTaskInfo(task);
        }catch(Exception e){
            log.error(e.getMessage());
        }
        return new TaskInfo();
    }

    @Override
    public Tasks getTasks(String tid) {
        try{
            return taskMapper.getTask(tid);
        }catch(Exception e){
            log.error(e.getMessage());
        }
        return null;
    }

    @Override
    public  List<GoodsInfoVo> getOrderGoodsInfo(Tasks task) {
        try {
            ObjectMapper objMapper=new ObjectMapper();
            List<GoodsInfoVo> goodsInfos = objMapper.readValue(task.getGoodsInfo(), new TypeReference<List<GoodsInfoVo>>() {
            });
            return goodsInfos;
        }catch (Exception e){
            log.error(e.getMessage());
        }
       return null;
    }



    @Override
    public FindGoodsVo getOrderFindGoods(Tasks task) {
        try {
            ObjectMapper objMapper = new ObjectMapper();
            return objMapper.readValue(task.getFindGoods(),FindGoodsVo.class);
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return null;
    }


    public void setOrderGoodInfo(Order order, Tasks task){
        List<GoodsInfoVo> goodsInfoVos=getOrderGoodsInfo(task);
        GoodsInfoVo gifv=goodsInfoVos.get(0);
        order.setImage(gifv.getImage());
        int pay=0;
        for(GoodsInfoVo tempgi:goodsInfoVos){
            pay+=tempgi.getSku();
        }
        order.setYaJin(pay);
    }

    public void getOrderServiceCost(Order order,Tasks task){
        List<SouSuoVo> souSuo=getOrderSouSuo(task);
        if(null!=souSuo && souSuo.size()>0){
            int count=0;
            for(SouSuoVo ssVo:souSuo){
                count+=ssVo.getOrderCount();
            }
            order.setYongJin(task.getServiceCost()/count);
        }
    }

    @Override
    public TaskOrderInfoVo getTaskOrder(String tid,long quoQi) {
        try {
            Tasks task = taskMapper.getTask(tid);
            TaskOrderInfoVo toInfo=new TaskOrderInfoVo();
            if(null!=task){
                if(ToolsUtils.isLinkQuoQi(quoQi)){
                    toInfo.setTiem("已超时");
                }

              //  TaskOrderInfoVo toInfo=new TaskOrderInfoVo();
                TimeTaskVo timeTask=this.getPushTimeTask(task);
                if(null!=timeTask){
//                    if(ToolsUtils.checkOrderTimeOut(timeTask.getDate(),timeTask.getToHour())){
//                        toInfo.setTiem("已超时");
//                    }
                    if(timeTask.getFangShi()==TaskType.FANGSHI_1){
                        toInfo.setTiem(timeTask.getMeiGe().get(0).getTime()+"分钟内完成");
                    }else{
                        toInfo.setTiem(1+"小时内完成");
                    }
                }
                List<SouSuoVo> souSuo=this.getSouSuo(task.getSouSuo());
                if(null!=souSuo && souSuo.size()>0){
                    List<Integer> attach=null;
                    StringBuilder sb=new StringBuilder();
                    for(SouSuoVo vo:souSuo){
                        attach=vo.getAttach();
                        if(null!=attach && attach.size()>0){
                            for(int temp:attach){
                                switch(temp){
                                    case TaskType.ATTACH_1:
                                        sb.append("收藏店铺,");
                                        break;
                                        case TaskType.ATTACH_2:
                                            sb.append("收藏商品");
                                            break;
                                    case TaskType.ATTACH_3:
                                        sb.append("加入购物车");
                                        break;
                                    case TaskType.ATTACH_4:
                                        sb.append("假聊");
                                        break;
                                }
                            }
                        }
                        toInfo.setYaoqiu(sb.toString());
                        if(vo.getWay()==TaskType.WAY_KEY) {
                            toInfo.setKey(vo.getWords());
                        }
                    }

                }

               List<GoodsInfoVo> goodsInfo=this.getGoodsInfo(task.getGoodsInfo());
                if(null!=goodsInfo && goodsInfo.size()>0){
                    toInfo.setCost(goodsInfo.get(0).getSku()+"");
                    toInfo.setShopName(goodsInfo.get(0).getShop());
                    toInfo.setImg(goodsInfo.get(0).getImage());
                }

            }
            return toInfo;
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return null;
    }

    public TimeTaskVo getPushTimeTask(Tasks task){
        try{
            ObjectMapper objMapper = new ObjectMapper();
            TimeTaskVo timeTask= objMapper.readValue(task.getPushTime(),TimeTaskVo.class);
            return timeTask;
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return null;
    }

    @Override
    public String getTaskLink(String tid) {

                long quoQi=getQuoQiTime(tid);
                return getTaskParam(tid,quoQi);


    }

    private long getQuoQiTime(String tid){
        long quoQi = 0;
        try {
            Tasks task = taskMapper.getTask(tid);
            if (null != task) {

                TimeTaskVo ttVo = getPushTimeTask(task);
                if (null != ttVo) {
                    if (ttVo.getFangShi() == TaskType.FANGSHI_1) {
                        List<MeiGeVo> mgVo = ttVo.getMeiGe();
                        if (null != mgVo && mgVo.size() > 0) {
                            MeiGeVo vo = mgVo.get(0);
                            quoQi = ToolsUtils.getLinkQuoQiTime(ttVo.getDate(), ttVo.getFromHour(), ttVo.getToHour(), vo.getTime());
                        }
                    } else {
                        quoQi = ToolsUtils.getLinkQuoQiTime(ttVo.getDate(), ttVo.getFromHour(), ttVo.getToHour(), 60);
                    }
                }
            }
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return quoQi;
    }

    private String getTaskParam(String tid,long quoQi){
        StringBuilder sb=new StringBuilder();
        sb.append("tid="+tid);
        sb.append("&& quoQi="+quoQi);
        return sb.toString();
    }

    @Override
    public String getTaskQRCode(String tid) {
        long quoQi=getQuoQiTime(tid);
        String param= getTaskParam(tid,quoQi);
        byte[] qrCode= QRCodeUtils.createQrCode(200,200,param);
        return ImageUtils.toBase64Str(qrCode);
    }


    @Override
    public List<SouSuoVo> getOrderSouSuo(Tasks task) {
       try{
           ObjectMapper objMapper = new ObjectMapper();
           List<SouSuoVo> souSuo= objMapper.readValue(task.getSouSuo(),new TypeReference<List<SouSuoVo>>() {});
           return souSuo;
       }catch (Exception e){
           log.error(e.getMessage());
       }
       return null;
    }

    @Override
    public PingJiaVo getOrderPingJia(Tasks task) {
        try {
            ObjectMapper objMapper = new ObjectMapper();
            PingJiaVo pingJia= objMapper.readValue(task.getPingJia(),PingJiaVo.class);
            return pingJia;
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return null;
    }

    private TaskInfo toTaskInfo(Tasks task){
        if(null!=task){
            try {
                TaskInfo info = new TaskInfo();
                info.setId(task.getId());
                info.setTaskType(task.getTaskType() == TaskType.BUY_TASK ? "购买任务" : "");
                info.setPhone(task.getPhone());
                info.setShopHome("");
                Shop shop = shopMapper.getShopByName(task.getShopName());
                info.setPlatform(shop.getPlatform());
                info.setShopName(task.getShopName());
                info.setShopww(shop.getWangWang());
                List<GoodsInfoVo> goodsInfo=getGoodsInfo(task.getGoodsInfo());
                info.setGoodsInfos(goodsInfo.get(0));
                info.setFindGoods(getFindGoods(task.getFindGoods()));
                info.setSouSuos(getSouSuo(task.getSouSuo()));
//                info.setBaoYou(task.getBaoYou()==1?"是":"否");
//                info.setPlan(task.getPlan()==1?"加入":"未加入");
//                info.setYouHui(task.getYouHui()==1?"是":"否");
//                info.setYhMoney("0");
//                info.setYhAddress("无");
//                info.setAnswer(task.getVerifyAnswer());
                info.setSku(goodsInfo.get(0).getSku()+"");
                info.setPai(goodsInfo.get(0).getEveryBuy()+"");
                info.setCost(""+goodsInfo.get(0).getEveryCost());
                info.setPingJia(getPingJia(task.getPingJia()));
//                info.setPuTongHaoPing(task.getPuTongHaoPing());
//                info.setWordHaoPing(task.getWordHaoPing());
//                info.setImageHaoPing(task.getImageHaoPing());
//                info.setVodeHaoPing(task.getVodeHaoPing());
                info.setZengZhi(getZengZhi(task.getZengZhi()));
                info.setLiuYan(task.getLiuYan());
                info.setTaskSet(task.getTaskSet());
                info.setFanKuan(task.getFanKuan()==1?"平台返款":"");
                info.setTotalCost(String.valueOf(task.getTotalCost()));
                info.setServiceCost(String.valueOf(task.getServiceCost()));
                info.setRefundCost((String.valueOf((task.getTotalCost()-task.getServiceCost()))));
                info.setcTime(ToolsUtils.showDate(task.getcTime()));
                info.settTime(ToolsUtils.showDate(task.getsTime()));
                info.setShenHer(task.getShenHer());
                return info;
            }catch (Exception e){
                log.error(e.getMessage());
            }

        }
        return new TaskInfo();
    }

    private PingJiaVo getPingJia(String pingJia){
        try {
            if (null != pingJia) {
                ObjectMapper objMapper = new ObjectMapper();
                return objMapper.readValue(pingJia, PingJiaVo.class);
            }
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return null;
    }

    private FindGoodsVo getFindGoods(String findGoods){
        try {
            if (null != findGoods) {
                ObjectMapper objMapper = new ObjectMapper();
                return objMapper.readValue(findGoods,FindGoodsVo.class);
            }
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return null;
    }

    private  ZengZhiServiceVo getZengZhi(String zengZhi){
        try {
            if (null != zengZhi) {
                ObjectMapper objMapper = new ObjectMapper();
                return objMapper.readValue(zengZhi,ZengZhiServiceVo.class);
            }
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return null;
    }

    private List<SouSuoVo> getSouSuo(String souSuo){
        try {
            if (null != souSuo) {
                ObjectMapper objMapper = new ObjectMapper();
                return objMapper.readValue(souSuo, new TypeReference<List<SouSuoVo>>() {
                });
            }
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return new ArrayList<>();
    }

    private List<GoodsInfoVo> getGoodsInfo(String goodsInfo){
        try {
            if (null != goodsInfo) {
                ObjectMapper objMapper = new ObjectMapper();
               return objMapper.readValue(goodsInfo, new TypeReference<List<GoodsInfoVo>>() {
                });
            }
        }catch (Exception e){
            log.error(e.getMessage());
        }
       return new ArrayList<>();
    }



    private double taskTotalCost(TaskVo vo,Tasks tasks){
        double totalCost=0;
        if(null!=vo){
           ServiceCostVo costVo= costService.getServiceCost();

           if(null!=costVo){
               totalCost=baseGoodsCost(costVo.getBaseCost(),vo.getGoodsInfo(),tasks);
               Map<String,String> otherCost=costVo.getOtherCost();
               totalCost+=goodsInfofuJiaCost(otherCost,vo.getGoodsInfo());
               totalCost+=souSuoCost(costVo.getOtherCost(),vo.getSouSuo());
               if(vo.getFindGoods().getBaoYou()==TaskType.BAOYOU_0){
                   totalCost+=Integer.valueOf(otherCost.get("baoYou"));
               }
               PingJiaVo pjVo=vo.getPingJia();

               totalCost+=wordHaoPingCost(otherCost,pjVo.getWord());
               totalCost+=imgHaoPingCost(otherCost,pjVo.getImgs());
               totalCost+=vodeHaoPingCost(otherCost,pjVo.getVodes());
               totalCost+=zengZhiFuWuCost(otherCost,vo);
               totalCost+=refundCost(otherCost,vo);

           }
        }
        return totalCost;
    }

    private double refundCost(Map<String,String> otherCost,TaskVo vo){
        double total=0;
        if(null!=vo){
            total+=Double.valueOf(otherCost.get("refund"));
        }
        return total;
    }

    private double zengZhiFuWuCost(Map<String,String> otherCost,TaskVo vo){
        double total=0;
        if(null!=vo){
            ZengZhiVo zzVo=vo.getZengZhi();
            if(null!=zzVo) {
                if(zzVo.getSex()!=-1) {
                    total += Double.valueOf(otherCost.get("sex"));
                }
                AgeVo aVo = zzVo.getAge();
                if (null != aVo) {
                    total += Double.valueOf(otherCost.get("age"));
                }
                if(null!=zzVo.getJieDanType() && zzVo.getJieDanType().size()>0) {
                    total += Integer.valueOf(otherCost.get("jieDanType"));
                }
                if(zzVo.getHuaBei()==1) {
                    total += Integer.valueOf(otherCost.get("huaBei"));
                }
                if(zzVo.getWeekPoint()==1) {
                    total += Integer.valueOf(otherCost.get("weekPoint"));
                }
                if(zzVo.getDrill()==1) {
                    total += Integer.valueOf(otherCost.get("drill"));
                }
            }
        }
        return total;
    }

    private int vodeHaoPingCost(Map<String,String> otherCost, List<VodeHaoPingVo> vodeHPs){
        if(null!=vodeHPs && vodeHPs.size()>0){
            return Integer.valueOf(otherCost.get("vodeHaoPing"))*vodeHPs.size();
        }
        return 0;
    }

    private int imgHaoPingCost(Map<String,String> otherCost, List<ImgHaoPingVo> imgHPs){
        if(null!=imgHPs && imgHPs.size()>0){
            return Integer.valueOf(otherCost.get("imgHaoPing"))*imgHPs.size();
        }
        return 0;
    }

    private int wordHaoPingCost(Map<String,String> otherCost,List<String> wordHPs){
        if(null!=wordHPs && wordHPs.size()>0){
            return Integer.valueOf(otherCost.get("wordHaoPing"))*wordHPs.size();
        }
        return 0;
    }

    private double  souSuoCost(Map<String,String> otherCost,List<SouSuoVo> ssVoS){
        double total=0;
        if(null!=ssVoS && ssVoS.size()>0){
           List<Integer> attachs=null;

            for(SouSuoVo temp:ssVoS){
                attachs=temp.getAttach();
                for(int at:attachs){
                    switch (at){
                        case TaskType.ATTACH_1:
                        case TaskType.ATTACH_2:
                        case TaskType.ATTACH_3:
                             total+=temp.getOrderCount()*Double.valueOf(otherCost.get("fuJiaTask"));
                             break;
                             case TaskType.ATTACH_4:
                                 total+=temp.getOrderCount()*Integer.valueOf(otherCost.get("jiaLiao"));
                                 break;


                    }
                }
            }
        }
        return total;
    }

    /**
     * 商品附加商品计费
     * @param otherCost
     * @param goodsVos
     * @return
     */
    private int goodsInfofuJiaCost( Map<String,String> otherCost,List<GoodsInfoVo> goodsVos){
            int len=goodsVos.size()-1;
            if(len>0){
                int cost=Integer.valueOf(otherCost.get("fuJiaGoods"));
                return len*cost;
            }
            return 0;
    }

    /**
     * 基础服务费
     * @param baseCosts
     * @param goodsVos
     * @return
     */
    private double baseGoodsCost(List<BaseServiceCost> baseCosts, List<GoodsInfoVo> goodsVos,Tasks tasks){
        double serviceCost=0;
        double totalCost=0;
        if(null!=baseCosts && baseCosts.size()>0 && null!=goodsVos && goodsVos.size()>0){
            int tempInx=0;
            for(GoodsInfoVo goodsVo:goodsVos) {
                if(tempInx==0){
                    tasks.setShopName(goodsVo.getShop());
                    tasks.setGoodsName(goodsVo.getGoodsName());
                    tempInx=1;
                }
                for (BaseServiceCost tempCost : baseCosts) {
                    if (tempCost.getMin() <= goodsVo.getSku() && tempCost.getMax() >= goodsVo.getSku()) {
                        serviceCost += tempCost.getCost();
                        totalCost+=goodsVo.getSku();

                        break;
                    }
                }
            }
            tasks.setTotalCost(totalCost);
        }
        return serviceCost;
    }


}
