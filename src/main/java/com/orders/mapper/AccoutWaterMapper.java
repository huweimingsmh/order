package com.orders.mapper;

import com.orders.dao.AccountWater;
import org.apache.ibatis.annotations.Mapper;

import java.sql.SQLException;
import java.util.List;

@Mapper
public interface AccoutWaterMapper {

    public List<AccountWater> getAccountWater(String phone) throws SQLException;

    public List<AccountWater> getAccountWaterByTime(String starTime,String endTime,String phone) throws SQLException;

    public void addAccountWater(AccountWater water) throws SQLException;

    public List<AccountWater> getAccountWaterByCategory(String phone,int category) throws SQLException;
}
