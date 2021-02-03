package com.orders.mapper;

import com.orders.dao.TransferWater;
import com.orders.vo.TransferChangeVo;
import org.apache.ibatis.annotations.Mapper;

import java.sql.SQLException;
import java.util.List;
@Mapper
public interface TransferWaterMapper {

    public List<TransferWater> getTransferWater(String phone) throws SQLException;

    public void addTransferWater(TransferWater water) throws SQLException;

    public TransferWater getTransferWaterById(long id) throws SQLException;

    public void updateTransferState(TransferChangeVo vo) throws SQLException;

}
