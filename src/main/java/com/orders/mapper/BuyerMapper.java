package com.orders.mapper;

import com.orders.dao.maishou.Buyer;
import org.apache.ibatis.annotations.Mapper;

import javax.servlet.http.HttpSession;
import java.sql.SQLException;

@Mapper
public interface BuyerMapper {

    public Buyer getBuyer(String phone)throws SQLException;

    public void  registerBuyer(Buyer buyer)throws SQLException;

    public int updatePwd(Buyer buyer)throws SQLException;

    public int getMsgCount(String phone)throws SQLException;

    public int getShensuCount(String phone)throws SQLException;

    public int updateBuyVip(Buyer buy)throws SQLException;
}

