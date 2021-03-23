package com.chen.testspringcloudstreamconsumer8803.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface MySink {


	/**
	 * 自定义的消息通道(消费)，项目启动会在rabbitmq中生成一个Queue
	 */
	@Input("myConsumer")//通道名
    SubscribableChannel myinput();

//	测试延迟消息
	@Input("myDelayedConsumer")
	SubscribableChannel mydelayed();
}
