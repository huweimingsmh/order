package com.orders.controller;

import com.orders.vo.ForgetPwdVo;
import com.orders.vo.LoginVo;
import com.orders.vo.RegisterVo;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpSession;

public interface LoginController {

    public String login(@RequestBody LoginVo vo, HttpSession session);

    public String resetPwd(@RequestBody ForgetPwdVo vo,HttpSession session);

    public String registed(@RequestBody RegisterVo vo, HttpSession session);
}
