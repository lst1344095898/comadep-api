package com.lst.comadep.controller;

import com.lst.comadep.Entity.ApiResponse;
import com.lst.comadep.Entity.Vo.ViewDateConditionVo;
import com.lst.comadep.service.MapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("Map")

public class MapController {
    private final MapService mapService;
    @Autowired
    public MapController(MapService mapService) {
        this.mapService = mapService;
    }

    //获取地图消息
    @PostMapping("/getMap")
    @ResponseBody
    public ApiResponse getMap(){
        return mapService.getMap();
    }

    /**
     * 获得每栋楼的出入频率根据时间(选择月)
     * @return
     */
//    @PostMapping("/InOutFrequencyByLocalByTime")
//    public ApiResponse InOutFrequencyByLocal(@RequestParam int month){
//        return  mapService.InOutFrequencyByLocal(month);
//    }

    /**
     * 得到规定月出入频率
     * @return
     */
    @PostMapping("/getAccessFrequencyLocal")
    @ResponseBody
    public ApiResponse getAccessFrequencyLocal(@RequestBody ViewDateConditionVo viewDateConditionVo){
        return mapService.getAccessFrequencyLocal(viewDateConditionVo);
    }
    /**
     * 得到外地规定月出入频率
     * @return
     */
    @PostMapping("/getAccessFrequencyOot")
    @ResponseBody
    public ApiResponse getAccessFrequencyOot(@RequestBody ViewDateConditionVo viewDateConditionVo){
        return mapService.getAccessFrequencyOot(viewDateConditionVo);
    }
}
