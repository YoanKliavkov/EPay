package com.sgfs.requests;

import lombok.Data;

@Data
public class CheckBillBlockedRequest {
	
	private String transactionId;
	private String dt;
	private String merchantId;
	private String subscrNumber;

}
	