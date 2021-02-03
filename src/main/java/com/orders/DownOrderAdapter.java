package com.orders;

import com.orders.interceptor.DownOrderInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@SpringBootApplication
@EnableCaching
public class DownOrderAdapter implements WebMvcConfigurer {
    @Autowired
    private DownOrderInterceptor downOrder;
    public void addInterceptors(InterceptorRegistry registry) {

        //添加对用户是否登录的拦截器，并添加过滤项、排除项
        registry.addInterceptor(downOrder).addPathPatterns("/**")
//                .excludePathPatterns("/css/**","/js/**","/images/**")//排除样式、脚本、图片等资源文件
//                .excludePathPatterns("/wechatplatformuser/loginRBAC.html")//排除登录页面
//                .excludePathPatterns("/wechatplatformuser/defaultKaptcha")//排除验证码
                .excludePathPatterns("/login");//排除用户点击登录按钮

    }

}
