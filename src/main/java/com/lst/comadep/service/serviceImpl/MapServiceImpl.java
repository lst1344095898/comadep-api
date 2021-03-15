package com.lst.comadep.service.serviceImpl;

import com.lst.comadep.Dao.MapDao;
import com.lst.comadep.Entity.ApiResponse;
import com.lst.comadep.Entity.MapInfo;
import com.lst.comadep.Entity.OutInInfo;
import com.lst.comadep.service.MapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class MapServiceImpl implements MapService {
    @Autowired
    private MapDao mapDao;
    @Override
    public ApiResponse getMap() {
        ArrayList<MapInfo> mapInfoList=mapDao.getMap();
        //     System.out.println(mapInfoList);
        return new ApiResponse(200,"Yes",mapInfoList);
    }

    /**
     * 得到本月本地出入频率
     * 有很多相似代码后期需要维护
     * @return
     */
    @Override
    public ApiResponse getAccessFrequencyLocal() {

        //从数据库中得到当前月不同楼出入消息条数/总人数
        //当前月
        Calendar dateTemp=Calendar.getInstance();
        System.out.println(dateTemp);
        double[] arr=new double[10];
        for (int i=1;i<=10;i++){
            ArrayList<OutInInfo> outInInfoArrayList=mapDao.getAccessFrequencyLocal(i,dateTemp.get(Calendar.YEAR),dateTemp.get(Calendar.MONTH)+1);
            arr[i-1]=outInInfoArrayList.size()/488.0/30.0;
            System.out.println("第"+(i+1)+"楼"+outInInfoArrayList.size());
        }
        System.out.println(arr[2]);
        return new ApiResponse(200,"得到频率",arr);
    }

    @Override
    public ApiResponse getAccessFrequencyOot() {
        //从数据库中得到当前月不同楼出入消息条数/总人数
        //当前月
        Calendar dateTemp=Calendar.getInstance();
        double[] arr=new double[10];
        for (int i=1;i<=10;i++){
            ArrayList<OutInInfo> outInInfoArrayList=mapDao.getAccessFrequencyOot(i,dateTemp.get(Calendar.YEAR),dateTemp.get(Calendar.MONTH)+1);
            arr[i-1]=outInInfoArrayList.size()/488.0/30.0;
            System.out.println("第"+(i+1)+"楼"+outInInfoArrayList.size());
        }
        System.out.println(arr[2]);
        return new ApiResponse(200,"得到频率",arr);
    }

    /**
     * 得到本地出入频率
     * @return
     */
    @Override
    public ApiResponse InOutFrequencyByLocal(int month) {
        //得到每楼,规定月的平均出入评论.
        //这个楼这个月一共的出入评论除以总人数/这个月的天数/
        //先得到上个月的总数据
        //
        return null;
    }
}
