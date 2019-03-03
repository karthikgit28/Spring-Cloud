package com.currency.conversion.currencyconversionservice.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.currency.conversion.currencyconversionservice.entity.ConversionRate;
import com.currency.conversion.currencyconversionservice.proxy.CurrencyExchangeProxy;

@RestController
public class ConversionController {
	
	Logger log = LoggerFactory.getLogger(ConversionController.class);
	
	@Autowired
	private CurrencyExchangeProxy proxy;

	@GetMapping("/conversion/from/{from}/to/{to}/quantity/{quantity}/rate")
	public ConversionRate rateValue(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {
		
		Map<String,String> uriVariables = new HashMap<String,String>();
		
		ResponseEntity<ConversionRate> result =  new RestTemplate().getForEntity("http://localhost:8002/rate/from/INR/to/USD", 
				ConversionRate.class, uriVariables);
		
		ConversionRate value = result.getBody();
		
		return new ConversionRate(value.getId(), from, to, quantity, value.getRate(),
				quantity.multiply(value.getRate()),value.getPort());
	}
	
	
	@GetMapping("/feign/from/{from}/to/{to}/quantity/{quantity}/rate")
	public ConversionRate rateFeignValue(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {
		
		ConversionRate value = proxy.exchangeValue(from, to);
		
		log.info("Conversion Request -> {}",value);
		
		return new ConversionRate(value.getId(), from, to, quantity, value.getRate(),
				quantity.multiply(value.getRate()),value.getPort());
	}
	
}
