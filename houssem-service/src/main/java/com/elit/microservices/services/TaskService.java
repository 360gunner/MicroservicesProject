package com.elit.microservices.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;



@Service
//@FeignClient(name="amira-service" ,url="http://localhost:8081/")
@FeignClient(name="amira-service" )
//@RibbonClient(name="amira-service")
public interface TaskService {
	//@LoadBalanced
	@RequestMapping("/tt")
	ArrayList amira();

}
