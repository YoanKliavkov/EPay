package com.sgfs.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Merchant {

	private  String merchantId;
	private  String fullName;
	private String fullNameEn;
	private  String webName;
	private  String subscrNumberType;
	private  Boolean active;	
	private  int category;
	private  String categoryName;
	private  int merchantType;
	private  Boolean merchantPartial;
	private  Boolean merchantInvoice;
	private  String merchantShortDesc;
	private  String merchantLongDesc;
	private  String subscrNumberRe;
	private  String subscrNumberReHelp;

}
