package com.lst.comadep.Dao;

import com.lst.comadep.Entity.Bo.MessageListBo;
import com.lst.comadep.Entity.Po.MessagePo;
import com.lst.comadep.Entity.Po.SessionRecordPo;
import com.lst.comadep.Entity.Vo.MessageVo;
import com.lst.comadep.Entity.Vo.NoticeVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MessageDao {
    int sendNotice(@Param("noticeVo") NoticeVo noticeVo);
    int sendMessage(@Param("messageVo") MessageVo messageVo);
    List<SessionRecordPo> getMessageListByUserId(@Param("userId") Integer userId);
    List<MessagePo> getMessageById(@Param("senderId") Integer senderId,@Param("recipientId") Integer recipientId);
}
