package com.sgfs.requests;

import lombok.Data;

@Data
public class CheckBillRequest 
{
	private String merchantId;
	private String subscrNumber;
}
