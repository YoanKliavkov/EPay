package com.sgfs.rest;

import java.util.Date;

import lombok.Data;

@Data
public class EResponse 
{
	private Integer status;
	private Integer amount;
	private Integer fee;
	private Integer total;
	private String shortdesc;
	private String longdesc;
	private Date validto;
	private String secondid;
	
	
}
