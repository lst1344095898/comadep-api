package com.lst.comadep.service;

import com.lst.comadep.Entity.ApiResponse;
import com.lst.comadep.Entity.Vo.ViewDateConditionVo;

public interface MapService {
    ApiResponse getMap();
    ApiResponse getAccessFrequencyLocal(ViewDateConditionVo viewDateConditionVo);
    ApiResponse getAccessFrequencyOot(ViewDateConditionVo viewDateConditionVo);
    ApiResponse InOutFrequencyByLocal(int month);
}
