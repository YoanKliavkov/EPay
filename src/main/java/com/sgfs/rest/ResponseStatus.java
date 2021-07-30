package com.sgfs.rest;

public enum ResponseStatus {
	
	OK(0), NO_BILL(62), INVALID_SUBSCR(14), INVALID_MERCHANT(58), CARD_LOCKED(75),
	TEMPORARY_IMPOSSIBLE_TO_EXECUTE(80), GENERAL_ERROR(96), INVALID_DEPOSIT_SUM(13), INVALID_FORMAT(805),
	BILL_BLOCKED(70), OLD_BILL_EXISTS(49), PAYMENT_WINDOW_MISSED(50), NO_INFO_FOR_SUBSCR_NUMBER(52);

	private int status;

	ResponseStatus(int status) {
		this.status = status;
	}

	public int getStatusCode() {
		return status;
	}
}
 