package com.lst.comadep.service;

import com.lst.comadep.Entity.ApiResponse;
import com.lst.comadep.Entity.Vo.NoticeVo;

public interface MessageService {
    ApiResponse sendNotice(NoticeVo noticeVo);
}
