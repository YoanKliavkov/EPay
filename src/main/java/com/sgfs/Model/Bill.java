package com.sgfs.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Bill 
{
	private String merchantId;
	private String subscrNumber;
	private String status;
	private String validto;
	private int amount;
	private String shortdesc;
	private String longdesc;
	private String secondid;
	
}
