package com.lst.comadep.service;

import com.lst.comadep.Entity.ApiResponse;
import com.lst.comadep.Entity.Vo.ViewDateConditionVo;

public interface ViewDataService {
    ApiResponse getAgeView(ViewDateConditionVo viewDateConditionVo);
}
