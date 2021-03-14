package com.example.demo.exp;

import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;

public class ApiException {
	private final String message;
	private final Throwable throwable;
	private final HttpStatus httpStatus;
	private final ZonedDateTime zoneDateTime;
	
	
	
	
	public ApiException(String message, Throwable throwable, HttpStatus httpStatus, ZonedDateTime zoneDateTime) {
		super();
		this.message = message;
		this.throwable = throwable;
		this.httpStatus = httpStatus;
		this.zoneDateTime = zoneDateTime;
	}
	public String getMessage() {
		return message;
	}
	public Throwable getThrowable() {
		return throwable;
	}
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
	public ZonedDateTime getZoneDateTime() {
		return zoneDateTime;
	}
	@Override
	public String toString() {
		return "ApiException {message=" + message + ", throwable=" + throwable + ", httpStatus=" + httpStatus
				+ ", zoneDateTime=" + zoneDateTime + "}";
	}
	
}
