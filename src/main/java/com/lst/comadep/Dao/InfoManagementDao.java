package com.lst.comadep.Dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

@Mapper
public interface InfoManagementDao {
    int  InputOutInfoById(@Param("userId") int userId,@Param("eventType") String eventType, @Param("outTime") Date outTime, @Param("actionRegion") String actionRegion,
                          @Param("estimateTime")Date estimateTime, @Param("eventDescription") String eventDescription, @Param("outAddress") String outAddress);
    int intoByUserId(@Param("userId")int userId,@Param("inTime") Date inTime,@Param("inAddress") String inAddress);
    //插入模拟数据
    int inputManyDate(@Param("userId") int userId,@Param("outAddress") String outAddress,@Param("outTime") Date outTime,
                          @Param("inAddress") String inAddress,@Param("inTime") Date inTime,
                          @Param("eventType") String eventType,@Param("eventDescription") String eventDescription,@Param("actionRegion") String actionRegion,
                          @Param("estimateTime")Date estimateTime);
}
