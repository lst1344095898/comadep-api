package com.lst.comadep.Entity;

import lombok.Data;

/**
 * netty接收实体
 */
@Data
public class MsgData {

    private Integer id;

    private String message;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
