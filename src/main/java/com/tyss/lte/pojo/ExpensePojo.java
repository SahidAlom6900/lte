package com.tyss.lte.pojo;

import static com.tyss.lte.common.ExpenseConstants.*;

import java.time.LocalDate;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExpensePojo {
	private int expenseId;

	@NotBlank(message = EXPENSE_TYPE_REQUIRED_MESSSAGE)
	@Pattern(regexp = EXPENSE_TYPE_REGEXP_CODE, message = EXPENSE_TYPE_REGEXP_MESSAGE)
	@Size(min = 3, message = EXPENSE_TYPE_MINIMUM_SIZE_MESSAGE)
	private String expenseType;

	@NotBlank(message = BUSINESS_UNIT_REQUIRED_MESSSAGE)
	@Pattern(regexp = BUSINESS_UNIT_REGEXP_CODE, message = BUSINESS_UNIT_REGEXP_MESSAGE)
	@Size(min = 3, message = BUSINESS_UNIT_MINIMUM_SIZE_MESSAGE)
	private String businessUnit;

	@PastOrPresent(message = DATE_INVALID_MESSAGE)
	private LocalDate date;

	@Digits(fraction = 2, integer = 5, message = TOTAL_AMOUNT_INVALID_MESSAGE)
	private double totalAmount;

	@NotBlank(message = CLIENT_EMAIL_REQUIRED_MESSAGE)
	@Pattern(regexp = CLIENT_EMAIL_REGEXP, message = CLIENT_EMAIL_REGEXP_MESSAGE)
	@Size(min = 5, message = CLIENT_EMAIL_MINIMUM_SIZE_MESSAGE)
	private String clientMailId;

	@NotBlank(message = EMPLOYEE_ID_REGEXP_CODE)
	@Pattern(regexp = EMPLOYEE_ID_REGEXP_CODE, message = EMPLOYEE_ID_REGEXP_MESSAGE)
	@Size(min = 3, message = EMPLOYEE_ID_MINIMUM_SIZE_MESSAGE)
	private String employeeId;

	private String[] expenseDocuments;
	
	private String status;
	
	private String expenseDetails;
}
