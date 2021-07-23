package com.sgfs.responses;

public enum ResponseStatus {

	OK("00"),
	NO_BILL("62"),
	INVALID_SUBSCR("14"),
	INVALID_MERCHANT("58"),
	CARD_LOCKED("75"),
	TEMPORARY_IMPOSSIBLE_TO_EXECUTE("80"),
	GENERAL_ERROR("96"),
	INVALID_DEPOSIT_SUM("13"),
	INVALID_FORMAT("805"),
	BILL_BLOCKED("70"),
	OLD_BILL_EXISTS("49"),
	PAYMENT_WINDOW_MISSED("50"),
	NO_INFO_FOR_SUBSCR_NUMBER("52");
	
	public String status;
	
	ResponseStatus(String status)
	{
		this.status = status;
	}
	
	public String getStatus()
	{
		return status;
	}
}
/*
00 ok
62 в момента нямате задължение
14 няма такъв абонат
58 няма такъв тип плащане/ такъв търговец /невалиден код за избиране/
75 картата е заключена
80 временно не може да бъде изпълнена
96 обща грешка
13 невалидна сума /при депозит/
805 невалиден формат
70 задължението е блокирано, защото има предишна заявка без commit или reversal 94 повторно съобщение
49 има старо задължение
50 извън периода на плащане
52 няма информация за този абонатен номер
*/