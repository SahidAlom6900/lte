package com.tyss.lte.controller;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.lte.dto.Expense;
import com.tyss.lte.exception.ExpenseException;
import com.tyss.lte.pojo.ExpensePojo;
import com.tyss.lte.response.ExpenseResponse;
import com.tyss.lte.service.ExpenseService;
import static com.tyss.lte.common.ExpenseConstants.*;

/**
 * 
 * @author TYSS
 *
 */

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/")
@Validated
public class ExpenseController {

	@Autowired
	private ExpenseService expenseService;

	/**
	 * 
	 * @param expences
	 * @return
	 * @throws ExpenseException
	 * @throws IOException
	 */
	@PostMapping("lte-inventory/expense")
	public ResponseEntity<ExpenseResponse> addExpence(@Valid @RequestBody List<ExpensePojo> expences)
			throws ExpenseException, IOException {
		System.out.println("Expense controller");
		List<Expense> response = expenseService.saveExpences(expences);
		if (response != null) {
			return new ResponseEntity<>(new ExpenseResponse(false, EXPENSE_ADD_SUCCESS_MESSAGE, response),
					HttpStatus.OK);
		} else {
			return new ResponseEntity<>(new ExpenseResponse(true, EXPENSE_ADD_FAIL_MESSAGE, null),
					HttpStatus.BAD_REQUEST);
		}
	}// end of add expense method

	/**
	 * 
	 * @param employeeId
	 * @return
	 * @throws ExpenseException
	 */
	@GetMapping("lte-inventory/expense/{employeeId}")
	public ResponseEntity<ExpenseResponse> getExpences(@PathVariable("employeeId") String employeeId)
			throws ExpenseException {
		List<Expense> response = expenseService.getAllExpencesByEmpId(employeeId);
		if (!response.isEmpty()) {
			return new ResponseEntity<>(new ExpenseResponse(false, EXPENSE_GET_SUCCESS_MESSAGE, response),
					HttpStatus.OK);
		} else {
			return new ResponseEntity<>(new ExpenseResponse(true, EXPENSE_GET_FAIL_MESSAGE, response),
					HttpStatus.BAD_REQUEST);
		}
	}// end of get expenses method

}
