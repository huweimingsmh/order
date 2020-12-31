package com.orders.service;

import com.orders.dao.shops.Shop;
import com.orders.vo.ShopVo;

import java.util.List;

public interface ShopService {

    /**
     * 新增店铺
     * @param shop
     */
    public void addShop(ShopVo shop);

    /**
     * 获得店铺列表
     * @param phone
     * @return
     */
    public List<Shop> getShop(String phone);

    /**
     * 按状态获得店铺列表
     * @param phone
     * @param state
     * @return
     */

    public List<Shop> getShopByState(String phone,int state);

    /**
     * 编辑店铺
     * @param shop
     */
    public void editShop(ShopVo shop);

    /**
     * 删除店铺
     * @param id
     */
    public void delShop(long id);

    public Shop getShopByName(String phone,String name);
}
