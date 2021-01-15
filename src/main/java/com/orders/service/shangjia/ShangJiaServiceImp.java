package com.orders.service.shangjia;

import com.orders.dao.maishou.Buyer;
import com.orders.dao.shangjia.ShangJia;
import com.orders.mapper.BuyerMapper;
import com.orders.mapper.ShangJiaMapper;
import com.orders.service.ShangJiaService;
import com.orders.service.maishou.BuyServiceImp;
import com.orders.utils.statecode.StateCode;
import com.orders.utils.tools.ServiceTools;
import com.orders.vo.ForgetPwdVo;
import com.orders.vo.LoginVo;
import com.orders.vo.RegisterVo;
import com.orders.vo.ShangJiaRegisterVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.sql.SQLException;

@Service(value="shangJiaService")
public class ShangJiaServiceImp implements ShangJiaService {
    private static Logger log= LoggerFactory.getLogger(ShangJiaServiceImp.class);

    @Autowired
    private ShangJiaMapper shangJiaMapper;
    @Override
    public ShangJia getShangJia(String phone) {
        try{
        return shangJiaMapper.getShangJia(phone);
        }catch(SQLException sql){
            log.error(sql.getMessage());
        }catch (Exception e){
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
            ShangJia shangJia=ServiceTools.createShangJia((ShangJiaRegisterVo)vo);
            try {
                shangJiaMapper.register(shangJia);
                session.setAttribute(vo.getPhone(),shangJia);
                return StateCode.OK;
            }catch(SQLException e) {
                return StateCode.UNIQUE_ERROR;
            }
        }
        return StateCode.PHONE_ERROR;
    }

    @Override
    public int getMsgCount(String phone, HttpSession session) {
        ShangJia sj=(ShangJia)session.getAttribute(phone);
        if(null!=sj){
            return sj.getMsgCount();
        }else{
            return shangJiaMapper.getMsgCount(phone);
        }

    }

    @Override
    public int getShensuCount(String phone, HttpSession session) {
       ShangJia sj=(ShangJia)session.getAttribute(phone);
       if(null!=sj){
           return sj.getShensuCount();
       }else{
         return   shangJiaMapper.getShensuCount(phone);
       }
    }


    @Override
    public boolean isOnline(String phone, HttpSession session) {
        return false;
    }

    @Override
    public int login(LoginVo vo, HttpSession session) {
        ShangJia shangJia=getShangJia(vo.getPhone());
        if(null!=shangJia){
            if(ServiceTools.checkPwd(vo.getPwd(),shangJia.getPwd())== StateCode.OK){
                session.setAttribute(vo.getPhone(),shangJia);
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
            ShangJia shangJia = new ShangJia();
            shangJia.setPhone(vo.getPhone());
            shangJia.setPwd(vo.getNewPwd());
            try{
            if(shangJiaMapper.updatePwd(shangJia)==1){
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
}
