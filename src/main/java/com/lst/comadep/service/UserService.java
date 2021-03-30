package com.lst.comadep.service;

import com.lst.comadep.Entity.ApiResponse;
import com.lst.comadep.Entity.User;
import com.lst.comadep.Entity.Vo.PageParameter;
import com.lst.comadep.Entity.Vo.UserVo;


public interface UserService {
    ApiResponse login(UserVo userVo);
    ApiResponse register(User user);
    User selectUserById(int id);
    User selectUserByIdInOriginal(int id);
    ApiResponse registerCheck(User user);
    ApiResponse getUserByParameter(PageParameter pageParameter);
    ApiResponse searchUser(PageParameter pageParameter);
    ApiResponse deleteUserById(UserVo userVo);
    ApiResponse modifyUserById(User user);
    ApiResponse downloadUser();
}
