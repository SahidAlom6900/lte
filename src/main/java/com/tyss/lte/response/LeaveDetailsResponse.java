package com.tyss.lte.response;



import com.tyss.lte.dto.LeaveDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LeaveDetailsResponse {
	private boolean error;
	private String message;
	private LeaveDetails data;
}
