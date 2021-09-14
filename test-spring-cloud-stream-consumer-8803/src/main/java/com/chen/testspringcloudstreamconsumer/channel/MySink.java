package com.chen.testspringcloudstreamconsumer.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface MySink {

		String MY_CONSUMER = "myConsumer";

		String MY_DELAYED_CONSUMER = "myDelayedConsumer";

	/**
	 * 自定义的消息通道(消费)，项目启动会在rabbitmq中生成一个Queue
	 */
	@Input(MySink.MY_CONSUMER)//通道名
    SubscribableChannel myConsumer();

//	测试延迟消息
	@Input(MySink.MY_DELAYED_CONSUMER)
	SubscribableChannel myDelayedConsumer();
}
