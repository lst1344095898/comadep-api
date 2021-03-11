package com.lst.comadep.Dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface TestDao {
    int inputMapDate(@Param("id") int id, @Param("buildingWidth") int buildingWidth, @Param("buildingLength")int buildingLength, @Param("buildingHeight") int buildingHeight);
}
