package com.lst.comadep.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lst.comadep.Entity.ApiResponse;
import com.lst.comadep.Entity.User;
import com.lst.comadep.Entity.Vo.PageParameter;
import com.lst.comadep.Entity.Vo.UserVo;
import com.lst.comadep.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    /**
     *  通过参数得到用户数据
     * @param pageParameter
     * @return
     */
    @PostMapping("/getUserByParameter")
    @ResponseBody
    public ApiResponse getUserByParameter(@RequestBody PageParameter pageParameter){
            return userService.getUserByParameter(pageParameter);
    }

    /**
     * 搜索用户数据
     * @param pageParameter
     * @return
     */
    @PostMapping("/searchUser")
    @ResponseBody
    public ApiResponse searchUser(@RequestBody PageParameter pageParameter){
        return userService.searchUser(pageParameter);
    }

    /**
     * 删除用户通过id
     * @param userVo
     * @return
     */
    @PostMapping("/deleteUserById")
    @ResponseBody
    public  ApiResponse deleteUserById(@RequestBody UserVo userVo){
        return userService.deleteUserById(userVo);
    }

    /**
     * 通过用户Id  修改用户数据
     * @param user
     * @return
     */
    @PostMapping("/modifyUserById")
    @ResponseBody
    public  ApiResponse modifyUserById(@RequestBody User user){
        return  userService.modifyUserById(user);
    }
}
