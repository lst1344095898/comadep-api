package com.lst.comadep.Entity;

import java.util.Date;

public class OutInInfo {
        private int id; //时间id
        private int userId;//用户id
        private String outAddress; //出门地点
        private Date outTime; //出去时间
        private String  inAddress;//进来地点
        private Date inTime;//进来时间
        private Date estimateTime; //预计进来时间
        private String eventType;//事务类型
        private String eventDescription; //事件描述
        private String actionRegion; //活动范围

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getOutAddress() {
        return outAddress;
    }

    public void setOutAddress(String outAddress) {
        this.outAddress = outAddress;
    }

    public Date getOutTime() {
        return outTime;
    }

    public void setOutTime(Date outTime) {
        this.outTime = outTime;
    }

    public String getInAddress() {
        return inAddress;
    }

    public void setInAddress(String inAddress) {
        this.inAddress = inAddress;
    }

    public Date getInTime() {
        return inTime;
    }

    public void setInTime(Date inTime) {
        this.inTime = inTime;
    }

    public Date getEstimateTime() {
        return estimateTime;
    }

    public void setEstimateTime(Date estimateTime) {
        this.estimateTime = estimateTime;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public String getActionRegion() {
        return actionRegion;
    }

    public void setActionRegion(String actionRegion) {
        this.actionRegion = actionRegion;
    }

    @Override
    public String toString() {
        return "OutInInfo{" +
                "id=" + id +
                ", userId=" + userId +
                ", outAddress='" + outAddress + '\'' +
                ", outTime=" + outTime +
                ", inAddress='" + inAddress + '\'' +
                ", inTime=" + inTime +
                ", estimateTime=" + estimateTime +
                ", eventType=" + eventType +
                ", eventDescription='" + eventDescription + '\'' +
                ", actionRegion='" + actionRegion + '\'' +
                '}';
    }
}
