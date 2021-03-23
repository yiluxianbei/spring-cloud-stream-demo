package com.chen.testspringcloudstreamprovider.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface MySource {


	/**
	 * 自定义的消息通道（生产）
	 */
	@Output("myProducer")//通道名
    MessageChannel myoutput();
	/*
	*测试延时消息通道
	 */
	@Output("mydelayedProducer")//通道名
	MessageChannel delayed();

}
