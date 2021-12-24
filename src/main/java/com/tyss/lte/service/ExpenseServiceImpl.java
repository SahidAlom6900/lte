package com.tyss.lte.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tyss.lte.dto.Expense;
import com.tyss.lte.dto.ExpenseDocument;
import com.tyss.lte.exception.ExpenseException;
import com.tyss.lte.pojo.ExpensePojo;
import com.tyss.lte.repository.ExpenseDocumentRepository;
import com.tyss.lte.repository.ExpenseRepository;
import static com.tyss.lte.common.ExpenseConstants.*;

@Service
public class ExpenseServiceImpl implements ExpenseService {

	@Autowired
	private ExpenseRepository expenseRepository;

	@Autowired
	private ExpenseDocumentRepository expenseDocumentRepository;
	
	@Override
	public List<Expense> saveExpences(List<ExpensePojo> expenses) throws ExpenseException, IOException {
		
		try {
			if (expenses != null) {
				List<Expense> expenseList = new ArrayList<>();
				for (ExpensePojo expense : expenses) {
					if (expense.getExpenseId() == 0) {
						
						Expense newExpenseObj = new Expense();
						
						BeanUtils.copyProperties(expense, newExpenseObj);
						
						List<ExpenseDocument> expenseDocumentList =new ArrayList<>();
						for (String expenseDocument : expense.getExpenseDocuments()) {
							ExpenseDocument media = new ExpenseDocument();
							byte[] image = Base64.getEncoder().encode(expenseDocument.getBytes());
							media.setExpenseDocument(image);
							expenseDocumentList.add(media);
						}
						newExpenseObj.setExpenseDocumentList(expenseDocumentList);
						expenseList.add(expenseRepository.save(newExpenseObj));
					} else {
						Expense expenseObj = expenseRepository.findByExpenseId(expense.getExpenseId());
						if (expenseObj != null) {
							for (ExpenseDocument media : expenseObj.getExpenseDocumentList()) {
								expenseDocumentRepository.delete(media);
							}
							BeanUtils.copyProperties(expense, expenseObj);
							List<ExpenseDocument> expenseDocumentList =new ArrayList<>();
							for (String expenseDocument : expense.getExpenseDocuments()) {
								ExpenseDocument media = new ExpenseDocument();
								byte[] image = Base64.getEncoder().encode(expenseDocument.getBytes());
								media.setExpenseDocument(image);
								expenseDocumentList.add(media);
							}
							expenseObj.setExpenseDocumentList(expenseDocumentList);
							expenseList.add(expenseRepository.save(expenseObj));
						} else {
							throw new ExpenseException(EMPLOYEE_ID_NOT_FOUND);
						}
					}
				}
				return expenseList;
			} else {
				throw new ExpenseException(EMPTY_EXPENSE_LIST);
			}
		}
		catch(Exception ex) {
			throw new ExpenseException("Expense can't be added. ");
		}
		
		
	}

	@Override
	public List<Expense> getAllExpencesByEmpId(String employeeId) throws ExpenseException {
		try {
			List<Expense> expenseList = null;
			if (employeeId != null) {
				expenseList = expenseRepository.getAllExpencesByEmployeeId(employeeId);
				if (!expenseList.isEmpty()) {
					return expenseList;
				} else {
					return expenseList;
				}
			} else {
				throw new ExpenseException(EMPLOYEE_ID_CANT_BE_NULL);
			}
		}catch(Exception ex) {
			throw new ExpenseException("Exception can't be fetched. ");
		}
	}

}
