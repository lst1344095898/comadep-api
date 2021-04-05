package com.lst.comadep.service;

import com.lst.comadep.Entity.ApiResponse;
import com.lst.comadep.Entity.Vo.MessageVo;
import com.lst.comadep.Entity.Vo.NoticeVo;

public interface MessageService {
    ApiResponse sendNotice(NoticeVo noticeVo);
    ApiResponse sendMessage(MessageVo messageVo);
}
