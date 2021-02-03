package com.orders.interceptor;

import com.orders.vo.task.RequestParam;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class DownOrderInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler)throws Exception {

         HttpSession session = null;
//        Object username=session.getAttribute(ACYXWeChatConstants.SESSION_USER_NAME);
          String path=request.getServletPath();
          if(path.matches("/gbdownOrder")){
             session= request.getSession();
             if(session.isNew()){
                 RequestParam param=new RequestParam();
                 param.setTid(request.getParameter("tid"));
                 param.setGuqQi(Long.valueOf(request.getParameter("guqqi")));
                 param.setYqCode(request.getParameter("yqcode"));
                 session.setAttribute("downorder",param);
                 response.sendRedirect(request.getContextPath()+"/wechatplatformuser/loginRBAC.html");
                 return false;
             }else{
                 return true;
             }
          }
          return true;
//        if(null!=username) {//已登录
//            return true;
//        }else {//未登录
//            //直接重定向到登录页面
//            response.sendRedirect(request.getContextPath()+"/wechatplatformuser/loginRBAC.html");
//            return false;
//        }
    }

}
