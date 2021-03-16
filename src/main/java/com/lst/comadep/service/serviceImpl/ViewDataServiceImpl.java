package com.lst.comadep.service.serviceImpl;

import com.lst.comadep.Dao.MapDao;
import com.lst.comadep.Dao.ViewDataDao;
import com.lst.comadep.Entity.ApiResponse;
import com.lst.comadep.Entity.ReturnEntity.ReturnAgeEntity;
import com.lst.comadep.Entity.Vo.ViewDateConditionVo;
import com.lst.comadep.service.MapService;
import com.lst.comadep.service.ViewDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ViewDataServiceImpl implements ViewDataService {
    @Autowired
    private MapDao mapDao;
    @Autowired
    private ViewDataDao viewDataDao;

    /**
     * 获取该楼的年纪信息
     * @param viewDateConditionVo
     * @return
     */
    @Override
    public ApiResponse getAgeView(ViewDateConditionVo viewDateConditionVo) {
        Integer buildNumber=viewDateConditionVo.getBuildingNumber();
        //获取所有楼层
        //根据楼层得到年纪数据
        ReturnAgeEntity returnAgeEntity=new ReturnAgeEntity();
        returnAgeEntity.setBabyNumber(viewDataDao.getBabyNumber(buildNumber));
        returnAgeEntity.setJuvenileNumber(viewDataDao.getJuvenileNumber(buildNumber));
        returnAgeEntity.setYouthNumber(viewDataDao.getYouthNumber(buildNumber));
        returnAgeEntity.setAdultNumber(viewDataDao.getAdultNumber(buildNumber));
        returnAgeEntity.setElderlyNumber(viewDataDao.getElderlyNumber(buildNumber));
        return new ApiResponse(200,"获取成功",returnAgeEntity);
    }
}