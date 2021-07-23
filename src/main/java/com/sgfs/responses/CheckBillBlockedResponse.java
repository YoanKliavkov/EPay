package com.sgfs.responses;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CheckBillBlockedResponse {
	
	private String status;
	private int amount;
	private int fee;
	private int total;
	private String shortdesc;
	private String longdesc;
												
}

