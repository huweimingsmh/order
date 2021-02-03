package com.orders.utils.tools;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.orders.dao.AccountWater;
import com.orders.dao.Dao;
import com.orders.dao.maishou.Buyer;
import com.orders.dao.shangjia.ShangJia;
import com.orders.dao.shops.Shop;
import com.orders.utils.statecode.AccountCategory;
import com.orders.utils.statecode.StateCode;
import com.orders.vo.BuyRegisterVo;
import com.orders.vo.ShangJiaRegisterVo;
import com.orders.vo.ShopVo;

import java.util.Date;

public class ServiceTools {

    public static int checkPhoneValidate(String inCode,String hasCode){
        if(!inCode.equals(hasCode)){
            return StateCode.PHONE_VALIDATE_ERROR;
        }
        return StateCode.OK;
    }

    public static int checkPwd(String inPwd,String hasPwd){
        if(inPwd.equals(hasPwd)){
            return StateCode.OK;
        }
        return StateCode.PWD_ERROR;
    }

    public static int checkRePwd(String newPwd,String reNewPwd){
        if(newPwd.equals(reNewPwd)){
            return StateCode.OK;
        }
        return StateCode.PWD_RE_ERROR;
    }

    public static Buyer createBuyer(BuyRegisterVo vo){
        Buyer buyer=new Buyer();
        buyer.setPwd(vo.getPwd());
        buyer.setPhone(vo.getPhone());
        buyer.setcTime(new Date());
        buyer.setSex(vo.getSex());
       // buyer.setSuperId(1);
        buyer.setTaobaoVip(vo.getTaobaovip());
        buyer.setWeiXin(vo.getWeixin());
        return buyer;
    }
    public static ShangJia createShangJia(ShangJiaRegisterVo vo){
        ShangJia shangJia=new ShangJia();
        shangJia.setcTime(new Date());
        shangJia.setPhone(vo.getPhone());
        shangJia.setPwd(vo.getPwd());
        shangJia.setQq(vo.getQq());
        shangJia.setSelfMoney(0);
        shangJia.setYaoqingMoney(0);
        shangJia.setZengzhiMoney(0);
        shangJia.setYongjinMoney(0);
       // shangJia.setSuperCode();
        return shangJia;
    }

    public static AccountWater createAccountWater(String phone,double rMoney,double hMoney,int category){
        AccountWater aw = new AccountWater();
        aw.setCategory(category);
        aw.setcMoney(rMoney);
        aw.setInfo("");
        aw.setPhone(phone);
        aw.setrMoney(hMoney);
        aw.settTime(new Date());
        return aw;
    }

    public static Shop createShop(ShopVo vo,String wangWang){
        Shop shop=new Shop();
        shop.setAddress(vo.getAddress());
        shop.setImage(vo.getImage());
        shop.setName(vo.getName());
        shop.setPhone(vo.getPhone());
        shop.setPlatform(vo.getPlatform());
       // shop.setSdesc("");
        shop.setsPhone(vo.getsPhone());
        shop.setState(0);
        shop.setsTime(new Date());
        shop.setWangWang(wangWang);
      //  shop.setWhere(vo.getWhere());
        shop.setsWhere(vo.getWhere());
        return shop;

    }

    public static Shop createShop(ShopVo vo){
        return createShop(vo,"");
    }

    public static String toJson(Dao dao)throws Exception{
        ObjectMapper objectMapper=new ObjectMapper();
        return objectMapper.writeValueAsString(dao);
    }
}
