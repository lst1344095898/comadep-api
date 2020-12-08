package com.lst.comadep.controller;

import com.lst.comadep.Entity.User;
import com.lst.comadep.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    private UserService userService;
    @GetMapping("/hello")
    public String hello(){
        return "hello word";
    }
    @GetMapping("/index")
    public String index(){
        return  "index";
    }
    @GetMapping("/error")
    public String error(){
        return  "error";
    }
    @GetMapping("/power")
    public String power(){
        return  "power";
    }
    @GetMapping("/login")
    public String login(){
        System.out.println("触发/test/login");
        return  "login";
    }
    public User getUserById(int id){
        System.out.println("触发getUserById");
        return userService.selectUserById(id);
    }
}
