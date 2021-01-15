package com.orders.controller.home;

import com.orders.controller.shops.ShopController;
import com.orders.service.HomePageService;
import com.orders.service.home.BuyHomePageServiceImp;
import com.orders.service.home.SJHomePageServiceImp;
import com.orders.vo.BuyHomeVo;
import com.orders.vo.HomeVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;
@Controller
public class HomeController {


    @Autowired
    private BuyHomePageServiceImp bHpService;
    @Autowired
    private SJHomePageServiceImp  sjHpService;
    @RequestMapping(value = "/sjhome", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public HomeVo getHomePageBySJ(@RequestBody String phone, HttpSession session){
         return sjHpService.getHomePageDate(phone,session);
    }

    @RequestMapping(value = "/bhome", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public BuyHomeVo getHomePageByBuyer(@RequestBody String phone, HttpSession session){
        return bHpService.getHomePageDate(phone,session);
    }
}
