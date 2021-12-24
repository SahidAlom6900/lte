package com.tyss.lte.common;

public class ExpenseConstants {
	private ExpenseConstants() {
	}

	/* Controller message starts */

	public static final String EXPENSE_ADD_SUCCESS_MESSAGE = "Expenses added successfully. ";
	public static final String EXPENSE_ADD_FAIL_MESSAGE = "Expenses not added. ";

	public static final String EXPENSE_GET_SUCCESS_MESSAGE = "Expenses fetched successfully. ";
	public static final String EXPENSE_GET_FAIL_MESSAGE = "There are no expenses for the employee. ";

	/* Controller message ends */

	/* Service message starts */

	public static final String EMPLOYEE_ID_NOT_FOUND = "Expenses not found for the employee id. ";

	public static final String EMPTY_EXPENSE_LIST = "Expense list is empty. ";

	public static final String EMPLOYEE_ID_CANT_BE_NULL = "Employee Id can't be null. ";

	/* Service message ends */

	/* Repository message starts */

	public static final String GET_ALL_EXPENSES_BY_EMPOYEE_ID = "select e from Expense e where e.employeeId=?1";

	/* Repository message ends */

	/* dto message starts */

	public static final String EXPENSE_TYPE_REQUIRED_MESSSAGE = "Expense type cannot be empty. Please provide the expense type. ";
	public static final String EXPENSE_TYPE_REGEXP_CODE = "^[a-zA-Z]+[a-zA-Z ]*$";
	public static final String EXPENSE_TYPE_MINIMUM_SIZE_MESSAGE = "Expense type is too short. Please provide a minimum of 3 characters. ";
	public static final String EXPENSE_TYPE_REGEXP_MESSAGE = "Please proivide a valid expense type. ";

	public static final String BUSINESS_UNIT_REQUIRED_MESSSAGE = "Business unit cannot be empty. Please provide the business unit. ";
	public static final String BUSINESS_UNIT_REGEXP_CODE = "^[a-zA-Z]+[a-zA-Z ]*$";
	public static final String BUSINESS_UNIT_REGEXP_MESSAGE = "Please proivide a valid business unit. ";
	public static final String BUSINESS_UNIT_MINIMUM_SIZE_MESSAGE = "Business unit is too short. Please provide a minimum of 3 characters. ";

	public static final String DATE_INVALID_MESSAGE = "Please provide a valid present or past date. ";

	public static final String TOTAL_AMOUNT_INVALID_MESSAGE = "Total amount limit is exceeded. ";
	
	public static final String CLIENT_EMAIL_REGEXP = "^(?=[^@]*[A-Za-z])([a-zA-Z0-9])(([\\._-])?([a-zA-Z0-9]))*+@(([a-zA-Z0-9\\-])+(\\.))*+([a-zA-Z]{2,4})*+$";
	public static final String CLIENT_EMAIL_REQUIRED_MESSAGE = "Candidate email cannot be empty, Please provide the candidate email";
	public static final String CLIENT_EMAIL_MINIMUM_SIZE_MESSAGE = "Candidate email is too short, Provide a minimum of 5 characters";
	public static final String CLIENT_EMAIL_REGEXP_MESSAGE = "Please provide a valid candidate email";
	
	public static final String EMPLOYEE_ID_REGEXP_CODE = "^[A-Z0-9]*$";
	public static final String EMPLOYEE_ID_REQUIRED_MESSAGE = "Employee id cannot be empty, Please provide the employee id";
	public static final String EMPLOYEE_ID_MINIMUM_SIZE_MESSAGE = "Employee id is too short, Provide a minimum of 3 characters";
	public static final String EMPLOYEE_ID_REGEXP_MESSAGE = "Please provide a valid employee id";

	/* dto message ends */

}
