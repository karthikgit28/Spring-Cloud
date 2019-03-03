package com.currency.exchange.currencyexchangeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.currency.exchange.currencyexchangeservice.entity.ExchangeRate;

public interface ExchangeRepository extends JpaRepository<ExchangeRate, Integer>{

	ExchangeRate findByFromAndTo(String from,String to);
}
