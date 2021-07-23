package com.sgfs.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

@Service
@PropertySource(value={"file:src/main/resources/application.properties"})
public class FeeCalculator 
{
	@Value("${feePercent}")
	public double feePercent;
	
	public int calculateFee(int amount)
	{
		return (int) (amount * feePercent / 100);
	}
}
