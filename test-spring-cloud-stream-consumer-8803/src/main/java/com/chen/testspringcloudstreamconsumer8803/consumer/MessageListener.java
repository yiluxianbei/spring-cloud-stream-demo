package com.chen.testspringcloudstreamconsumer8803.consumer;

import com.chen.testspringcloudstreamconsumer8803.channel.MyProcessor;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

@EnableBinding(MyProcessor.class)
public class MessageListener {

	//监听binding中的消息
	@StreamListener(MyProcessor.MYINPUT)
	public void input(String message) {
		System.out.println("获取到消息: "+message);
	}

}
