package com.tyss.lte.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor 
public class ExpenseExceptionResponse {
	private boolean error;
	private String message;
	private Object data;
}
