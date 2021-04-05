package com.lst.comadep.Dao;

import com.lst.comadep.Entity.Vo.MessageVo;
import com.lst.comadep.Entity.Vo.NoticeVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MessageDao {
    int sendNotice(@Param("noticeVo") NoticeVo noticeVo);
    int sendMessage(@Param("messageVo") MessageVo messageVo);
}
