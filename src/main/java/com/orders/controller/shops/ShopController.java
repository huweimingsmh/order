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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class ShopController {
    private static Logger log = LoggerFactory.getLogger(ShopController.class);
    @Autowired
    private ShopService shopService;

    @RequestMapping(value="/gshop",  produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<Shop> getShop(@RequestBody String phone) {

        return shopService.getShop(phone);
    }

    @RequestMapping(value="/gsshop",  produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<Shop> getShopByState(@RequestBody Map<String,Object> param) {
        String phone=(String)param.get("phone");
        int state=Integer.valueOf((String)param.get("state"));
        return shopService.getShopByState(phone, state);
    }

    @RequestMapping(value="/addshop",  produces = "application/json;charset=UTF-8")
    @ResponseBody
    public void addShop(@RequestBody ShopVo vo) {
        if (null != vo) {
            shopService.addShop(vo);
        }
    }

    @RequestMapping(value="/delshop",  produces = "application/json;charset=UTF-8")
    @ResponseBody
    public void delShop(@RequestBody String id) {

        shopService.delShop(Long.valueOf(id));

    }

    @RequestMapping(value="/editshop",  produces = "application/json;charset=UTF-8")
    @ResponseBody
    public void editShop(@RequestBody ShopVo vo) {

        shopService.editShop(vo);
    }

    @RequestMapping(value="/gnshop",  produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String getShopByName(@RequestBody Map<String,Object> param) {
        String phone=(String)param.get("phone");
        String name=(String)param.get("name");
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
