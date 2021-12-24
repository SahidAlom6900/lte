/**
 * 
 */
package com.tyss.lte.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.tyss.lte.dto.Expense;
import com.tyss.lte.dto.ExpenseDocument;
import com.tyss.lte.exception.ExpenseException;
import com.tyss.lte.pojo.ExpensePojo;
import com.tyss.lte.repository.ExpenseDocumentRepository;
import com.tyss.lte.repository.ExpenseRepository;

/**
 * @author Sahid
 *
 */
@SpringBootTest
public class TestExpenseServiceImpl {

	@Mock
	private ExpenseRepository expenseRepository;

	@Mock
	private ExpenseDocumentRepository expenseDocumentRepository;

	@InjectMocks
	private ExpenseServiceImpl expenseServiceImpl;

	/**
	 * Test method for
	 * {@link com.tyss.lte.service.ExpenseServiceImpl#saveExpences(java.util.List)}.
	 * 
	 * @throws IOException
	 * @throws ExpenseException
	 */
	@Test
	public void testSaveExpences() throws ExpenseException, IOException {
		String[] expenseDocuments = { "abc.png", "xyz.jpg" };
		ExpensePojo expensePojo = new ExpensePojo(100, "Traveling", "General", LocalDate.now(), 450,
				"sahid123@gmail.com", "TYC0821230", expenseDocuments, "Done", "Traveling X to Y");
		List<ExpensePojo> expensePojos = new ArrayList<>();
		expensePojos.add(expensePojo);
		List<ExpenseDocument> expenseDocumentList = new ArrayList<>();
		byte[] expenseDocument = { 1, 0, 1, 0, 0 };
		expenseDocumentList.add(new ExpenseDocument(100, expenseDocument));
		Expense expense = new Expense(100, "Traveling", "General", LocalDate.now(), 450, "sahid123@gmail.com",
				"TYC0821230", "Done", "Traveling X to Y", expenseDocumentList);
		String expected = expense.getClientMailId();
		String actual = null;
		List<Expense> expenses = new ArrayList<>();
		expenses.add(expense);
		Mockito.when(expenseRepository.save(Mockito.any())).thenReturn(expense);
		Mockito.when(expenseRepository.findByExpenseId(Mockito.anyInt())).thenReturn(expense);
		expenseDocumentRepository.delete(Mockito.any());
		Mockito.when(expenseRepository.save(Mockito.any())).thenReturn(expense);
		List<Expense> expences0 = expenseServiceImpl.saveExpences(expensePojos);
		for (Expense expense2 : expences0) {
			actual = expense2.getClientMailId();
			break;
		}
		assertEquals(expected, actual);
	}

	/**
	 * Test method for
	 * {@link com.tyss.lte.service.ExpenseServiceImpl#getAllExpencesByEmpId(java.lang.String)}.
	 * 
	 * @throws ExpenseException
	 */
	@Test
	public void testGetAllExpencesByEmpId() throws ExpenseException {
		List<ExpenseDocument> expenseDocumentList = new ArrayList<>();
		byte[] expenseDocument = { 1, 0, 1, 0, 0 };
		expenseDocumentList.add(new ExpenseDocument(100, expenseDocument));
		Expense expense = new Expense(100, "Traveling", "General", LocalDate.now(), 450, "sahid123@gmail.com",
				"TYC0821230", "Done", "Traveling X to Y", expenseDocumentList);
		String expected = expense.getClientMailId();
		String actual = null;
		List<Expense> expenses = new ArrayList<>();
		expenses.add(expense);
		Mockito.when(expenseRepository.getAllExpencesByEmployeeId(Mockito.any())).thenReturn(expenses);
		List<Expense> allExpencesByEmpId = expenseServiceImpl.getAllExpencesByEmpId(expense.getEmployeeId());
		for (Expense expense2 : allExpencesByEmpId) {
			actual = expense2.getClientMailId();
			break;
		}
		assertEquals(expected, actual);
	}

}
