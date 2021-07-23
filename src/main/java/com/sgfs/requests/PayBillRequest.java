package com.sgfs.requests;

import lombok.Data;

@Data
public class PayBillRequest 
{
	private String transactionId;
	private String dt;
	private int amount;
	private String merchantId;
	private String subscrNumber;
	
	
}
