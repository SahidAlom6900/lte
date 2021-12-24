package com.tyss.lte.exception;

@SuppressWarnings("serial")
public class IdNotFoundException extends RuntimeException {
	public IdNotFoundException(String message) {
		super(message);
	}
}
