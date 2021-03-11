package com.lst.comadep.Dao;

import com.lst.comadep.Entity.MapInfo;
import com.lst.comadep.Entity.OutInInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;

@Mapper
@Repository
public interface MapDao {
    ArrayList<MapInfo> getMap();
    ArrayList<OutInInfo> getAccessFrequencyLocal(@Param("building_number") int building_number, @Param("newYear") int  newYear,@Param("newMonth") int newMonth );
    ArrayList<OutInInfo> getAccessFrequencyOot(@Param("building_number") int building_number, @Param("newYear") int  newYear,@Param("newMonth") int newMonth );

}
