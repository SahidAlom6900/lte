package com.tyss.lte.response;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorMessageResponse implements Serializable {
	
	private String error;
	private String message;
	private Object data;
}
