package com.chen.testspringcloudstreamconsumer8803.consumer;

import com.chen.testspringcloudstreamconsumer8803.channel.MySink;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.SubscribableChannel;

import java.io.IOException;

@EnableBinding(MySink.class)
public class MessageListener {

	//监听消息,接收到消息后处理业务逻辑如果有异常，会重新执行方法（默认最多执行3次）
	@StreamListener(MySink.MYINPUT)
	public void input(Message message) {
		System.out.println("获取到消息: "+message.getPayload());
		throw new RuntimeException("123");
	}

	//监听消息(测试延时消息)
	@StreamListener(MySink.MYDELAYDE)
	public void mydelayed(Message message) {
		System.out.println("获取到消息: "+message.getPayload());
	}

}
