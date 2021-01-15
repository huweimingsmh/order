package com.orders.mapper;

import com.orders.dao.shangjia.ShangJia;
import org.apache.ibatis.annotations.Mapper;

import java.sql.SQLException;

@Mapper
public interface ShangJiaMapper {

    public ShangJia getShangJia(String phone) throws SQLException;

    public void register(ShangJia shangJia) throws SQLException;

    public int updatePwd(ShangJia shangJia) throws SQLException;

    //public int updateSelfMoney(long id,int money) throws SQLException;

    public int updateYongJinMoney(String phone,int money) throws SQLException;
    public int updateSelfMoney(String phone,int money) throws SQLException;
    public int updateYaoQingMoney(String phone,int money) throws SQLException;

    public int getMsgCount(String phone);

    public int getShensuCount(String phone);
}
