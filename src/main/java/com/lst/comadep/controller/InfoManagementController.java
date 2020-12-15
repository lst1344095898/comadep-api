package com.lst.comadep.controller;

import com.lst.comadep.Entity.ApiResponse;
import com.lst.comadep.Entity.OutInInfo;
import com.lst.comadep.Entity.Vo.OutInInfoVo;
import com.lst.comadep.Entity.Vo.UserVo;
import com.lst.comadep.service.InfoManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/infoManagement")
public class InfoManagementController {
    private  final InfoManagementService infoManagementService;
    @Autowired
    public InfoManagementController(InfoManagementService infoManagementService) {
        this.infoManagementService = infoManagementService;
    }
    @PostMapping("/InputOutInfoById")
    public ApiResponse InputOutInfoById(@RequestBody OutInInfo outInInfo){
        outInInfo.setOutAddress("东门");
        outInInfo.setOutTime(new Date());
        System.out.println(outInInfo);
        ApiResponse apiResponse= infoManagementService.InputOutInfoById(outInInfo);
        return apiResponse;
//        return new ApiResponse(200,"Yes");
    }
    @PostMapping("/intoByUserId")
    public ApiResponse intoByUserId(@RequestBody OutInInfoVo outInInfoVo){
        outInInfoVo.setInAddress("东门");
        ApiResponse apiResponse=infoManagementService.intoByUserId(outInInfoVo);
        return  apiResponse;
    }

}
