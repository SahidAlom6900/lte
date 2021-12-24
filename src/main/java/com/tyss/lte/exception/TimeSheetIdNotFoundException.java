package com.tyss.lte.exception;

public class TimeSheetIdNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 5680656387675097022L;

	public TimeSheetIdNotFoundException(String message) {
		super(message);
	}
}
