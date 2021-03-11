package com.lst.comadep.config;

import com.lst.comadep.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //对所有请求拦截除了login和注册   // z这是一个拦截器
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**").excludePathPatterns("/register","/login");
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        WebMvcConfigurer.super.addCorsMappings(registry);
//        registry.addMapping("/**").allowedOrigins("http://localhost:8080")
//                .allowedMethods("POST","GET","PUT","OPTIONS","DELETE")
//                .maxAge(5000)
//                .allowedHeaders("*")
//                .allowCredentials(true);
    }
}
