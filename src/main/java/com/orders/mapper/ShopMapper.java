package com.orders.mapper;

import com.orders.dao.shops.Shop;
import org.apache.ibatis.annotations.Mapper;

import java.sql.SQLException;
import java.util.List;

@Mapper
public interface ShopMapper {

    public void addShop(Shop shop) throws SQLException;

    public List<Shop> getShop(String phone) throws SQLException;

    public List<Shop> getShopByState(String phone,int state) throws SQLException;

    public void editShop(Shop shop) throws SQLException;

    public void delShop(long id) throws SQLException;

    public Shop getShopByName(String name) throws SQLException;
}
