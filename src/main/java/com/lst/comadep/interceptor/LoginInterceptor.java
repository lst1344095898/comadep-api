package com.lst.comadep.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取请求的地址（根域名以外的部分）
        String url = request.getRequestURI();
//        if (url.indexOf("front/signIn") >= 0
//                || url.indexOf("front/login") >= 0
//                || url.indexOf("front/frontRegister") >= 0
//                || url.indexOf("front/register") >= 0
//        ){
//            return true;
//        }
        System.out.println("拦截到："+url);
        //获取session，有就是说明已经登录，没有就是拦截访问并跳转到登录页面
        HttpSession session = request.getSession();
        //获取session
        String userName = (String) session.getAttribute("userName");
        //判断是否登录
        if (userName != null){
            return true;
        }
        request.setAttribute("msg","还没登录！");
        request.getRequestDispatcher("login").forward(request,response);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
