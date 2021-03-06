package com.elit.microservices.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elit.microservices.publisher.MessagePublisher;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class amiraController {
	@Value("${server.port}")
	private String port;
	
	@Autowired
	MessagePublisher msg;
	
	
	@HystrixCommand(commandKey = "amira", fallbackMethod = "amiraTaht")
	@GetMapping("/tt")
	public List<String> amira() {
		List l=new ArrayList();
		l.add("amiiira");
		l.add("etiiir");
		l.add(port);
		return (ArrayList) l;
	}
	public List<String> amiraTaht(){
		return new ArrayList<String>();
	}
	
	@HystrixCommand(commandKey = "amira2", fallbackMethod = "amiraTaht2")
	@GetMapping("/tt2")
	public List<String> amira2() {
		List l=new ArrayList();
		l.add("amiiira");
		l.add("etiiir");
		l.add(port);
		return (ArrayList) l;
	}
	public List<String> amiraTaht2(){
		return new ArrayList<String>();
	}
	
	
	

}
