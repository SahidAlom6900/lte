package com.tyss.lte.pojo;

import static com.tyss.lte.common.TimeSheetConstants.EMAIL_ID;
import static com.tyss.lte.common.TimeSheetConstants.EMAIL_VALIDATION;
import static com.tyss.lte.common.TimeSheetConstants.LOGIN_TIME_CAN_NOT_BE_NULL;
import static com.tyss.lte.common.TimeSheetConstants.LOGOUT_TIME_CAN_NOT_BE_NULL;
import static com.tyss.lte.common.TimeSheetConstants.MONTH_CAN_NOT_BE_BLANK;
import static com.tyss.lte.common.TimeSheetConstants.PAST_OR_PRESENT_TIME;
import static com.tyss.lte.common.TimeSheetConstants.PROJECT_NAME_CAN_NOT_BE_BLANK;

import java.time.LocalTime;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tyss.lte.dto.CalendarDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TimeSheetPojo {
	private int timeSheetId;

	@NotBlank(message = PROJECT_NAME_CAN_NOT_BE_BLANK)
	private String employeeId;

	@NotBlank(message = PROJECT_NAME_CAN_NOT_BE_BLANK)
	private String projectName;

	@Email(message = EMAIL_ID)
	@Pattern(regexp = EMAIL_VALIDATION, message = EMAIL_ID)
	private String teEmailId;

	@Email(message = EMAIL_ID)
	@Pattern(regexp = EMAIL_VALIDATION, message = EMAIL_ID)
	private String clientEmailId;

	@NotBlank(message = MONTH_CAN_NOT_BE_BLANK)
	private String month;

	@PastOrPresent(message = PAST_OR_PRESENT_TIME)
	@NotNull(message = LOGIN_TIME_CAN_NOT_BE_NULL)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm", timezone = "Asia/Kolkata")
	private LocalTime loginTime;

	@PastOrPresent(message = PAST_OR_PRESENT_TIME)
	@NotNull(message = LOGOUT_TIME_CAN_NOT_BE_NULL)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm", timezone = "Asia/Kolkata")
	private LocalTime logoutTime;
	
	private List<@Valid CalendarDate> calendarDates;
	
	public TimeSheetPojo(int timeSheetId, String employeeId, String projectName, String teEmailId, String clientEmailId,
			String month, LocalTime loginTime, LocalTime logoutTime) {
		this.timeSheetId = timeSheetId;
		this.employeeId = employeeId;
		this.projectName = projectName;
		this.teEmailId = teEmailId;
		this.clientEmailId = clientEmailId;
		this.month = month;
		this.loginTime = loginTime;
		this.logoutTime = logoutTime;
	}
}
