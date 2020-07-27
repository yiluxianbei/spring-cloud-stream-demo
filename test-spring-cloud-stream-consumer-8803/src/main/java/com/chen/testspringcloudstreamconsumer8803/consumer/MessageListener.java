package com.chen.testspringcloudstreamconsumer8803.consumer;

import com.chen.testspringcloudstreamconsumer8803.channel.MySink;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

@EnableBinding(MySink.class)
public class MessageListener {

	//监听binding中的消息
	@StreamListener(MySink.MYINPUT)
	public void input(String message) {
		System.out.println("获取到消息: "+message);
	}

}
