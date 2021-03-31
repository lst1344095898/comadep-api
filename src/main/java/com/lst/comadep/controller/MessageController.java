package com.lst.comadep.controller;

import com.lst.comadep.Entity.ApiResponse;
import com.lst.comadep.Entity.Vo.NoticeVo;
import com.lst.comadep.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("message")
public class MessageController {
    @Autowired
    private MessageService messageService;
    /**
     * 发送通知消息
     * @param noticeVo
     * @return
     */
    @PostMapping("sendNotice")
    @ResponseBody
    public ApiResponse sendNotice(@RequestBody NoticeVo noticeVo){
        return  messageService.sendNotice(noticeVo);
    }
}
