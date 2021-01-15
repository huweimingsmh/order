package com.orders.service.message;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.orders.dao.Message;
import com.orders.dao.Order;
import com.orders.dao.Task;
import com.orders.mapper.MessageMapper;
import com.orders.mapper.OrderMapper;
import com.orders.mapper.TaskMapper;
import com.orders.mapper.WorkOrderMapper;
import com.orders.service.MessageService;
import com.orders.service.OrderService;
import com.orders.service.shensu.ShenSuServiceImpl;
import com.orders.utils.statecode.MessageType;
import com.orders.utils.tools.LogicUtils;
import com.orders.utils.tools.ToolsUtils;
import com.orders.vo.MessageContext;
import com.orders.vo.STMessageVo;
import com.orders.vo.ShowTaskMessageVo;
import com.orders.vo.SysMessageVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Service(value="messageService")
public class MessageServiceImp implements MessageService {
    private static Logger log= LoggerFactory.getLogger(MessageServiceImp.class);

    @Autowired
    private MessageMapper messageMapper;
    @Autowired
    private OrderMapper orderMapper;
//    @Autowired
//    private TaskMapper taskMapper;
    @Override
    public List<ShowTaskMessageVo> getSystemMessageBySJ(String phone) {
        try {
            List<Message> msgList = messageMapper.getSystemMessageBySJ(phone);
            return taskMessagePro(msgList);
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return new ArrayList<>();
    }

    @Override
    public List<ShowTaskMessageVo> getSystemMessageByBuyer(String phone) {
        try {
            List<Message> msgList = messageMapper.getSystemMessageByBuyer(phone);
            return taskMessagePro(msgList);
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return new ArrayList<>();
    }

    @Override
    public List<ShowTaskMessageVo> getTaskMessageBySJ(String phone) {
        try {
            List<Message> msgList = messageMapper.getTaskMessageBySJ(phone);
            return taskMessagePro(msgList);
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return new ArrayList<>();
    }

    @Override
    public List<ShowTaskMessageVo> getTaskMessageByBuyer(String phone) {
        try {
            List<Message> msgList = messageMapper.getTaskMessageByBuyer(phone);
            return taskMessagePro(msgList);
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return new ArrayList<>();
    }

    @Override
    public List<ShowTaskMessageVo> getTaskMessageBySubTask(String stId) {
        try {
            List<Message> msgList = messageMapper.getTaskMessageBySubTask(stId);
            return taskMessagePro(msgList);
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return new ArrayList<>();
    }

    @Override
    public List<ShowTaskMessageVo> getTaskMessageByWW(String ww) {
        try {
            List<Message> msgList = messageMapper.getTaskMessageByWW(ww);
            return taskMessagePro(msgList);
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return new ArrayList<>();
    }

    @Override
    public List<ShowTaskMessageVo> getTaskMessageByOid(String vip) {
        try {
            List<Message> msgList = messageMapper.getTaskMessageByOid(vip);
            return taskMessagePro(msgList);
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return new ArrayList<>();
    }

    @Override
    public String getOrderSTID(String oid) {
        try {
            return orderMapper.getOrderSTID(oid);
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return "";
    }

    public List<MessageContext> getTaskMessageContext(String stid){
        try {
            String context = messageMapper.getTaskMessageContext(stid);
            String[] contexts = context.split(",");
            List<MessageContext> mcl = new ArrayList<>();
            MessageContext mc = null;
            ObjectMapper objMapper = null;
            try {
                for (String temp : contexts) {
                    mc = objMapper.readValue(temp, MessageContext.class);
                    mcl.add(mc);
                }
                return mcl;
            } catch (Exception e) {

            }
            return new ArrayList<>();
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return new ArrayList<>();
    }



    private  List<ShowTaskMessageVo> taskMessagePro(List<Message> msg){
        try {
            if (null != msg) {
                ObjectMapper objMapper = new ObjectMapper();
                ShowTaskMessageVo vo = null;
                Order order = null;
                Task task = null;
                List<ShowTaskMessageVo> msgList = new ArrayList<>();
                for (Message temp : msg) {
                    //  vo.setImage();
                    order = orderMapper.getOrderByStid(temp.getStId());
                    if (null != order) {
                        vo = new ShowTaskMessageVo();
                        vo.setImage(order.getImage());
                        vo.setShopName(order.getShopName());
                        vo.setTaskType(LogicUtils.getTaskType(order.gettType()));
                        vo.setVip(order.getTaobaoVip());
                        vo.setStId(order.getoId());
                        vo.setLookSTInfoUrl("/");
                        msgList.add(vo);
                    }

                }
                return msgList;
            }
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return new ArrayList<>();
    }
    @Override
    public void createMessage(STMessageVo vo) {
        try {
            if (null != vo) {
                if (null != vo.getStid()) {
                    //处理任务消息
                    List<Message> inMessage = messageMapper.getTaskMessageBySubTask(vo.getStid());
                    if (null == inMessage || inMessage.size() == 0) {
                        Message message = new Message();
                     //   message.setCategory(MessageType.TASK_MESSAGE);
                        ObjectMapper mapper = new ObjectMapper();
                        MessageContext mc = new MessageContext();
                        mc.setTake("我说:");
                        mc.setContext(vo.getContext());
                        mc.setDate(ToolsUtils.showDate());
                        String text=mapper.writeValueAsString(mc);
                        message.setContext(text+",");
                        message.setcTime(ToolsUtils.showDate());
                        Order order=orderMapper.getOrderByStid(vo.getStid());
                        if(null!=order) {
                            if(vo.getSendEr()==MessageType.BUY_SEND_MESSAGE) {
                                message.setReceiverPhone(order.getSjPhone());
                                message.setSenderPhone(order.getbPhone());
                            }else{
                                message.setReceiverPhone(order.getbPhone());
                                message.setSenderPhone(order.getSjPhone());
                            }
                            message.setcTime(ToolsUtils.showDate());
                            message.setStId(vo.getStid());
                            message.setTaobaoVip(order.getTaobaoVip());
                           // message.setWangWang();
                            messageMapper.createMessage(message);
                        }

                    }else {
                        Message message=inMessage.get(0);
                        if(null!=message){
                            ObjectMapper mapper = new ObjectMapper();
                            MessageContext mc = new MessageContext();
                            if(message.getBuilder()==vo.getSendEr()) {
                                mc.setTake("我说:");

                            }else{
                                if(vo.getSendEr()==MessageType.BUY_SEND_MESSAGE){
                                    mc.setTake("买手说:");
                                }else {
                                    mc.setTake("商家说:");
                                }
                            }
                            mc.setContext(vo.getContext());
                            mc.setDate(ToolsUtils.showDate());
                            String text = mapper.writeValueAsString(mc);
                            message.setContext(text+",");
                            messageMapper.updateMessage(message);
                        }
                    }
                }
            }
        }catch (Exception e){
            log.error(e.getMessage());
        }
    }

    @Override
    public void createSystemMessage(SysMessageVo vo) {
        if(null!=vo){

        }
    }

    @Override
    public int getMessageCount(String phone) {
        return 0;
    }

//    @Override
//    public String lookSubTaskInfo() {
//        return null;
//    }
}
