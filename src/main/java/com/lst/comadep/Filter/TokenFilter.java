package com.lst.comadep.Filter;

import com.lst.comadep.utils.JwtUitls;
import org.json.JSONObject;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
@Order(2)
@WebFilter(filterName = "TokenFilter",urlPatterns = {"/*"})
public class TokenFilter implements Filter {
    private static final String[] arrUrl={"/login","/register","/registerCheck","/redis","/getManyDate",
            "/getManyDate2","/getManyDate3"};
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        boolean isNoFilter=false;
        JwtUitls jwtUitls=new JwtUitls();
        Map<String,String> map = new HashMap<>();
//        System.out.println((HttpServletRequest)servletRequest.get);
        String url =  ((HttpServletRequest)servletRequest).getRequestURI();
        String method=((HttpServletRequest)servletRequest).getMethod();
        if(url != null){
            //登录请求直接放行
            //排除特定过滤路径
            for (String temp: arrUrl
                 ) {
                if (temp.equals(url)){
                    isNoFilter=true;
                    break;
                }
            }
            if(isNoFilter){
                System.out.println("登录//注册");
                filterChain.doFilter(servletRequest,servletResponse);
                return;
            }else if (method.equals("OPTIONS")){
                System.out.println("OPTIONS放行");
                filterChain.doFilter(servletRequest,servletResponse);
                return;
            }
            else{
                System.out.println("token验证");
                String token =((HttpServletRequest)servletRequest).getHeader("Authorization");
                //其他请求验证token
//                System.out.println(token);
                if(token!=null){
                    //token验证结果
                    int verify  = jwtUitls.verify(token);
                    if(verify != 1){
                        //验证失败
                        if(verify == 2){
                            map.put("errorMsg","token已过期");
                        }else if(verify == 0){
                            map.put("errorMsg","用户信息验证失败");
                        }
                    }else if (verify == 1){
                        //验证成功，放行
                        filterChain.doFilter(servletRequest,servletResponse);
                        return;
                    }
                }else{
                    //token为空的返回
                    map.put("errorMsg","未携带token信息");
                }
            }
            JSONObject jsonObject = new JSONObject(map);
            servletResponse.setContentType("application/json");
            //设置响应的编码
            servletResponse.setCharacterEncoding("utf-8");
            //响应
            PrintWriter pw=servletResponse.getWriter();
            pw.write(jsonObject.toString());
            pw.flush();
            pw.close();
            return;
        }
    }

    @Override
    public void destroy() {

    }
}
