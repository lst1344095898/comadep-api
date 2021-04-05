package com.lst.comadep.controller;

import com.lst.comadep.Entity.ApiResponse;
import com.lst.comadep.Entity.Vo.MessageVo;
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
    @PostMapping("/sendNotice")
    @ResponseBody
    public ApiResponse sendNotice(@RequestBody NoticeVo noticeVo){
        return  messageService.sendNotice(noticeVo);
    }
    @PostMapping("/sendMessage")
    @ResponseBody
    public ApiResponse sendMessage(@RequestBody MessageVo messageVo){
        return messageService.sendMessage(messageVo);
    }

    /**
     * 得到用户的消息列表
     * @param messageVo
     * @return
     */
    @PostMapping("/getMessageListByUserId")
    @ResponseBody
    public ApiResponse getMessageListByUserId(@RequestBody MessageVo messageVo){
        return  messageService.getMessageListByUserId(messageVo);
    }

    /**
     * 得到当前用户与这个id 的对话
     * @param messageVo
     * @return
     */
    @PostMapping("/getMessageById")
    @ResponseBody
    public  ApiResponse getMessageById(@RequestBody MessageVo messageVo){
        return  messageService.getMessageById(messageVo);
    }
}
