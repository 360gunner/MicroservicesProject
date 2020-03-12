package com.elit.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;

import com.elit.microservices.publisher.MessagePublisher;

@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrix
public class AmiraServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AmiraServiceApplication.class, args);
	}

	@Bean
	public MessagePublisher msg() {
		return new MessagePublisher();
	}
	
}
