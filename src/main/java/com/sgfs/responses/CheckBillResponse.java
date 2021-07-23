package com.sgfs.responses;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CheckBillResponse {

	private String status;
	private String validto;
	private int amount;
	private String shortdesc;
	private String longdesc;
	private String secondid;
	
}
