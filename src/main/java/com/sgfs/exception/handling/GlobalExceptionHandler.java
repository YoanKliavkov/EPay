package com.sgfs.exception.handling;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler
{
	public final ResponseEntity<Object> handleMyException(Exception ex, WebRequest request)  
	{
		log.error("Exception handled by GlobalExceptionHandler", ex);
		return null;
	}
}
