package com.sgfs.rest;

import java.util.Date;

import lombok.Data;

@Data
public class ERequest {
	
	private String transactionId;
	private Date dt;
	private String merchantId;
	private String subscrNumber;
	private Integer amount;

}
