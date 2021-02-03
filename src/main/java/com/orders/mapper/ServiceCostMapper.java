package com.orders.mapper;

import com.orders.dao.ServiceCost;
import org.apache.ibatis.annotations.Mapper;

import java.sql.SQLException;
import java.util.List;

@Mapper
public interface ServiceCostMapper {

    public List<ServiceCost> getServiceCost()throws SQLException;
}
