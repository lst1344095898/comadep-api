package com.lst.comadep.Entity.Po;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import sun.dc.pr.PRError;

import java.util.Date;

/**
 * 对话消息查询容器
 */
@Data
public class MessagePo {
    private Long id;
    private Integer senderId;
    private String sender;
    private String messageContent;
    private Integer recipientId;
    private String recipient;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date send_time;
    private Integer isRead;
}
