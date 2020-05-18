package com.b13.orderservice.controller.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.b13.orderservice.dto.StringResponse;
import com.b13.orderservice.exception.DaoException;

@ControllerAdvice
public class ExceptionHandlerControllerAdvice {
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public StringResponse handleMissingRequestBody(Exception ex) {
	    return StringResponse.of("Bad input request; Missing body ");
	}
	
	
	@ExceptionHandler(DaoException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public StringResponse handlException(Exception ex) {
	    return StringResponse.of("Error processing data internally");
	}

}
