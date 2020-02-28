package com.elit.microservices.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class amiraController {
	@Value("${server.port}")
	private String port;
	
	
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
	
	

}
