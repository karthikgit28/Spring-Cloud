package com.spring.client.springconfigclient.entity;

public class Values {
	
	private int minValue;
	
	private int maxValue;
	
	public Values() {
		
	}

	public Values(int minValue, int maxValue) {
		super();
		this.minValue = minValue;
		this.maxValue = maxValue;
	}

	public int getMinValue() {
		return minValue;
	}

	public void setMinValue(int minValue) {
		this.minValue = minValue;
	}

	public int getMaxValue() {
		return maxValue;
	}

	public void setMaxValue(int maxValue) {
		this.maxValue = maxValue;
	}
	
	
	

}
