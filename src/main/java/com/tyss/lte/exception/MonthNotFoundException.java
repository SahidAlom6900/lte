package com.tyss.lte.exception;

public class MonthNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 5680656387675097022L;

	public MonthNotFoundException(String message) {
		super(message);
	}
}
