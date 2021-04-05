package com.lst.comadep.Entity;

import io.netty.channel.Channel;

import java.util.HashMap;
import java.util.Map;

/**
  * @Classname ChannelRelMap
  * @Description 全局Map，用于存channel与唯一ID绑定
 */
public class ChannelRelMap {
    private static Map<String, Channel> manager = new HashMap<String, Channel>();

    public static void put(String senderId, Channel channel) {
        manager.put(senderId, channel);
    }

    public static Channel get(String senderId) {
        return manager.get(senderId);
    }

    public static void print() {
        for (HashMap.Entry<String, Channel> entry : manager.entrySet()) {
            System.out.println("Id: " + entry.getKey()
                    + ", ChannelId: " + entry.getValue().id().asLongText());
        }
    }
}
