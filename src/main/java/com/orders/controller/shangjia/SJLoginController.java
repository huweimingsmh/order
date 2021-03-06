package com.orders.controller.shangjia;

import com.orders.controller.LoginController;
import com.orders.service.ShangJiaService;
import com.orders.utils.statecode.StateCode;
import com.orders.utils.tools.ToolsUtils;
import com.orders.vo.ForgetPwdVo;
import com.orders.vo.LoginVo;
import com.orders.vo.RegisterVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class SJLoginController implements LoginController {

    @Autowired
    private ShangJiaService shangJiaService;



    @RequestMapping(value="/sjlogin",  produces = "application/json;charset=UTF-8")
    //@GetMapping("/sjlogin")
    @ResponseBody
    @Override
    public String login(@RequestBody LoginVo vo, HttpSession session) {
        if(null!=vo){
            if(ToolsUtils.isOnline(vo.getPhone(),session)) {
                return   ToolsUtils.forwordPage("url","home.html");
            }


            int result=shangJiaService.login(vo,session);
            if(result== StateCode.OK){
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

    @RequestMapping(value="/sjfpwd",  produces = "application/json;charset=UTF-8")
    @ResponseBody
    @Override
    public String resetPwd(@RequestBody ForgetPwdVo vo,HttpSession session)
    {
        if(null!=vo){
            int result=shangJiaService.forgetPwd(vo,session);
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

    @RequestMapping(value="/sjr",  produces = "application/json;charset=UTF-8")
    @ResponseBody
    @Override
    public String registed(@RequestBody RegisterVo vo, HttpSession session) {

        if(null!=vo){
            int result=shangJiaService.register(vo,session);
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
