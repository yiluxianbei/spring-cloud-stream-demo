package com.chen.testspringcloudstreamprovider.service;

import com.chen.testspringcloudstreamprovider.channel.MySource;
import com.chen.testspringcloudstreamprovider.pojo.MyPayLoad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.support.MessageBuilder;

import java.util.UUID;
@EnableBinding(MySource.class)
public class MqService {

    @Autowired
    private MySource mySource;


    public boolean send() {
        MyPayLoad myPayLoad = new MyPayLoad(UUID.randomUUID().toString());
        boolean send = mySource.myProducer().send(MessageBuilder.withPayload(myPayLoad).build());
        System.out.println("*****: "+ myPayLoad);
        return send;
    }

    /**
     * 测试延时消息
     * @return
     */
    public boolean delayed(){
        String serial = UUID.randomUUID().toString();
        return mySource.myDelayedProducer().send(MessageBuilder.withPayload(serial).setHeader("x-delay",3000).build());
    }

}
