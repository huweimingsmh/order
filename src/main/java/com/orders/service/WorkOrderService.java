package com.orders.service;

import com.orders.dao.WorkOrder;
import com.orders.vo.workorder.WorkOrderVo;

import java.sql.SQLException;
import java.util.List;

public interface WorkOrderService {

    public void createWorkOrder(WorkOrderVo wo);

    public List<WorkOrder> getWorkOrders(String phone);

    public void huiFuWorkOrder(long id,String context);
}
