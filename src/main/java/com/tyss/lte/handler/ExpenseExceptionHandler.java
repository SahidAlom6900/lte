package com.tyss.lte.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.tyss.lte.exception.ExpenseException;
import com.tyss.lte.response.CustomExceptionResponse;
import com.tyss.lte.response.ExpenseExceptionResponse;

@RestControllerAdvice
public class ExpenseExceptionHandler {

	@ExceptionHandler(ExpenseException.class)
	public ResponseEntity<ExpenseExceptionResponse> expenseExceptionHandler(ExpenseException exception) {
		return new ResponseEntity<>(new ExpenseExceptionResponse(true, exception.getMessage(), null),
				HttpStatus.NOT_FOUND);
	}

	

	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<CustomExceptionResponse> customValidationErrorHandling(
			MethodArgumentNotValidException exception) {
		CustomExceptionResponse response = new CustomExceptionResponse();
		FieldError fieldError = exception.getFieldError();
		if (fieldError != null) {
			response.setError(true);
			response.setMessage(fieldError.getDefaultMessage());
			response.setData(null);
		}
		return new ResponseEntity<>(response, HttpStatus.EXPECTATION_FAILED);
	}

}
