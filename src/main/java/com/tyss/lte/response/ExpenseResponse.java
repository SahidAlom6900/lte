package com.tyss.lte.response;

import java.util.List;

import com.tyss.lte.dto.Expense;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExpenseResponse {
	private boolean error;
	private String message;
	private List<Expense> data;
}
