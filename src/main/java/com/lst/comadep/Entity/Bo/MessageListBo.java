package com.lst.comadep.Entity.Bo;

import lombok.Data;

/**
 * 消息列表返回实体
 */
@Data
public class MessageListBo {
    private Integer userId;
    private String userName;
    private String lastMessage;
}
