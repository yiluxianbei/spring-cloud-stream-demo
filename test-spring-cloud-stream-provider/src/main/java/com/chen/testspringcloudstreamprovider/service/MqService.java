package com.chen.testspringcloudstreamprovider.service;

import com.chen.testspringcloudstreamprovider.channel.MySource;
import com.chen.testspringcloudstreamprovider.pojo.PayLoad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import java.util.UUID;
@EnableBinding(MySource.class)
public class MqService {

    @Autowired
    private MySource mySource;


    public boolean send() {
        PayLoad payLoad = new PayLoad(UUID.randomUUID().toString());
        boolean send = mySource.myoutput().send(MessageBuilder.withPayload(payLoad).build());
        System.out.println("*****: "+payLoad);
        return send;
    }

    /**
     * 测试延时消息
     * @return
     */
    public boolean delayed(){
        String serial = UUID.randomUUID().toString();
        return mySource.mydelayedProducer().send(MessageBuilder.withPayload(serial).setHeader("x-delay",3000).build());
    }

}
