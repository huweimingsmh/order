package com.orders.controller.shensu;

import com.orders.service.ShenSuService;
import com.orders.vo.ShenSuNewVo;
import com.orders.vo.ShenSuRVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class ShenSuController {

    @Autowired
    private ShenSuService shenSuService;
    /**
     * 获得申诉列表
     * @param phone
     * @return
     */
    @RequestMapping(value="/sjgssls",  produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<ShenSuRVo> getShenSuList(@RequestBody String phone){
        if(null!=phone) {
            return   shenSuService.getShenSu(phone);
        }
        return new ArrayList<>();
    }

    @RequestMapping(value="/sjgsslbs",  produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<ShenSuRVo> getShenSuListBySend(@RequestBody String phone){
        if(null!=phone) {
            return   shenSuService.getShenSuByBuilder(phone);
        }
        return new ArrayList<>();
    }

    @RequestMapping(value="/sjgsslrs",  produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<ShenSuRVo> getShenSuListByRev(@RequestBody String phone){
        if(null!=phone) {
            return   shenSuService.getShenSuByAccpter(phone);
        }
        return new ArrayList<>();
    }

    @RequestMapping(value="/gsjssls",  produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<ShenSuRVo> getShenSuListBySJ(@RequestBody String phone){
        if(null!=phone) {
            return   shenSuService.getShenSuBySJ(phone);
        }
        return new ArrayList<>();
    }

    @RequestMapping(value="/gbssls",  produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<ShenSuRVo> getShenSuListByBuy(@RequestBody String phone){
        if(null!=phone) {
            return   shenSuService.getShenSuByB(phone);
        }
        return new ArrayList<>();
    }

    @RequestMapping(value="/gsssls",  produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<ShenSuRVo> getShenSuListByState(@RequestBody Map<String,Object> param){
        String phone=(String)param.get("phone");
        int state=Integer.valueOf((String)param.get("state"));

        if(null!=phone) {
            return   shenSuService.getShenSuByState(phone,state);
        }
        return new ArrayList<>();
    }

    @RequestMapping(value="/stidgssls",  produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<ShenSuRVo> getShenSuListBySTID(@RequestBody String stid){
        if(null!=stid) {
            return   shenSuService.getShenSuByStid(stid);
        }
        return new ArrayList<>();
    }

    @RequestMapping(value="/gsjpssls",  produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<ShenSuRVo> getShenSuListBySJPhone(@RequestBody String phone){
        if(null!=phone) {
            return   shenSuService.getShenSuBySJPhone(phone);
        }
        return new ArrayList<>();

    }
    @RequestMapping(value="/gbpssls",  produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<ShenSuRVo> getShenSuListByBuyPhone(@RequestBody String phone){
        if(null!=phone) {
            return   shenSuService.getShenSuByBPhone(phone);
        }
        return new ArrayList<>();

    }
    @RequestMapping(value="/gsnssls",  produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<ShenSuRVo> getShenSuListByShopName(@RequestBody String shopName){
        if(null!=shopName) {
            return   shenSuService.getShenSuByShopName(shopName);
        }
        return new ArrayList<>();

    }
    @RequestMapping(value="/getvipssls",  produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<ShenSuRVo> getShenSuListByTaobaoVip(@RequestBody String vip){
        if(null!=vip) {
            return   shenSuService.getShenSuByVip(vip);
        }
        return new ArrayList<>();

    }
    @RequestMapping(value="/goidssls",  produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<ShenSuRVo> getShenSuListByOid(@RequestBody String oid){
        if(null!=oid) {
            return   shenSuService.getShenSuByOid(oid);
        }
        return new ArrayList<>();

    }


    public List<ShenSuRVo> getShenSu(@RequestBody String phone){
        if(null!=phone) {
            return   shenSuService.getShenSu(phone);
        }
        return new ArrayList<>();
    }

    @RequestMapping(value="/cnewss",  produces = "application/json;charset=UTF-8")
    @ResponseBody
    public void createShenSu(@RequestBody ShenSuNewVo vo){
        if(null!=vo){
            shenSuService.buildShenSu(vo);
        }

    }

}
