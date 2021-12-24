package com.tyss.lte.common;

public class LeaveDetailsContants {
	private LeaveDetailsContants() {
	}
	/*Controller message starts*/
	
	public static final String LEAVE_DETAILS_ADD_SUCCESS_MESSAGE = "Leave details added successfully. ";
	public static final String LEAVE_DETAILS_ADD_FAIL_MESSAGE = "Leave details not able to add. ";

	public static final String LEAVE_DETAILS_GET_SUCCESS_MESSAGE = "Leaves fetched successfully. ";
	public static final String LEAVE_DETAILS_GET_FAIL_MESSAGE = "Leaves not fetched. ";
	
	/*Controller message ends*/
	
	
	/*Service message starts*/
	
	public static final String LEAVE_ID_NOT_PRESENT = "Leave Id not present. ";
	
	public static final String EMPLOYEE_ID_NOT_PRESENT = "Employee id not present. ";
	
	/*Service message ends*/
	
	/*Repository message starts*/
	
	public static final String GET_ALL_LEAVE_DETAILS_BY_EMPLOYEE_ID = "select ld from LeaveDetails ld where ld.employeeId=?1";
	
	/*Repository message ends*/
	
	/*LeaveDeatils DTO message starts*/
	
	public static final String LEAVE_TYPE_CANT_BE_NULL = "Leave type can't be null. ";
	public static final String LEAVE_TYPE_REGEX = "^[a-z|A-Z]+(?:[a-z|A-Z]+)*$";
	public static final String LEAVE_TYPE_REGEX_MESSAGE = "Leave field should contain only characters,It should not contain special charactes or numbers. ";
	public static final String LEAVE_TYPE_SIZE = "leave type contains atleast two characters. ";
	
	public static final String FROM_DATE_LIMIT = "From date can't be a past date. "; 
	public static final String TO_DATE_LIMIT = "toDate always be future. ";
	
	public static final String REASON_CANT_BE_EMPTY = "Reason can't be empty. ";
	public static final String REASON_LIMIT = "Reason should contains atleast 10 characters. ";
	public static final String REASON_REGEX = "^[a-zA-Z]+[a-zA-Z0-9,. ]*$";
	public static final String REASON_REGEX_MESSAGE = "Reason should be in a proper format. ";
	
	public static final String EMPLOYEE_ID_CANT_BE_EMPTY = "Employee id can't be blank. ";
	public static final String EMPLOYEE_ID_REGEX = "^[a-z|A-Z]+[a-z|A-Z|0-9]*$";
	public static final String EMPLOYEE_ID_REGEX_MESSAGE = "Employee idshould be in a proper format. ";
	
	/*LeaveDetails DTO message ends*/
}
