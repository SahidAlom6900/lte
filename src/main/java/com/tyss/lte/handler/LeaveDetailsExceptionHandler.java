package com.tyss.lte.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.tyss.lte.exception.LeaveDeclinedException;
import com.tyss.lte.exception.LeaveDetailsException;
import com.tyss.lte.response.LeaveDetailsExceptionResponse;

@RestControllerAdvice
public class LeaveDetailsExceptionHandler {
	@ExceptionHandler(LeaveDetailsException.class)
	public ResponseEntity<LeaveDetailsExceptionResponse> leaveDetailsExceptionHandler(LeaveDetailsException exception) {
		return new ResponseEntity<>(new LeaveDetailsExceptionResponse(true, exception.getMessage(), null),
				HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(LeaveDeclinedException.class)
	public ResponseEntity<LeaveDetailsExceptionResponse> leaveDetailsExceptionHandler(LeaveDeclinedException exception) {
		return new ResponseEntity<>(new LeaveDetailsExceptionResponse(true, exception.getMessage(), null),
				HttpStatus.NOT_FOUND);
	}
}
