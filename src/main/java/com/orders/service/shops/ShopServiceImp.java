package com.orders.service.shops;

import com.orders.dao.shangjia.ShangJia;
import com.orders.dao.shops.Shop;
import com.orders.mapper.ShangJiaMapper;
import com.orders.mapper.ShopMapper;
import com.orders.service.ShopService;
import com.orders.service.account.AccountServiceImp;
import com.orders.utils.tools.ServiceTools;
import com.orders.vo.ShopVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ShopServiceImp implements ShopService {
    private static Logger log= LoggerFactory.getLogger(ShopServiceImp.class);

    @Autowired
    private ShopMapper shopMaper;
    @Autowired
    private ShangJiaMapper shangJiaMapper;
    @Override
    public void addShop(ShopVo vo) {
        try{
        if(null!=vo){
            ShangJia sj=shangJiaMapper.getShangJia(vo.getPhone());
            if(null!=sj) {
                Shop shop = ServiceTools.createShop(vo, "");
                shopMaper.addShop(shop);
            }
        }
        }catch(SQLException sql){
            log.error(sql.getMessage());
        }catch (Exception e){
            log.error(e.getMessage());
        }
    }

    @Override
    public List<Shop> getShop(String phone) {
        try {
            return shopMaper.getShop(phone);
        }catch(SQLException sql){
            log.error(sql.getMessage());
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return new ArrayList<>();
    }

    @Override
    public List<Shop> getShopByState(String phone, int state) {
        try{
        return shopMaper.getShopByState(phone,state);
        }catch(SQLException sql){
            log.error(sql.getMessage());
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return new ArrayList<>();
    }

    @Override
    public void editShop(ShopVo vo) {
        try{
        if(null!=vo){
            Shop shop=ServiceTools.createShop(vo);
           shopMaper.editShop(shop);
        }
        }catch(SQLException sql){
            log.error(sql.getMessage());
        }catch (Exception e){
            log.error(e.getMessage());
        }
    }

    @Override
    public void delShop(long id) {
        try{
        shopMaper.delShop(id);
        }catch(SQLException sql){
            log.error(sql.getMessage());
        }catch (Exception e){
            log.error(e.getMessage());
        }
    }

    @Override
    public Shop getShopByName(String phone, String name) {
        try {
            if (null != name && !name.equals("") && name.length() > 0) {
                return shopMaper.getShopByName(name);
            }
        }catch(SQLException sql){
            log.error(sql.getMessage());
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return null;
    }
}
