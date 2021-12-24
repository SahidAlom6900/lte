package com.tyss.lte.handler;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolationException;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.tyss.lte.exception.CalendarDateException;
import com.tyss.lte.exception.DateNotFoundException;
import com.tyss.lte.exception.IdNotFoundException;
import com.tyss.lte.response.CalendarDateResponse;

@RestControllerAdvice
public class CalendarDateExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler({ DateNotFoundException.class })
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public ResponseEntity<CalendarDateResponse> dateNotFoundExceptionHandler(DateNotFoundException exception, WebRequest request) {
		return new ResponseEntity<>(new CalendarDateResponse(true, exception.getMessage(), null), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler({ IdNotFoundException.class })
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public  ResponseEntity<CalendarDateResponse> idNotFoundExceptionHandler(IdNotFoundException exception, WebRequest request) {
		return new ResponseEntity<>(new CalendarDateResponse(true, exception.getMessage(), null), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler({ CalendarDateException.class})
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public  ResponseEntity<CalendarDateResponse> calendarDateException(CalendarDateException exception, WebRequest request) {
		return new ResponseEntity<>(new CalendarDateResponse(true, exception.getMessage(), null), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(RuntimeException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public  ResponseEntity<CalendarDateResponse> badRequest(RuntimeException exception, WebRequest request) {
		return new ResponseEntity<>(new CalendarDateResponse(true, exception.getMessage(), null), HttpStatus.BAD_REQUEST);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		Map<String, Object> body = new LinkedHashMap<>();
		List<String> errors = exception.getBindingResult().getFieldErrors().stream()
				.map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.toList());
		body.put("error", true);
		body.put("message", errors);
		body.put("data", null);
		return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<?> constraintViolationException(ConstraintViolationException exception, WebRequest request) {
		List<String> errors = new ArrayList<>();
		exception.getConstraintViolations().forEach(cv -> errors.add(cv.getMessage()));
		Map<String, Object> result = new LinkedHashMap<>();
		result.put("error", true);
		result.put("message", errors);
		result.put("data", null);
		return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseEntity<CalendarDateResponse> internalServerError(Exception exception, WebRequest request) {
		return new ResponseEntity<>(new CalendarDateResponse(true, exception.getMessage(), null), HttpStatus.BAD_REQUEST);
	}
}
