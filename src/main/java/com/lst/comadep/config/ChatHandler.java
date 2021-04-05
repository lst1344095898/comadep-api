package com.lst.comadep.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lst.comadep.Entity.ChannelRelMap;
import com.lst.comadep.Entity.MsgData;
import com.lst.comadep.Entity.Vo.MessageVo;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.util.concurrent.GlobalEventExecutor;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;

/**
 * 聊天
 */
public class ChatHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {

    //用于记录和管理所有客户端的channel
    private static ChannelGroup clients =
            new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
    @Override
    protected void messageReceived(ChannelHandlerContext channelHandlerContext, TextWebSocketFrame textWebSocketFrame) throws Exception {
        //得到客户端数据
        String msg = textWebSocketFrame.text();
        //将消息序列化
        MessageVo messageVo = JSONObject.parseObject(msg, MessageVo.class);
        //判断消息类型
        if (messageVo.getMessageType().equals("82526")){
            /**
             * 第一次发消息 用userId  注册信息id;
             */
            //将消息保存
            System.out.println(messageVo.getSenderId());
            registerMessageIdByUserName(messageVo.getSenderId(),channelHandlerContext.channel());
        }else{
            //根据id找到接收者
            Channel receiverChannel = ChannelRelMap.get(messageVo.getRecipientId());
            //根据id找到接收者
            Channel findChannel = clients.find(receiverChannel.id());
            String json=JSON.toJSONString(messageVo);
            if (findChannel != null) {
                //发送数据到客户端
                findChannel.writeAndFlush(new TextWebSocketFrame(json));
            }
        }

    }
    //客户端创建的时候触发，当客户端连接上服务端之后，就可以获取该channel，然后放到channelGroup中进行统一管理
    @Override
    public void handlerAdded(ChannelHandlerContext channelHandlerContext) throws Exception {
        System.out.println("客户端连接,当前id是channel"+channelHandlerContext.channel().id().asShortText());
        clients.add(channelHandlerContext.channel());
    }
    //客户端销毁的时候触发，
    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        //当handlerRemoved 被触发时候，channelGroup会自动移除对应的channel
        //clients.remove(ctx.channel());
        System.out.println("客户端断开，当前被移除的channel的短ID是：" +ctx.channel().id().asShortText());
    }
    private void registerMessageIdByUserName(Integer senderId,Channel channel){
        ChannelRelMap.put(senderId, channel);
    }


}
