package com.elit.microservices.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.elit.microservices.services.TaskService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;

@RestController
public class houssemController {
	
	
	@Value("${server.port}")
	private String port;
	
	private RestTemplate restTemplate;
	private TaskService taskService;
	houssemController(RestTemplate restTemplate,TaskService taskService) {
	
		this.restTemplate = restTemplate;
		this.taskService=taskService;
	}
	
	@GetMapping("test")
	public ResponseEntity<?> houssem() {
		List l=new ArrayList();
		l.add("houssem");
		l.add("sameeet");
		return new ResponseEntity<ArrayList>((ArrayList) l, HttpStatus.OK);
	}
	@LoadBalanced
	@HystrixCommand(commandKey = "userTasks", fallbackMethod = "userTasksFallback")
	@GetMapping("/mou7")
	public List<String> userTasks() {
		
		List l=taskService.amira();
		l.add(port);
		return l;
	
	}
	public List<String> userTasksFallback() {
		return new ArrayList<String>();
	}
		

}
