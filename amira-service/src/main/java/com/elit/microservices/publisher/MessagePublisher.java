package com.elit.microservices.publisher;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;

import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;

@EnableBinding(Source.class)
public class MessagePublisher {

	
	public MessagePublisher() {
		super();
		// TODO Auto-generated constructor stub
	}

	@InboundChannelAdapter(channel=Source.OUTPUT , poller=@Poller(fixedDelay="5000"))
	public String sendTest() {
		return "Hello world messaging is working!";
		}
}
