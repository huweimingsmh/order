package com.orders.service.maishou;

import com.orders.dao.maishou.Buyer;
import com.orders.mapper.BuyerMapper;
import com.orders.service.BuyService;
import com.orders.utils.statecode.StateCode;
import com.orders.utils.tools.ServiceTools;
import com.orders.vo.BuyRegisterVo;
import com.orders.vo.ForgetPwdVo;
import com.orders.vo.LoginVo;
import com.orders.vo.RegisterVo;
import org.apache.ibatis.jdbc.SQL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;

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
    public int register(RegisterVo vo, HttpSession session) {
        if(null!=vo){
            String code=(String)session.getAttribute(vo.getPhone());
            if(ServiceTools.checkPhoneValidate(vo.getCheckCode(),code)!=StateCode.OK){
                return StateCode.PHONE_VALIDATE_ERROR;
            }
            Buyer buyer=ServiceTools.createBuyer((BuyRegisterVo) vo);
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
