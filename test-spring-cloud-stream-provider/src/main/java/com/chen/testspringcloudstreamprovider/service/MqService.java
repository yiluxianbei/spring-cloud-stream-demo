package com.chen.testspringcloudstreamprovider.service;

import com.chen.testspringcloudstreamprovider.channel.MySource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import java.util.UUID;
@EnableBinding(MySource.class)
public class MqService {
    @Autowired
    private MessageChannel myProducer; // 消息发送管道

    @Autowired
    private MessageChannel mydelayedProducer;// 消息发送管道（延时消息）

    public boolean send()
    {
        String serial = UUID.randomUUID().toString();
        boolean send = myProducer.send(MessageBuilder.withPayload(serial).build());
        System.out.println("*****serial: "+serial);
        return send;
    }

    /**
     * 测试延时消息
     * @return
     */
    public boolean delayed(){
        String serial = UUID.randomUUID().toString();
        return mydelayedProducer.send(MessageBuilder.withPayload(serial).setHeader("x-delay",3000).build());
    }
}
