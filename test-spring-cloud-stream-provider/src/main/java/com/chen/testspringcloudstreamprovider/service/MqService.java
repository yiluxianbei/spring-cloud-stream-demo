package com.chen.testspringcloudstreamprovider.service;

import com.chen.testspringcloudstreamprovider.channel.MyProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import java.util.UUID;
@EnableBinding(MyProcessor.class)
//@EnableBinding(Source.class)
public class MqService {
    @Autowired
    private MessageChannel myoutput; // 消息发送管道
//    @Autowired
//    private MessageChannel output;
    public String send()
    {
        String serial = UUID.randomUUID().toString();
        myoutput.send(MessageBuilder.withPayload(serial).build());
        System.out.println("*****serial: "+serial);
        return serial;
    }
}
