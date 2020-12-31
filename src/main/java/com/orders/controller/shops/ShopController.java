package com.orders.controller.shops;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.orders.controller.account.AccountController;
import com.orders.dao.shops.Shop;
import com.orders.service.ShopService;
import com.orders.utils.tools.ServiceTools;
import com.orders.utils.tools.ToolsUtils;
import com.orders.vo.ShopVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

public class ShopController {
    private static Logger log = LoggerFactory.getLogger(ShopController.class);
    @Autowired
    private ShopService shopService;

    @RequestMapping(value="/gs",  produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<Shop> getShop(String phone) {
        return shopService.getShop(phone);
    }

    @RequestMapping(value="/gss",  produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<Shop> getShopByState(String phone, int state) {
        return shopService.getShopByState(phone, state);
    }

    @RequestMapping(value="/sadd",  produces = "application/json;charset=UTF-8")
    @ResponseBody
    public void addShop(ShopVo vo) {
        if (null != vo) {
            shopService.addShop(vo);
        }
    }

    @RequestMapping(value="/sdel",  produces = "application/json;charset=UTF-8")
    @ResponseBody
    public void delShop(long id) {
        shopService.delShop(id);

    }

    @RequestMapping(value="/sedit",  produces = "application/json;charset=UTF-8")
    @ResponseBody
    public void editShop(ShopVo vo) {
        shopService.editShop(vo);
    }

    @RequestMapping(value="/sgn",  produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String getShopByName(String phone, String name) {
        Shop shop= shopService.getShopByName(phone, name);
        if(null!=shop){
            try {
                ServiceTools.toJson(shop);
            }catch (Exception e){
                log.error(e.getMessage());
            }
        }
        return ToolsUtils.forwordPage("url", "error.html");
    }
}
