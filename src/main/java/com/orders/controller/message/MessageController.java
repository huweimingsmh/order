package com.orders.controller.message;

import com.orders.service.MessageService;
import com.orders.vo.MessageContext;
import com.orders.vo.STMessageVo;
import com.orders.vo.ShowTaskMessageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class MessageController {
    @Autowired
    private MessageService messageService;

    /**
     * 商家获得管理员消息
     * @return
     */
    @RequestMapping(value="/sjgsm",  produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<ShowTaskMessageVo> getSysMsgBysj(@RequestBody Map<String,Object> param){
       // int len= phone.length();
        String phone=(String)param.get("phone");
        if(null!=phone ){
           return  messageService.getSystemMessageBySJ(phone);

        }
        return new ArrayList<>();
    }

    /**
     * 商家获得任务消息
     * @return
     */
    @RequestMapping(value="/sjgtm",  produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<ShowTaskMessageVo> getSJTaskMsg(@RequestBody Map<String,Object> param){
        String phone=(String)param.get("phone");
        if(null!=phone){
            return  messageService.getSystemMessageBySJ(phone);

        }
        return new ArrayList<>();
    }

    /**
     * 商家获得任务消息
     * @return
     */
    @RequestMapping(value="/sjgtmbystid",  produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<ShowTaskMessageVo> getSJTaskMsgBySTId(@RequestBody Map<String,Object> param){
        String stId=(String)param.get("stId");
        if(null!=stId){
            return messageService.getTaskMessageBySubTask(stId);
        }
        return new ArrayList<>();
    }



    /**
     * 按买手旺旺获得子任务编号联系买手
     * @return
     */
//    @RequestMapping(value="/bl",  produces = "application/json;charset=UTF-8")
//    @ResponseBody
//    public String getSubTaskIdByWW(){
//
//    }

    /**
     * 按订单号获得子任务编号联系买手
     * @return
     */
    @RequestMapping(value="/sjgstidbyoid",  produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String getSubTaskIdByOid(@RequestBody Map<String,Object> param){
        String oid=(String)param.get("oid");
            if(null!=oid){
                return messageService.getOrderSTID(oid);
            }
            return "";
    }

    /**
     * 联系买手
     * @return
     */
    @RequestMapping(value="/sjcallbuyer",  produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<MessageContext> callBuyer(@RequestBody Map<String,Object> param){
        String stid=(String)param.get("stid");
        if(null!=stid){
           return messageService.getTaskMessageContext(stid);
        }
        return new ArrayList<>();
    }

    @RequestMapping(value="/tmsmsg",  produces = "application/json;charset=UTF-8")
    @ResponseBody
    public void sendMsgByTask(@RequestBody STMessageVo vo){
        if(null!=vo){
            messageService.createMessage(vo);
        }
    }

    }
