package com.spring.client.springconfigclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.spring.client.springconfigclient.config.Configuration;
import com.spring.client.springconfigclient.entity.Values;

@RestController
@RefreshScope
public class UserController {

	@Autowired
	private Configuration config;
	
	@GetMapping("/hardCodedValues")
	public Values returnValue() {
		return new Values(1,20);
	}
	
	@GetMapping("/configValues")
	public Values returnConfigValue() {
		return new Values(config.getMinValue(),config.getMaxValue());
	}
	
	
	@GetMapping("/fallback-hystrix")
	@HystrixCommand(fallbackMethod="fallbackMethod")
	public Values returnExceptionMethod() {
		throw new RuntimeException();
	}
	
	public Values fallbackMethod() {
		return new Values(1,100);
	}
	
}
