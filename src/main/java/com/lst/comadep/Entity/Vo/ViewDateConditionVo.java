package com.lst.comadep.Entity.Vo;

import java.util.Date;

/**
 * 评论条件接收实体
 * selectedTime 选中时间
 * buildingNumber 楼号
 */
public class ViewDateConditionVo {
    private Date selectedTime;

    private Integer buildingNumber;

    public Date getSelectedTime() {
        return selectedTime;
    }

    public void setSelectedTime(Date selectedTime) {
        this.selectedTime = selectedTime;
    }

    public Integer getBuildingNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(Integer buildingNumber) {
        this.buildingNumber = buildingNumber;
    }
}
