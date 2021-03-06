package com.lst.comadep.service.serviceImpl;

import com.lst.comadep.Dao.UserDao;
import com.lst.comadep.Entity.ApiResponse;
import com.lst.comadep.Entity.OriginalUser;
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
        User user=userDao.check(userVo.getTelephoneNumber());
        System.out.println("getUser="+user);
        JwtUitls jwtUitls=new JwtUitls();
        if (user!=null){
            if (MD5Utils.inputPassToFormPass(userVo.getPassword()).equals(user.getPassword())){
                //登录成功返回token
                String token=jwtUitls.createToken(Integer.toString(user.getId()),user.getUserName());
                user.setPassword("123");
                return new ApiResponse(200,"登录成功",user,token);
            }else {
                return new ApiResponse(400,"密码错误");
            }

        }
        return new ApiResponse(400,"请检查用户名，该用户不存在");
    }

    @Override
    public ApiResponse registerCheck(User user) {
        //检查物业user表是否有这个值。
        //1检查电话号和用户名是否正确
        OriginalUser originalUser = userDao.PropertyUserCheck(user.getTelephoneNumber());
        if (originalUser==null){
            return new ApiResponse(400,"请检查手机号，该手机号不存在");
        } else{
            if (!user.getUserName().equals(originalUser.getUserName())){
                return new ApiResponse(400,"请检查用户名,该用户名不存在");
            }else if (originalUser.getIsActivation()==2){
                return new ApiResponse(400,"该用户已经被注册");
            }
            else{
                return new ApiResponse(200,"存在该用户",originalUser);
            }
        }
    }
    @Override
    public ApiResponse register(User user) {
        user.setCreateTime(new Date());
        //直接插入
        int temp=userDao.register(user.getId(),user.getUserName(), MD5Utils.inputPassToFormPass(user.getPassword()),user.getAddress(),
                user.getTelephoneNumber(),user.getPowerCode(),user.getSex(),user.getAge(),user.getCreateTime(),new Date(),
                user.getBuildingNumber(),user.getFloor());
        if (temp==1){
            //将物业用户表更新
            int update=userDao.updateRegisterIsActivationById(user.getId());
            if (update!=0)
                return new ApiResponse(200,"注册成功");
            else
                return new ApiResponse(400,"数据库添加失败请联系管理员");
        }
        return new ApiResponse(400,"服务器错误注册失败");
    }

    @Override
    public User selectUserById(int id) {
        System.out.println("触发selectService,id=2"+id);
        User user=userDao.selectUserById(id);
        return user;
    }

    @Override
    public User selectUserByIdInOriginal(int id) {
        return userDao.selectUserByIdInOriginal(id);
    }


}
