package com.orders.service.maishou;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.orders.dao.maishou.Buyer;
import com.orders.dao.maishou.Tabbao;
import com.orders.mapper.BuyerMapper;
import com.orders.service.BuyService;
import com.orders.utils.statecode.StateCode;
import com.orders.utils.tools.ServiceTools;
import com.orders.utils.tools.ToolsUtils;
import com.orders.vo.BuyRegisterVo;
import com.orders.vo.ForgetPwdVo;
import com.orders.vo.LoginVo;
import com.orders.vo.RegisterVo;
import com.orders.vo.task.GoodsInfoVo;
import org.apache.ibatis.jdbc.SQL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service(value = "buyService")
public class BuyServiceImp implements BuyService{
    private static Logger log= LoggerFactory.getLogger(BuyServiceImp.class);

    @Autowired
    private BuyerMapper buyerMapper;
    @Override
    public Buyer getBuyer(String phone) {
        try{
        return buyerMapper.getBuyer(phone);
        }catch(SQLException e){
          log.error(e.getMessage());
        }
        return null;
    }

    @Override
    public int register(BuyRegisterVo vo, HttpSession session) {
        if(null!=vo){
            String code=(String)session.getAttribute(vo.getPhone());
            if(ServiceTools.checkPhoneValidate(vo.getCheckCode(),code)!=StateCode.OK){
                return StateCode.PHONE_VALIDATE_ERROR;
            }
            Buyer buyer=ServiceTools.createBuyer(vo);
            try {
                buyerMapper.registerBuyer(buyer);
                session.setAttribute(vo.getPhone(),buyer);
                return StateCode.OK;
            }catch(SQLException e){
                return StateCode.UNIQUE_ERROR;
            }

        }
        return StateCode.PHONE_ERROR;
    }

    @Override
    public int getMsgCount(String phone, HttpSession session) {
        Buyer buy=(Buyer)session.getAttribute(phone);
        try {
            if (null != buy) {
                return buy.getMsgCount();
            } else {
                return buyerMapper.getMsgCount(phone);
            }
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return 0;
    }

    @Override
    public int getShensuCount(String phone, HttpSession session) {
        Buyer buy=(Buyer)session.getAttribute(phone);
        try {
            if (null != buy) {
                return buy.getShensuCount();
            } else {
                return buyerMapper.getShensuCount(phone);
            }
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return 0;
    }

    @Override
    public void bangDingVip(String bphone, String vip) {
        try {
            Buyer buy = (Buyer) buyerMapper.getBuyer(bphone);
            if(null!=buy) {
               String vips=buy.getTaobaoVip();
                List<Tabbao> tabbaos=null;
                if(null==vips){
                     tabbaos=new ArrayList<>();
                    Tabbao tvip=new Tabbao();
                    tvip.setVip(vip);
                    tabbaos.add(tvip);
                }else{
                    tabbaos=getBuyTabbaoVipObj(vips);
                    Tabbao tvip=new Tabbao();
                    tvip.setVip(vip);
                    tabbaos.add(tvip);
                }
                buy.setTaobaoVip(toJsonBuyTabbaoVipStr(tabbaos));
               // buy.setTabbaoList(tabbaos);
                buyerMapper.updateBuyVip(buy);
               // List<Tabbao> tabbaos = buy.getTabbaoList();
            }

        }catch (Exception e){
            log.error(e.getMessage());
        }
    }

    private String toJsonBuyTabbaoVipStr(Object obj){
        try {
            ObjectMapper objMapper = new ObjectMapper();
            return objMapper.writeValueAsString(obj);

        }catch (Exception e){
            log.error(e.getMessage());
        }
       return "";
    }

    private List<Tabbao> getBuyTabbaoVipObj(String objStr){
        try {
            ObjectMapper objMapper = new ObjectMapper();
            return objMapper.readValue(objStr, new TypeReference<List<Tabbao>>() {
            });
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return new ArrayList<>();
    }


    @Override
    public int login(LoginVo vo, HttpSession session) {
        Buyer buyer=getBuyer(vo.getPhone());
        if(null!=buyer){
            if(ServiceTools.checkPwd(vo.getPwd(),buyer.getPwd())==StateCode.OK){
                session.setAttribute(vo.getPhone(),buyer);
                return StateCode.OK;
            }else{
                return StateCode.PWD_ERROR;
            }
        }else{
            return StateCode.PHONE_ERROR;
        }

    }

    @Override
    public int forgetPwd(ForgetPwdVo vo,HttpSession session) {
        String newPwd=vo.getNewPwd();
        String reNewPwd=vo.getReNewPwd();
        String code=(String)session.getAttribute(vo.getPhone());
        if(ServiceTools.checkPhoneValidate(vo.getCheckCode(),code)!=StateCode.OK){
            return StateCode.PHONE_VALIDATE_ERROR;
        }
        if(ServiceTools.checkRePwd(vo.getNewPwd(),vo.getReNewPwd())==StateCode.OK) {
            Buyer buyer = new Buyer();
            buyer.setPhone(vo.getPhone());
            buyer.setPwd(vo.getNewPwd());
            try{
            if(buyerMapper.updatePwd(buyer)==1){
                return StateCode.OK;
            }
            }catch(SQLException sql){
                log.error(sql.getMessage());
            }catch (Exception e){
                log.error(e.getMessage());
            }
        }
            return StateCode.PWD_RE_ERROR;

    }

    @Override
    public boolean isOnline(String phone, HttpSession session) {

        return false;
    }
}
