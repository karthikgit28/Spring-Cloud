package com.currency.conversion.currencyconversionservice.proxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.currency.conversion.currencyconversionservice.entity.ConversionRate;


//@FeignClient(name="currency-exchange",url="localhost:8002")
//@FeignClient(name="currency-exchange")
@FeignClient(name="zuul-server")
@RibbonClient(name="currency-exchange")
public interface CurrencyExchangeProxy {

	//@GetMapping("rate/from/{from}/to/{to}")
	@GetMapping("currency-exchange/rate/from/{from}/to/{to}")
	public ConversionRate exchangeValue(@PathVariable("from") String from, @PathVariable("to") String to);
	
	
}
