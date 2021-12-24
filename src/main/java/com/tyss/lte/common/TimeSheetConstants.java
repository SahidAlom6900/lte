package com.tyss.lte.common;

import lombok.Data;

@Data
public class TimeSheetConstants {
	
	/* dto message starts */
	
	public static final String EMPLOYEE_ID_CAN_NOT_BE_NULL="Employee Id Can Not be Null";
	
	public static final String PROJECT_NAME_CAN_NOT_BE_NULL="Project Name Can Not be Null";
	
	public static final String PROJECT_NAME_CAN_NOT_BE_BLANK="Project Name Can Not be Blank";
	
	public static final String EMAIL_ID="Enter the Proper Email Id";
	public static final String EMAIL_VALIDATION="[\\w]+@[\\w]+\\.[a-zA-Z]{2,3}";
	
	public static final String MONTH_CAN_NOT_BE_BLANK="Month Can Not be Blank";
	
	public static final String LOGIN_TIME_CAN_NOT_BE_NULL="Login Time Can Not Be Null";
	public static final String PAST_OR_PRESENT_TIME= "Time Must Be Past Or Present Time!!!";
	
	public static final String LOGOUT_TIME_CAN_NOT_BE_NULL="Logout Time Can Not Be Null";
	
	
	/* dto message ends */
	
	/* Controller message starts */
	
	public static final String 	TIME_SHEET_DATA_ADDED_SUCCESSFULLY="Time Sheet Data Added Successfully!!!";
	public static final String 	TIME_SHEET_FAIL_TO_ADDED="Time Sheet Fail to Added!!!";
	
	public static final String 	TIME_SHEET_DATA_FETCH_SUCCESSFULLY="Time Sheet Data Fetch Successfully!!!";
	public static final String 	TIME_SHEET_FAIL_TO_GET="Fail to Search Time Sheet!!!";
	
	public static final String 	TIME_SHEET_DATA_REMOVE_SUCCESSFULLY="Time Sheet Data Remove Successfully!!!";
	public static final String 	TIME_SHEET_FAIL_TO_REMOVE="Fail to Remove Time Sheet!!!";
	
	/* Controller message ends */
	
	/* Service message starts */
	
	public static final String EMPLOYEE_ID_NOT_FOUND = "Employee Id Not Found Try Another Employee Id!!!";
	
	public static final String TIME_SHEET_MONTH_NOT_FOUND = "Month Not Found In Time Sheet Try Another Month!!!";
	
	public static final String TIME_SHEET_ID_NOT_FOUND = "Time Sheet Id Not Found Try Another Time Sheet Id!!!";
	
	public static final String SOMETHING_WENT_WRONG = "Something Went Wrong Please Try Again After Some Time!!!";
	
	/* Service message ends */
}
