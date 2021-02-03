package com.orders.controller.task;

import com.orders.service.ServiceCoseService;
import com.orders.service.TaskService;
import com.orders.vo.ServiceCostVo;
import com.orders.vo.task.TaskInfo;
import com.orders.vo.task.TaskOrderInfoVo;
import com.orders.vo.task.TaskShowVo;
import com.orders.vo.task.TaskVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class TaskController {

    @Autowired
    private ServiceCoseService serviceCost;
    @Autowired
    private TaskService taskService;

    @RequestMapping(value = "/pushtask", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ServiceCostVo pushNewTask(){
        return serviceCost.getServiceCost();
    }

    @RequestMapping(value = "/newtask", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public void createNewTask(@RequestBody TaskVo vo){
        if(null!=vo){
            taskService.createNewTask(vo);
        }
    }

    @RequestMapping(value = "/taskagent", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public void createNewTask(@RequestBody Map<String,Object> param){
        String tid=(String)param.get("tid");
        taskService.createNewTask(tid);
    }
    @RequestMapping(value = "/cancelTask", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public void cancelTasks(@RequestBody Map<String,Object> param){
        String tid=(String)param.get("tid");
        taskService.createNewTask(tid);
    }
    @RequestMapping(value = "/gtbs", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public TaskShowVo getTaskByState(@RequestBody Map<String,Object> param){
        String phone=(String)param.get("phone");
        int state=Integer.valueOf((String)param.get("state"));
        return taskService.getTaskByState(phone,state);
    }

    @RequestMapping(value = "/gtbt", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public TaskShowVo getTaskByType(@RequestBody Map<String,Object> param) {
        String phone=(String)param.get("phone");
        int type=Integer.valueOf((String)param.get("type"));
       return taskService.getTaskByType(phone,type);

    }
    @RequestMapping(value = "/gtbgs", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public TaskShowVo getTaskByGetState(@RequestBody Map<String,Object> param) {
        String phone=(String)param.get("phone");
        int getState=Integer.valueOf((String)param.get("getState"));
        return taskService.getTaskByGetState(phone,getState);

    }
    @RequestMapping(value = "/gtbsn", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public TaskShowVo getTaskByShopName(@RequestBody Map<String,Object> param)
    {
        String phone=(String)param.get("phone");
        String shopName=(String)param.get("shopName");
        return taskService.getTaskByShopName(phone,shopName);
    }
    @RequestMapping(value = "/gtbgn", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public TaskShowVo getTaskByGoodsName(@RequestBody Map<String,Object> param) {
        String phone=(String)param.get("phone");
        String goodsName=(String)param.get("goodsName");
        return taskService.getTaskByGoodsName(phone,goodsName);
    }
    @RequestMapping(value = "/gtbtid", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public TaskShowVo getTaskByTid(@RequestBody Map<String,Object> param){
        String tid=(String)param.get("tid");
        return taskService.getTaskByTid(tid);
    }

    @RequestMapping(value = "/gtbct", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public TaskShowVo getTaskByCTime(@RequestBody Map<String,Object> param){
        String phone=(String)param.get("phone");
        String startTime=(String)param.get("startTime");
        String endTime=(String)param.get("endTime");
        return taskService.getTaskByCTime(phone,startTime,endTime);
    }
    @RequestMapping(value = "/gtbtt", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public TaskShowVo getTaskByTTime(@RequestBody Map<String,Object> param){
        String phone=(String)param.get("phone");
        String startTime=(String)param.get("startTime");
        String endTime=(String)param.get("endTime");
        return taskService.getTaskByTTime(phone,startTime,endTime);
    }

    @RequestMapping(value = "/gtinfo", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public TaskInfo getTaskInfo(@RequestBody Map<String,Object> param){
        String tid=(String)param.get("tid");
        return taskService.getTaskInfo(tid);
    }

    @RequestMapping(value = "/gbdownOrder", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public TaskOrderInfoVo getTaskOrderInfo(@RequestBody Map<String,Object> param){
        String tid=(String)param.get("tid");
        long quoQi=Long.valueOf((String)param.get("quoQi"));
        return taskService.getTaskOrder(tid,quoQi);
    }

    @RequestMapping(value = "/gtlink", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String getTaskLink(@RequestBody Map<String,Object> param){
        String tid=(String)param.get("tid");
        return taskService.getTaskLink(tid);
    }

    @RequestMapping(value = "/gtqrcode", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String getTaskQRCode(@RequestBody Map<String,Object> param){
        String tid=(String)param.get("tid");
        return taskService.getTaskQRCode(tid);
    }

}
