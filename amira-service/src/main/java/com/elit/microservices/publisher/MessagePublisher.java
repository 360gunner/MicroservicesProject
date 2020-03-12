package com.elit.microservices.publisher;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.annotation.InboundChannelAdapter;

@EnableBinding(Source.class)
public class MessagePublisher {

	@InboundChannelAdapter(channel=Source.OUTPUT)
	public String sendTest() {
		return "Hello world messaging is working!";
		}
}
