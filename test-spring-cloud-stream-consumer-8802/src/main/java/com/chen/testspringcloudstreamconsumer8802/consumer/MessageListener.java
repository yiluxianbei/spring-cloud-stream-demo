package com.chen.testspringcloudstreamconsumer8802.consumer;

import com.chen.testspringcloudstreamconsumer8802.channel.MySink;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;

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
