package com.lst.comadep.Dao;

import com.lst.comadep.Entity.Vo.NoticeVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
@Mapper
public interface MessageDao {
    int sendNotice(@Param("noticeVo") NoticeVo noticeVo);
}
