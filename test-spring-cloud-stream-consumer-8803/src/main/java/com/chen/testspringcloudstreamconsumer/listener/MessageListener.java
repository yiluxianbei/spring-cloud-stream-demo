package com.chen.testspringcloudstreamconsumer.listener;

import com.chen.testspringcloudstreamconsumer.channel.MySink;
import com.chen.testspringcloudstreamconsumer.pojo.MyPayLoad;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.support.GenericMessage;

@EnableBinding(MySink.class)
public class MessageListener {

	//监听通道消息,接收到消息后处理业务逻辑如果有异常，会重新调此方法（默认最多执行3次）
	@StreamListener(MySink.MY_CONSUMER)//这里配置的是要监听的消息通道（消费通道）
	public void input(GenericMessage<MyPayLoad> message) {
		System.out.println("获取到消息: "+message.getPayload());
		throw new RuntimeException("123");
	}

	//监听通道消息(测试延时消息)
	@StreamListener(MySink.MY_DELAYED_CONSUMER)//这里配置的是要监听的消息通道（消费通道）
	public void mydelayed(GenericMessage message) {
		System.out.println("获取到消息: "+message.getPayload());
	}
}
