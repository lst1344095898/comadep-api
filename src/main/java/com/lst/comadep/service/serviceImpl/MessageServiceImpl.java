package com.lst.comadep.service.serviceImpl;

import com.lst.comadep.Dao.MessageDao;
import com.lst.comadep.Entity.ApiResponse;
import com.lst.comadep.Entity.Bo.MessageListBo;
import com.lst.comadep.Entity.Po.MessagePo;
import com.lst.comadep.Entity.Po.SessionRecordPo;
import com.lst.comadep.Entity.Vo.MessageVo;
import com.lst.comadep.Entity.Vo.NoticeVo;
import com.lst.comadep.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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

    /**
     * 发送消息
     * @param messageVo
     * @return
     */
    @Override
    public ApiResponse sendMessage(MessageVo messageVo) {
        //得到当前时间
        messageVo.setSendTime(new Date());
        int temp=messageDao.sendMessage(messageVo);
        //插入数据
        if (temp!=1){
            return ApiResponse.error("消息发送失败");
        }else{
            //返回查询数据
            System.out.println(messageVo);
            return ApiResponse.ok("查询成功", messageVo);
        }
    }

    /**
     * 得到消息列表
     * @param messageVo
     * @return
     */
    @Override
    public ApiResponse getMessageListByUserId(MessageVo messageVo) {
        //得到关于userid 的所有会话记录
        List<SessionRecordPo> list=messageDao.getMessageListByUserId(messageVo.getUserId());
        //将数据处理为MessageListBo;
        //遍历会话记录
        for (SessionRecordPo sessionRecordPo:
             list) {
            SessionRecordPo sessionRecordPo2=sessionRecordPo;
            if (sessionRecordPo2.getSenderId().equals(messageVo.getUserId())){
                //如果发送者id=查询id;
                //发送者=接收者
                sessionRecordPo2.setSenderId(sessionRecordPo2.getSenderId());
                sessionRecordPo2.setSender(sessionRecordPo2.getSender());
            }else{
                //接收者=发送者
                sessionRecordPo2.setRecipient(sessionRecordPo2.getRecipient());
                sessionRecordPo2.setRecipientId(sessionRecordPo2.getRecipientId());
            }
        }
        List<SessionRecordPo> ls =list.stream().filter(distinctByKey(SessionRecordPo::getSenderId)).collect(Collectors.toList());
        List<MessageListBo> listBos=new ArrayList<>();
        for (SessionRecordPo s :
                ls) {
            MessageListBo messageListBo=new MessageListBo();
            messageListBo.setUserId(s.getSenderId());
            messageListBo.setUserName(s.getSender());
            messageListBo.setLastMessage("我等你的消息");
            listBos.add(messageListBo);
        }
        if (listBos.isEmpty()){
            return ApiResponse.error("你还没有收到过消息");
        }
        return ApiResponse.ok("成功",listBos);
    }

    /**
     * 得到对话消息
     * @param messageVo
     * @return
     */
    @Override
    public ApiResponse getMessageById(MessageVo messageVo) {
        List<MessagePo> list=messageDao.getMessageById(messageVo.getSenderId(),messageVo.getRecipientId());

        return null;
    }

    private static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Map<Object, Boolean> seen = new ConcurrentHashMap<>();
        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }
}
