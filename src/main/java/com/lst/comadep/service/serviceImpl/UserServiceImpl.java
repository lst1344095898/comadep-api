package com.lst.comadep.service.serviceImpl;

import com.lst.comadep.Dao.UserDao;
import com.lst.comadep.Entity.ApiResponse;
import com.lst.comadep.Entity.OriginalUser;
import com.lst.comadep.Entity.User;
import com.lst.comadep.Entity.Vo.PageParameter;
import com.lst.comadep.Entity.Vo.UserVo;
import com.lst.comadep.service.UserService;
import com.lst.comadep.service.UserService2;
import com.lst.comadep.utils.JwtUitls;
import com.lst.comadep.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    /**
     * 通过参数得到用户
     * @param pageParameter
     * @return
     */
    @Override
    public ApiResponse getUserByParameter(PageParameter pageParameter) {
        //将楼层转化为String
//        System.out.println("得到参数="+pageParameter);
        String floorNumber=Integer.toString(pageParameter.getFloorNumber());
        //得到起始页
        int currPage=(pageParameter.getCurrPage()-1)*pageParameter.getPageSize();
        //得到用户
        ArrayList<User> userArrayList=userDao.getUserByParameter(currPage,pageParameter.getPageSize(),
                pageParameter.getBuildingNumber(),floorNumber);
        //得到所用用户总数
        int total=userDao.getUserTotalByParameter(pageParameter.getBuildingNumber(),floorNumber)/pageParameter.getPageSize();
//        System.out.println(userArrayList);
        return new ApiResponse(200,"请求成功",userArrayList,total);
    }


    /**
     * 模糊查询得到用户
     * @param pageParameter
     * @return
     */
    @Override
    public ApiResponse searchUser(PageParameter pageParameter) {
        //得到  分页信息(页面大小,起始页,总页数)
        //得到起始页
        int currPage=(pageParameter.getCurrPage()-1)*pageParameter.getPageSize();
        ArrayList<User> arrayList=userDao.searchUser(currPage,pageParameter.getPageSize(),pageParameter.getSearchParameter());
        int total=userDao.searchUseTotal(pageParameter.getSearchParameter())/pageParameter.getPageSize();
        return new ApiResponse(200,"请求成功",arrayList,total);
    }

    /**
     * 通过用户id  删除用户
     * @param userVo
     * @return
     */
    @Override
    public ApiResponse deleteUserById(UserVo userVo) {
        Integer i=userDao.deleteUserById(userVo.getUserId());
        return i==1?new ApiResponse(200,"删除成功"):new ApiResponse(502,"删除失败");
    }

    /**
     * 通过userId 修改用户
     * @param user
     * @return
     */
    @Override
    public ApiResponse modifyUserById(User user) {
        Integer i= userDao.modifyUserById(user);
        return i==1?new ApiResponse(200,"修改成功"):new ApiResponse(502,"修改失败");
    }

    /**
     * 导出用户
     * @return
     */
    @Override
    public ApiResponse downloadUser() {
        FileOutputStream fileOutputStream =null;
        ByteArrayOutputStream outputStream=new ByteArrayOutputStream();
        HttpHeaders headers=new HttpHeaders();
        try{
            fileOutputStream=new FileOutputStream("H:\\File\\user.xlsx");
            fileOutputStream.write(outputStream.toByteArray());
            headers.setContentDispositionFormData("attachment", new String("user.xls".getBytes("UTF-8"),"ISO-8859-1"));
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return new ApiResponse(200,"yes", HttpStatus.CREATED);
    }

    /**
     * 注册
     * @param user
     * @return
     */
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
