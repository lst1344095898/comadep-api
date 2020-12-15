package com.lst.comadep.controller;

import com.lst.comadep.Dao.InfoManagementDao;
import com.lst.comadep.Dao.UserDao;
import com.lst.comadep.Entity.ApiResponse;
import com.lst.comadep.Entity.OutInInfo;
import com.lst.comadep.Entity.User;
import com.lst.comadep.Entity.Vo.TestDao;
import com.lst.comadep.service.UserService;
//import com.lst.comadep.utils.RedisUtil;
import com.lst.comadep.utils.InitParam;
import com.lst.comadep.utils.MD5Utils;
import com.lst.comadep.utils.RandomData.AccessInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Map;

@RestController
public class TestController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserDao userDao;
    @Autowired
    private InfoManagementDao infoManagementDao;
//    @Autowired
//    private RedisUtil redisUtil;
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
    //多线程填入用户数据
    @GetMapping("/getManyDate")
    @ResponseBody
    public void getManyDate() {
        int id;
        String userName;
        String password;
        String address;
        String telephoneNumber;
        String sex;
        int age;
        Date createTime;
        Date gmtModified;
        int buildingNumber;
        String floor;
        //开始单线程插入
        InitParam initParam = new InitParam();
        for (int i = 0; i < 4800; i++) {
            String[] temp = initParam.getBuildingNumberAndFloor().split(",");
            if (userDao.importUser(initParam.getUserName(), initParam.getPassword(), initParam.getAddress(), initParam.getTelephoneNumber(),
                    initParam.getSex(), initParam.getAge(), new Date(), new Date(), Integer.parseInt(temp[0]), temp[1]) == 0) {
                System.out.println("插入失败");
                break;
            }
        }
    }
    //根据id将数据注册;
    @GetMapping("/getManyDate2")
    @ResponseBody
    public void getManyDate2() {
        //通过id得到信息
        //

            User user=userDao.selectUserByIdInOriginal(1);
            //将数据注册
            System.out.println(user);
            ApiResponse apiResponse=userService.register(user);

    }
    //导入用户出入信息;
    @GetMapping("/getManyDate3")
    @ResponseBody
    public void getManyDate3() {
        //通过用户id顺序插入
        //先根据一栋楼进行导入
        //遍历用户id
        AccessInformation accessInformation=new AccessInformation();
        OutInInfo out=new OutInInfo();
        for (int i=2; i<481;i++){
            //遍历这2个月
            for (int j=0; j<59;j++){
                //填入数据
                out.setUserId(i);
                out.setEventType(accessInformation.getEventType());
                out.setOutAddress(accessInformation.getOutAddress());
                if (out.getEventType().equals("上班")){
                    out.setOutTime(accessInformation.getWorkOutTime(j));
                    out.setInTime(accessInformation.getWorkIntTime(j));
                } else {
                    out.setOutTime(accessInformation.getOtherOutTime(j));
                    out.setInTime(accessInformation.getOtherInTime(j));
                }
                out.setInAddress(accessInformation.getInAddress());
                out.setEventType(accessInformation.getEventType());
                out.setActionRegion(accessInformation.getActionRegion());
                out.setEstimateTime(accessInformation.getEstimateTime());
                if (infoManagementDao.inputManyDate(out.getUserId(),out.getOutAddress(),out.getOutTime(),out.getInAddress(),out.getInTime(),
                        out.getEventType(),out.getEventDescription(),out.getActionRegion(),out.getEstimateTime())==0){
                    System.out.println("出错了");
                    break;
                }

            }
            System.out.println("第"+i+"个用户");
        }
    }

    public User getUserById(int id){
        System.out.println("触发getUserById");
        return userService.selectUserById(id);
    }
//    @GetMapping("redis")
//    public ApiResponse setRedis(){
//        TestDao<Integer> testDao=new TestDao();
//        testDao.setTestName("123");
//        testDao.setNumber(123);
//        redisUtil.set("redisTestKey","test01");
//        return  new ApiResponse(200,"看结果",redisUtil.get("redisTestKey"));
//    }
}
