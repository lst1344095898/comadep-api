package com.lst.comadep.utils;

import java.util.Date;
import java.util.LinkedList;
import java.util.Random;

public class InitParam {

//    private String userName="3";
//    private String password;
//    private String address;
//    private String telephoneNumber;
    private String sex="男";
//    private int age;
//    private Date createTime;
//    private Date gmtModified;
//    private int buildingNumber;
//    private String floor;
    //随机获取名字
    //首先创建姓名氏数组
    private StringPackage stringPackage=new StringPackage();
    private String[] firstNameList=stringPackage.getFirstNameList();
    private String[] secondNameListMen=stringPackage.getSecondNameListMen();
    private String[] secondNameListWomen=stringPackage.getSecondNameListWomen();
    private String[] thirdNameListMen=stringPackage.getThirdNameListMen();
    private String[] thirdNameListWomen=stringPackage.getThirdNameListWomen();
    public String getUserName() {
        this.sex="男";
        //userName第一个姓随机出来
        Random random=new Random();
        StringBuffer userNameTemp= new StringBuffer(firstNameList[random.nextInt(firstNameList.length)]);
        //判断名字是否只有第二个字
        if (random.nextInt(3)==0){
            //判断是否为女生
            if (random.nextInt(2)==0){
                this.sex="女";
                userNameTemp.append(secondNameListWomen[random.nextInt(secondNameListWomen.length)]);
            }else{
                userNameTemp.append(secondNameListMen[random.nextInt(secondNameListMen.length)]);
            }
            return userNameTemp.toString();
        }else{

            //判断女生
            if (random.nextInt(2)==0){
                this.sex="女";
                userNameTemp.append(secondNameListWomen[random.nextInt(secondNameListWomen.length)]);
                userNameTemp.append(thirdNameListWomen[random.nextInt(thirdNameListWomen.length)]);
            }else{
                userNameTemp.append(secondNameListMen[random.nextInt(secondNameListMen.length)]);
                userNameTemp.append(thirdNameListMen[random.nextInt(thirdNameListMen.length)]);
            }
        }
        return userNameTemp.toString();
    }
    //得到密码
    public String getPassword() {
        return "123456";
    }
    //得到地址
    public String getAddress() {
        return "翻斗小区";
    }
    //得到电话号码
    //得到已经有的号码
    private static LinkedList<String> linkedList=new LinkedList<>();

    String[] telephoneHeard= stringPackage.telephoneHeard;
    public String getTelephoneNumber() {
        linkedList.add("head");
        //编写电话号码头
        Random random=new Random();
        StringBuffer telephoneNumber=new StringBuffer(telephoneHeard[random.nextInt(telephoneHeard.length)]);
        String tempString=Integer.toString(random.nextInt(89999999)+10000000);
        //判断是否有这个值
        while (linkedList.contains(tempString)){
            tempString=Integer.toString(random.nextInt(89999999)+10000000);
        }
        linkedList.add(tempString);
        return telephoneNumber.append(tempString).toString();
    }
    //得到性别

    public String getSex() {
        return this.sex;
    }
    //得到年纪
    public int getAge(){
        Random random=new Random();
        int temp= random.nextInt(3);
        if (temp==0){
            return random.nextInt(10)+10;
        }else if (temp==1){
            return  random.nextInt(30)+20;
        }else{
            return random.nextInt(40)+50;
        }
    }
    //得到楼号
    //一共10栋楼，每栋20层，一层8户人，一户3人，
    //楼组 每楼20*8*3=480人
    private int[] BuildingNumberList={0,0,0,0,0,0,0,0,0,0,0};
    //每层 8 户每户3人
    public String getBuildingNumberAndFloor(){
        //顺序分配房子
        int buildingNumber=0;
        int temp;
        String floor="";
        for (int i=1;i<11;i++){
            if (this.BuildingNumberList[i]<480){
                buildingNumber=i;
                this.BuildingNumberList[i]=this.BuildingNumberList[i]+1;
                //剩下的人/3余的数+1；
                //200/20=10
                temp=this.BuildingNumberList[i];
                //找到在第几层如果200
                //找到在第几户
                floor=Integer.toString(temp/24+1)+"0"+Integer.toString(((temp%24)/3)+1);
                break;
            }

        }
        return Integer.toString(buildingNumber)+","+floor;
    }

}
