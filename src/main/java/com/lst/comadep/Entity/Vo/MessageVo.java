package com.lst.comadep.Entity.Vo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 信息消息 接收参数实体
 * @Create by lst
 * @Date 2021-4-3
 */
@Data
public class MessageVo {
    //发送者信号id
    private String senderMessageId;
    //接收者信号id(暂时需要废弃)
    private String receiveMessageId;
    private String messageType;
    private Integer nettyId ;
    private String sender;
    private String messageContent;
    private String recipient;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date sendTime;
}
