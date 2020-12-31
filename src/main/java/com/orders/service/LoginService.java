package com.orders.service;

import com.orders.vo.ForgetPwdVo;
import com.orders.vo.LoginVo;

import javax.servlet.http.HttpSession;

public interface LoginService {

    /**
     * 检测用户是否已登录
     * @param phone
     * @param session
     * @return
     */
    public boolean isOnline(String phone, HttpSession session);

    public int login(LoginVo vo, HttpSession session);

    /**
     * 忘记密码重设
     * @param vo
     */
    public int forgetPwd(ForgetPwdVo vo,HttpSession session);
}
