package com.lst.comadep.service.serviceImpl;

import com.lst.comadep.Dao.MessageDao;
import com.lst.comadep.Entity.ApiResponse;
import com.lst.comadep.Entity.Vo.NoticeVo;
import com.lst.comadep.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageDao messageDao;
    /**
     * 发送通知
     * @param noticeVo
     * @return
     */
    @Override
    public ApiResponse sendNotice(NoticeVo noticeVo) {
        //得到当前时间
        noticeVo.setNoticeDate(new Date());
        //插入数据
        int temp= messageDao.sendNotice(noticeVo);
        if (temp ==1){
            return ApiResponse.ok("发送成功");
        }
        return ApiResponse.error("发送失败");
    }
}
