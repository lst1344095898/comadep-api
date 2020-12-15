package com.lst.comadep.service;

import com.lst.comadep.Entity.ApiResponse;
import com.lst.comadep.Entity.OutInInfo;
import com.lst.comadep.Entity.Vo.OutInInfoVo;
import com.lst.comadep.Entity.Vo.UserVo;

public interface InfoManagementService {
    ApiResponse InputOutInfoById(OutInInfo outInInfo);
    ApiResponse intoByUserId (OutInInfoVo outInInfoVo);
}
