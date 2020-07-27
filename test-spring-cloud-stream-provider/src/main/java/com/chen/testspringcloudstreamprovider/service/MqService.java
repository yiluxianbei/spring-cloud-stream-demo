package com.chen.testspringcloudstreamprovider.service;

import com.chen.testspringcloudstreamprovider.channel.MySource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import java.util.UUID;
@EnableBinding(MySource.class)
//@EnableBinding(Source.class)
public class MqService {
    @Autowired
    private MessageChannel myoutput; // 消息发送管道
//    @Autowired
//    private MessageChannel output;
    public boolean send()
    {
        String serial = UUID.randomUUID().toString();
        boolean send = myoutput.send(MessageBuilder.withPayload(serial).build());
        System.out.println("*****serial: "+serial);
        return send;
    }
}
