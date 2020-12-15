package com.lst.comadep.controller;

import com.lst.comadep.Entity.ApiResponse;
import com.lst.comadep.Entity.User;
import com.lst.comadep.Entity.Vo.UserVo;
import com.lst.comadep.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@CrossOrigin(origins = "http://localhost:8080")
@Controller
public class LoginController {

    private final UserService userService;
    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/login")
    @ResponseBody
    public ApiResponse Login(@RequestBody UserVo userVo, HttpServletRequest request){
        System.out.println(userVo);
        ApiResponse apiResponse= userService.login(userVo);
        if (apiResponse.getCode()==200){
            HttpSession session=request.getSession(true);
            session.setAttribute("userName",userVo.getUserName());
        }
        return apiResponse;
    }
    /**
     * 注册验证
     * */
    @PostMapping("/registerCheck")
    @ResponseBody
    public ApiResponse registerCheck(@RequestBody User user){

        if (user==null)
            return new ApiResponse(400,"数据为空");
        else
            return userService.registerCheck(user);
    }
    @PostMapping("/register")
    @ResponseBody
    public ApiResponse register(@RequestBody User user){
        System.out.println(user);
        if (user==null){
            return new ApiResponse(400,"数据为空");
        }
        return userService.register(user);
    }
    @PostMapping("/test")
    @ResponseBody
    public ApiResponse test(){
        System.out.println("这是一个测试接口");
        return new ApiResponse(200,"测试成功");
    }

}
