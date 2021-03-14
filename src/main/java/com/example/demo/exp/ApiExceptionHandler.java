package com.example.demo.exp;

import java.time.ZonedDateTime;

import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ApiExceptionHandler {
	
	private final static Logger LOGGER = (Logger) org.slf4j.LoggerFactory.getLogger(ApiExceptionHandler.class);
	
	@org.springframework.web.bind.annotation.ExceptionHandler(value = ApiRequestException.class)
	public ResponseEntity<Object> handleApiRequestException(
			ApiRequestException e
			){
		
		ApiException apiException = new ApiException(
				e.getMessage(),
				e,
				HttpStatus.BAD_REQUEST,
				ZonedDateTime.now()
				);
		
		return new ResponseEntity<>(apiException, HttpStatus.BAD_REQUEST);
		
		
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler(value = NotFoundException.class)
	public ResponseEntity<Object> handleApiRequestException(
			NotFoundException e
			){
		
		ApiException apiException = new ApiException(
				e.getMessage(),
				e,
				HttpStatus.NOT_FOUND,
				ZonedDateTime.now()
				);
		
		return new ResponseEntity<>(apiException, HttpStatus.NOT_FOUND);
		
		
	}
	
	
}
