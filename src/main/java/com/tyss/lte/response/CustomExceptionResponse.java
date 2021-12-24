package com.tyss.lte.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomExceptionResponse {
	private boolean error;
	private String message;
	private Object data;

}
