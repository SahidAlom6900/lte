package com.tyss.lte.dto;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import static com.tyss.lte.common.ExpenseConstants.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Expense {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int expenseId;

	@Column(length = 50)
	@NotBlank(message = EXPENSE_TYPE_REQUIRED_MESSSAGE)
	@Pattern(regexp = EXPENSE_TYPE_REGEXP_CODE, message = EXPENSE_TYPE_REGEXP_MESSAGE)
	@Size(min = 3, message = EXPENSE_TYPE_MINIMUM_SIZE_MESSAGE)
	private String expenseType;

	@Column(length = 50)
	@NotBlank(message = BUSINESS_UNIT_REQUIRED_MESSSAGE)
	@Pattern(regexp = BUSINESS_UNIT_REGEXP_CODE, message = BUSINESS_UNIT_REGEXP_MESSAGE)
	@Size(min = 3, message = BUSINESS_UNIT_MINIMUM_SIZE_MESSAGE)
	private String businessUnit;

	@Column
	@PastOrPresent(message = DATE_INVALID_MESSAGE)
	private LocalDate date;

	@Column
	@Digits(fraction = 2, integer = 5, message = TOTAL_AMOUNT_INVALID_MESSAGE)
	private double totalAmount;

	@Column(length = 35)
	@NotBlank(message = CLIENT_EMAIL_REQUIRED_MESSAGE)
	@Pattern(regexp = CLIENT_EMAIL_REGEXP, message = CLIENT_EMAIL_REGEXP_MESSAGE)
	@Size(min = 5, message = CLIENT_EMAIL_MINIMUM_SIZE_MESSAGE)
	private String clientMailId;

	@Column(length = 15)
	@NotBlank(message = EMPLOYEE_ID_REGEXP_CODE)
	@Pattern(regexp = EMPLOYEE_ID_REGEXP_CODE, message = EMPLOYEE_ID_REGEXP_MESSAGE)
	@Size(min = 3, message = EMPLOYEE_ID_MINIMUM_SIZE_MESSAGE)
	private String employeeId;

	@Column
	private String status;
	
	@Column(length = 500)
	private String expenseDetails;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "expense_id")
	private List<ExpenseDocument> expenseDocumentList;
}
