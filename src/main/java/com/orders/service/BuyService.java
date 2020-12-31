package com.orders.service;

import com.orders.dao.maishou.Buyer;
import com.orders.vo.BuyRegisterVo;
import com.orders.vo.ForgetPwdVo;
import com.orders.vo.LoginVo;
import com.orders.vo.RegisterVo;

import javax.servlet.http.HttpSession;

public interface BuyService extends LoginService {

    /**
     * 按手机号查找买手
     * @param phone
     * @return
     */
    public Buyer getBuyer(String phone);

    /**
     * 买手注册
     * @param vo
     */
    public int register(RegisterVo vo, HttpSession session);






}
