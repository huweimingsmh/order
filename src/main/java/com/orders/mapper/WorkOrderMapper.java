package com.orders.mapper;

import com.orders.dao.WorkOrder;
import org.apache.ibatis.annotations.Mapper;

import java.sql.SQLException;
import java.util.List;

@Mapper
public interface WorkOrderMapper {

    public void createWorkOrder(WorkOrder wo)throws SQLException;

    public List<WorkOrder> getWorkOrders(String phone)throws SQLException;

    public void huiFuWorkOrder(long id,String context)throws SQLException;

}
