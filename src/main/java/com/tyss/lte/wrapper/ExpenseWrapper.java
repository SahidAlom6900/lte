package com.tyss.lte.wrapper;

import java.util.List;

import com.tyss.lte.dto.Expense;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExpenseWrapper {
	private List<Expense> expenseList;
}
