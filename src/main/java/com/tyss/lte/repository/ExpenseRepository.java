package com.tyss.lte.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tyss.lte.dto.Expense;
import static com.tyss.lte.common.ExpenseConstants.*;

public interface ExpenseRepository extends JpaRepository<Expense, Integer>{
	
	@Query(GET_ALL_EXPENSES_BY_EMPOYEE_ID)
	public List<Expense> getAllExpencesByEmployeeId(String employeeId);
	
	Expense findByExpenseId(int expenseId);
}
