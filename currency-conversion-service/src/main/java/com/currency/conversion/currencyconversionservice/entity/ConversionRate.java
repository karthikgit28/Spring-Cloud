package com.currency.conversion.currencyconversionservice.entity;

import java.math.BigDecimal;

public class ConversionRate {
	
	private int id;
	private String from;
	private String to;
	private BigDecimal quantity;
	private BigDecimal rate;
	private BigDecimal exchangeValue;
	private int port;
	
	public ConversionRate() {
		
	}
	
	public ConversionRate(int id, String from, String to,BigDecimal quantity, BigDecimal rate, BigDecimal exchangeValue,int port) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.quantity = quantity;
		this.rate = rate;
		this.exchangeValue = exchangeValue;
		this.port = port;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public BigDecimal getRate() {
		return rate;
	}
	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	public BigDecimal getExchangeValue() {
		return exchangeValue;
	}
	public void setExchangeValue(BigDecimal exchangeValue) {
		this.exchangeValue = exchangeValue;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}
	
	
	
	

}
