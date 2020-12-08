package com.lst.comadep.service;

import com.lst.comadep.Entity.ApiResponse;
import com.lst.comadep.Entity.User;
import com.lst.comadep.Entity.Vo.UserVo;


public interface UserService {
    ApiResponse login(UserVo userVo);
    ApiResponse register(User user);
    User selectUserById(int id);
}
