package com.orders.controller.workorder;

import com.orders.dao.WorkOrder;
import com.orders.service.WorkOrderService;
import com.orders.vo.workorder.WorkOrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Controller
public class WorkOrderController {

    @Autowired
    private WorkOrderService woService;

    @RequestMapping(value = "/newwo", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public void createWorkOrder(@RequestBody WorkOrderVo wo){
        if(null!=wo){
            woService.createWorkOrder(wo);
        }
    }

    @RequestMapping(value = "/gwos", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<WorkOrder> getWorkOrders(@RequestBody Map<String,Object> param){
        String phone=(String)param.get("phone");
        return woService.getWorkOrders(phone);
    }

    @RequestMapping(value = "/hfwo", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public void huiFuWorkOrder(@RequestBody Map<String,Object> param){
        long id=Long.valueOf((String)param.get("id"));
        String context=(String)param.get("context");
        woService.huiFuWorkOrder(id,context);
    }
}
