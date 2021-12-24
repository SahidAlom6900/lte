package com.tyss.lte.response;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TimeSheetResponse {
	private boolean error;
	private String message;
	private Object data;

	public TimeSheetResponse(boolean error, String message, Object data) {
		this.error = error;
		this.message = message;
		this.data = data;
	}
	
}
