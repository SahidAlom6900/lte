package com.tyss.lte.response;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Data
@NoArgsConstructor
public class CalendarDateResponse implements Serializable {
	private boolean error;
	private String message;
	private Object data;

	public CalendarDateResponse(boolean error, String message, Object data) {
		this.error = error;
		this.message = message;
		this.data = data;
	}

}
