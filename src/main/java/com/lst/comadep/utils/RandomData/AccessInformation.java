package com.lst.comadep.utils.RandomData;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class AccessInformation {
    //起始时间
    private static  final long NEW_TIME=1609430400453L;
    //
    private static String[] address={"东门","西门","南门","北门"};
    //得到估计时间
    private long EstimateTime=0;
    private int OutInput=0;
    //买东西出门时间
    private int OutOther=0;
    public String getOutAddress(){
        Random random=new Random();
        int temp=random.nextInt(4);
        this.OutInput=temp;
        return address[temp];
    }
    //进门
    public String getInAddress(){
        Random random=new Random();
        if (random.nextInt(6)==2){
            return address[random.nextInt(4)];
        }
        return address[this.OutInput];

    }
    //上班
    public Date getWorkOutTime(int day) {
        long dayTime=86400000L;
        long hour=3600000L;
        long min=60000L;
        int x=day;
        Random random=new Random();
        //得到时间
        //时间换算
        //一天==86400000 毫秒
        //我们先得到起始时间比如2021年1月1日;
        //先把时间加到2021年1月1日;
        //一天的时间是86400000//一个小时3600000//一分钟60000;
        //根据不同的类型得到时间规范【上班,买菜,吃饭】
        //随机出早上出门时间6-8//21600000-28800000;
        //0加6-8
        //得到当前日期从什么1-1开始算
        //随机到今天出门的时间
        //
        Date date=new Date(NEW_TIME+ x*dayTime+21600000L+hour*random.nextInt(2)
                +min*random.nextInt(60));//起始时间+今天到起始时间的天数+每天上班的起始时间+随机到的小时+随机到的分钟
        System.out.println("出门时间"+getStringDate(date));
        return date;
    }

    //下班
    public Date getWorkIntTime(int day) {
        long dayTime=86400000L;
        long hour=3600000L;
        long min=60000L;
        int x=day;
        Random random=new Random();
        long temp=NEW_TIME+ x*dayTime+64800000+hour*random.nextInt(3)
                +min*random.nextInt(60);
        Date date=new Date(temp);//起始时间+今天到起始时间的天数+每天下班的起始时间6点+随机到的小时+随机到的分钟
        this.EstimateTime=temp;
        System.out.println("出门时间"+getStringDate(date));
        return date;
    }
    //买东西or吃饭出去
    public Date getOtherOutTime(int day) {
        //买东西随机时间是6-22;
        long dayTime=86400000L;//one day
        long hour=3600000L;//1 hour
        long min=60000L;//1 min
        int x=day;//3day
        Random random=new Random();
        this.OutOther=random.nextInt(16);
        Date date=new Date(NEW_TIME + x*dayTime+ 21600000L+ hour*this.OutOther
                +min*random.nextInt(60));
        System.out.println("出门时间"+getStringDate(date));
        return date;
    }
    //买东西or吃饭回来
    public Date getOtherInTime(int day) {
        //买东西随机时间是6-22;
        long dayTime=86400000L;//one day
        long hour=3600000L;//1 hour
        long min=60000L;//1 min
        int x=day;//3day
        //如果22点出门, 回来的小时是/18-16=2
        Random random=new Random();
        //回来的小时应该是//一共时间-我记录的时间//18-this.OutOther/然后随机个数
        long temp=NEW_TIME + x*dayTime+ 21600000L+ hour*this.OutOther+hour*(random.nextInt(18-this.OutOther))
                +min*random.nextInt(60);
        Date date=new Date(temp);
        System.out.println("进门时间"+getStringDate(date));
        this.EstimateTime=temp;
        return date;
    }
    public String getStringDate(Date date){
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(date);
    }
    private static String[] EventTypeList={"上班","吃饭","买菜"};
    //得到事件类型
    public String getEventType(){
        Random random=new Random();
        return EventTypeList[random.nextInt(EventTypeList.length)];
    }
    //事件地点
    private static String[] ActionRegionList={"中山区","西岗区","沙河口区","甘井子区","旅顺区"};
    public String getActionRegion(){
        Random random=new Random();
        return ActionRegionList[random.nextInt(ActionRegionList.length)];
    }
    //得到估计时间
    public Date getEstimateTime(){
        return new Date(this.EstimateTime);
    }
}
