package com.lst.comadep.Dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ViewDataDao {
    Integer getBabyNumber(@Param("buildNumber") Integer buildNumber);
    Integer getJuvenileNumber(@Param("buildNumber") Integer buildNumber);
    Integer getYouthNumber(@Param("buildNumber") Integer buildNumber);
    Integer getAdultNumber(@Param("buildNumber") Integer buildNumber);
    Integer getElderlyNumber(@Param("buildNumber") Integer buildNumber);
}
