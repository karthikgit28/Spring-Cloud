package com.currency.exchange.currencyexchangeservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.currency.exchange.currencyexchangeservice.entity.ExchangeRate;
import com.currency.exchange.currencyexchangeservice.repository.ExchangeRepository;

@RestController
public class ExchangeController {
	
	Logger log = LoggerFactory.getLogger(ExchangeController.class);

	@Autowired
	private Environment environment;
	
	@Autowired
	private ExchangeRepository repository;
	
	@GetMapping("rate/from/{from}/to/{to}")
	public ExchangeRate exchangeValue(@PathVariable String from, @PathVariable String to) {
		
		ExchangeRate rateValue = repository.findByFromAndTo(from, to);
		
		log.info("Exchange Request -> {}",rateValue);
		
		int port = Integer.parseInt(environment.getProperty("local.server.port"));
		rateValue.setPort(port);
		return rateValue;
	}
	
}
