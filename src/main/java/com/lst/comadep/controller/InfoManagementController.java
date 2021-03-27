package com.lst.comadep.controller;

import com.lst.comadep.Entity.ApiResponse;
import com.lst.comadep.Entity.OutInInfo;
import com.lst.comadep.Entity.Vo.OutInInfoVo;
import com.lst.comadep.Entity.Vo.UserVo;
import com.lst.comadep.service.InfoManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/infoManagement")
public class InfoManagementController {
    private  final InfoManagementService infoManagementService;
    @Autowired
    public InfoManagementController(InfoManagementService infoManagementService) {
        this.infoManagementService = infoManagementService;
    }
    // 出门
    @PostMapping("/InputOutInfoById")
    @ResponseBody
    public ApiResponse InputOutInfoById(@RequestBody OutInInfo outInInfo){
        //        outInInfo.setOutAddress("东门");
        outInInfo.setOutTime(new Date());
        System.out.println(outInInfo);
        //        ApiResponse apiResponse= infoManagementService.InputOutInfoById(outInInfo);
        //        return apiResponse;
        return new ApiResponse(200,"Yes");
    }
    //进门
    @PostMapping("/intoByUserId")
    public ApiResponse intoByUserId(@RequestBody OutInInfoVo outInInfoVo){
        outInInfoVo.setInAddress("东门");
        ApiResponse apiResponse=infoManagementService.intoByUserId(outInInfoVo);
        return  apiResponse;
    }

}
