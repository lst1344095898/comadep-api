package com.lst.comadep.service.serviceImpl;

import com.lst.comadep.Dao.UserDao;
import com.lst.comadep.Entity.ApiResponse;
import com.lst.comadep.Entity.User;
import com.lst.comadep.Entity.Vo.UserVo;
import com.lst.comadep.service.UserService;
import com.lst.comadep.service.UserService2;
import com.lst.comadep.utils.JwtUitls;
import com.lst.comadep.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService {
    private final UserDao userDao;
    private final UserService2 userService2;

    @Autowired
    public UserServiceImpl(UserDao userDao, UserService2 userService2) {
        this.userDao = userDao;
        this.userService2 = userService2;
    }
    @Override
    public ApiResponse login(UserVo userVo) {
        //先得到密码在判断
        User user=userDao.check(userVo.getUserName());
        JwtUitls jwtUitls=new JwtUitls();
        if (user!=null){
            if (MD5Utils.inputPassToFormPass(userVo.getPassword()).equals(user.getPassword())){
                //登录成功返回token
                String token=jwtUitls.createToken(Integer.toString(user.getId()),user.getUserName());
                return new ApiResponse(200,"登录成功",user,token);
            }else {
                return new ApiResponse(400,"密码错误");
            }

        }
        return new ApiResponse(400,"error");
    }

    @Override
    public ApiResponse register(User user) {
        user.setAddress("大连");
        user.setTelephoneNumber("1231231");
        user.setSex("男");
        user.setAge(29);
        user.setCreateTime(new Date());
        //直接插入
        int temp=userDao.register(user.getUserName(), MD5Utils.inputPassToFormPass(user.getPassword()),user.getAddress(),
                user.getTelephoneNumber(),user.getSex(),user.getAge(),user.getCreateTime());
        if (temp==1){
            return new ApiResponse(200,"注册成功");
        }
        return new ApiResponse(400,"服务器错误注册失败");
    }

    @Override
    public User selectUserById(int id) {
        System.out.println("触发selectService,id=2"+id);
        User user=userDao.selectUserById(id);
        return user;
    }
}
