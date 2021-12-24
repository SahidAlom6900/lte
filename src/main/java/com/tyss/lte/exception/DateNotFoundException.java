package com.tyss.lte.exception;

@SuppressWarnings("serial")
public class DateNotFoundException extends RuntimeException {
	public DateNotFoundException(String message) {
		super(message);
	}
}
