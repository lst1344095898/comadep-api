package com.lst.comadep.service.serviceImpl;

import com.lst.comadep.Dao.InfoManagementDao;
import com.lst.comadep.Entity.ApiResponse;
import com.lst.comadep.Entity.OutInInfo;
import com.lst.comadep.Entity.Vo.OutInInfoVo;
import com.lst.comadep.Entity.Vo.UserVo;
import com.lst.comadep.service.InfoManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class InfoManagementServiceImpl implements InfoManagementService {
    private final InfoManagementDao infoManagementDao;
    @Autowired
    public InfoManagementServiceImpl(InfoManagementDao infoManagementDao) {
        this.infoManagementDao = infoManagementDao;
    }
    @Override
    public ApiResponse InputOutInfoById(OutInInfo outInInfo) {
        //添加消息
        if (infoManagementDao.InputOutInfoById(outInInfo.getUserId(),outInInfo.getEventType(),outInInfo.getOutTime(),outInInfo.getActionRegion(),
                outInInfo.getEstimateTime(),outInInfo.getEventDescription(),outInInfo.getOutAddress())!=0){
            //添加成功
            return new ApiResponse(200,"申请成功");
        }
        return new ApiResponse(400,"添加失败");
    }

    @Override
    public ApiResponse intoByUserId(OutInInfoVo outInInfoVo) {
        Date inTime=new Date();
        if (infoManagementDao.intoByUserId(outInInfoVo.getUserId(),inTime,outInInfoVo.getInAddress())==1){
            return new ApiResponse(200,"回家成功");
        }
        return new ApiResponse(400,"回家失败");
    }
}
