package com.chen.testspringcloudstreamconsumer.listener;

import com.chen.testspringcloudstreamconsumer.channel.MySink;
import com.chen.testspringcloudstreamconsumer.pojo.MyPayLoad;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.support.GenericMessage;

import java.io.IOException;

@EnableBinding(MySink.class)
public class MessageListener {

	//监听通道消息,接收到消息后处理业务逻辑如果有异常，会重新执行方法（默认最多执行3次）
	@StreamListener(MySink.MY_CONSUMER)//这里配置的是要监听的消息通道（消费通道）
	public void input(GenericMessage<MyPayLoad> message, @Header(AmqpHeaders.DELIVERY_TAG) Long deliveryTag) throws IOException {
		System.out.println("获取到消息: "+message.getPayload());
	}
	//监听通道消息(测试延时消息)
	@StreamListener(MySink.MY_DELAYED_CONSUMER)//这里配置的是要监听的消息通道（消费通道）
	public void mydelayed(GenericMessage message) {
		System.out.println("获取到消息: "+message.getPayload());
	}

}
