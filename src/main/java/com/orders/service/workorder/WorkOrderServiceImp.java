package com.orders.service.workorder;

import com.orders.dao.WorkOrder;
import com.orders.mapper.WorkOrderMapper;
import com.orders.service.WorkOrderService;
import com.orders.service.task.TaskServiceImpl;
import com.orders.vo.workorder.WorkOrderVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value="workOrderService")
public class WorkOrderServiceImp implements WorkOrderService {

    private static Logger log= LoggerFactory.getLogger(TaskServiceImpl.class);
    @Autowired
    private WorkOrderMapper woMapper;
    @Override
    public void createWorkOrder(WorkOrderVo vo) {
        if(null!=vo){
            try {
                WorkOrder wo=new WorkOrder();
                wo.setBphone(vo.getBphone());
                wo.setImg(vo.getImg());
                wo.setWeiXinQun(vo.getWeiXinQun());
                wo.setWenTiDes(vo.getWenTiDes());
                woMapper.createWorkOrder(wo);
            }catch (Exception e){
                log.error(e.getMessage());
            }
        }
    }

    @Override
    public List<WorkOrder> getWorkOrders(String phone) {
        try {
            return woMapper.getWorkOrders(phone);
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return new ArrayList<>();
    }

    @Override
    public void huiFuWorkOrder(long id, String context) {
        try{
            woMapper.huiFuWorkOrder(id,context);
        }catch (Exception e){
            log.error(e.getMessage());
        }
    }
}
