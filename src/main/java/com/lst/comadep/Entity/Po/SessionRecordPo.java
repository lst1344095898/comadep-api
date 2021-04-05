package com.lst.comadep.Entity.Po;

import lombok.Data;

@Data
public class SessionRecordPo {
    private Integer id;
    private Integer senderId;
    private String sender;
    private Integer recipientId;
    private String recipient;
    private String lastMessage;
}
