package com.chen.testspringcloudstreamconsumer8802.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * 自定义的消息通道
 */
public interface MySink {

	/**
	 * 自定义的消息通道(消费)，项目启动会在rabbitmq中生成一个Queue
	 */
	@Input("myInput")//通道名
	SubscribableChannel myinput();

	//	测试延迟消息
	@Input("myDelayedInput")
	SubscribableChannel mydelayed();
}