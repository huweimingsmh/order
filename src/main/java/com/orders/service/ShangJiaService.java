package com.orders.service;

import com.orders.dao.shangjia.ShangJia;
import com.orders.vo.ForgetPwdVo;
import com.orders.vo.RegisterVo;
import com.orders.vo.ShangJiaRegisterVo;

import javax.servlet.http.HttpSession;

public interface ShangJiaService extends LoginService  {
    /**
     * 按手机号查找商家
     * @param phone
     * @return
     */

    public ShangJia getShangJia(String phone);

    /**
     * 商家注册
     * @param vo
     */
    public int register(RegisterVo vo, HttpSession session);

    public int getMsgCount(String phone, HttpSession session);

    public int getShensuCount(String phone, HttpSession session);



}
