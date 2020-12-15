package com.lst.comadep.Entity.Vo;

import java.util.Date;

public class OutInInfoVo {
    private int id;
    private int userId;//用户id
    private String  inAddress;//进来地点
    private Date inTime;//进来时间

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

    @Override
    public String toString() {
        return "OutInfoVo{" +
                "id=" + id +
                ", userId=" + userId +
                ", inAddress='" + inAddress + '\'' +
                ", inTime=" + inTime +
                '}';
    }
}
