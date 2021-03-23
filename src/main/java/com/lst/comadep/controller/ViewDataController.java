package com.lst.comadep.controller;

import com.lst.comadep.Entity.ApiResponse;
import com.lst.comadep.Entity.Vo.ViewDateConditionVo;
import com.lst.comadep.service.ViewDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 视图数据Controller
 */
@Controller
@RequestMapping("viewData")
public class ViewDataController {
    @Autowired
    private ViewDataService viewDataService;

    /**
     * 获得年纪分类数据 根据楼号
     * @param viewDateConditionVo
     * @return
     */
    @PostMapping("/getAgeView")
    @ResponseBody
    public ApiResponse getAgeView(@RequestBody ViewDateConditionVo viewDateConditionVo){
        return viewDataService.getAgeView(viewDateConditionVo);
    }

}
