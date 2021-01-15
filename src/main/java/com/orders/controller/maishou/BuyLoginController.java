package com.orders.controller.maishou;

import com.orders.controller.LoginController;
import com.orders.service.BuyService;
import com.orders.utils.statecode.StateCode;
import com.orders.utils.tools.ToolsUtils;
import com.orders.vo.BuyRegisterVo;
import com.orders.vo.ForgetPwdVo;
import com.orders.vo.LoginVo;
import com.orders.vo.RegisterVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

//@RestController
@Controller
public class BuyLoginController  {//implements LoginController
    @Autowired
    private BuyService buyService;


    @RequestMapping(value="/blogin",  produces = "application/json;charset=UTF-8")
    @ResponseBody

    public String login(@RequestBody LoginVo vo, HttpSession session) {

        if(null!=vo){
            if(ToolsUtils.isOnline(vo.getPhone(),session)) {
              return   ToolsUtils.forwordPage("url","home.html");
            }
            int result=buyService.login(vo,session);
            if(result==StateCode.OK){
                return   ToolsUtils.forwordPage("url","home.html");
            }
            if(result==StateCode.PHONE_ERROR) {
                return ToolsUtils.showError("手机号码错误,请输入正确手机号码!");
            }else if(result==StateCode.PWD_ERROR){
                return ToolsUtils.showError("密码错误,请输入正确密码!");
            }
        }
        return   ToolsUtils.forwordPage("url","error.html");
    }

    @RequestMapping(value="/bfpwd",  produces = "application/json;charset=UTF-8")
    @ResponseBody

    public String resetPwd(@RequestBody ForgetPwdVo vo,HttpSession session) {
        if(null!=vo){
            int result=buyService.forgetPwd(vo,session);
            if(result== StateCode.OK) {
                return ToolsUtils.forwordPage("url", "login.html");
            }
            if(result==StateCode.PWD_RE_ERROR){
                return ToolsUtils.showError("两次输入密码不一致,请确认输入正确!");
            }else if(result==StateCode.PHONE_VALIDATE_ERROR){
                return ToolsUtils.showError("手机验证码错误!");
            }
        }
        return   ToolsUtils.forwordPage("url","error.html");
    }

    @RequestMapping(value="/br",  produces = "application/json;charset=UTF-8")
    @ResponseBody

    public String registed(@RequestBody BuyRegisterVo vo, HttpSession session) {
        if(null!=vo){
            int result=buyService.register(vo,session);
            if(result==StateCode.OK){
                return   ToolsUtils.forwordPage("url","home.html");
            }
            if(result==StateCode.UNIQUE_ERROR){
                return ToolsUtils.showError("手机号已被注册!");
            }
            if(result==StateCode.PHONE_ERROR){
                return ToolsUtils.showError("手机号码错误,请输入正确手机号码!");
            }
            if(result==StateCode.PHONE_VALIDATE_ERROR){
                return ToolsUtils.showError("手机验证码错误!");
            }
        }
        return   ToolsUtils.forwordPage("url","error.html");
    }
}
