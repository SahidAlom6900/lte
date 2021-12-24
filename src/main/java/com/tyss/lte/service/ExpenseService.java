package com.tyss.lte.service;

import java.io.IOException;
import java.util.List;

import com.tyss.lte.dto.Expense;
import com.tyss.lte.exception.ExpenseException;
import com.tyss.lte.pojo.ExpensePojo;

public interface ExpenseService {
	public List<Expense> saveExpences(List<ExpensePojo> expenseList) throws ExpenseException, IOException;

	public List<Expense> getAllExpencesByEmpId(String employeeId) throws ExpenseException;
}
