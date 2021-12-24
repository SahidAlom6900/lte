package com.tyss.lte.response;

import java.util.List;

import com.tyss.lte.dto.LeaveDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LeaveDetailsListResponse {
	private boolean error;
	private String message;
	private List<LeaveDetails> data;
}
