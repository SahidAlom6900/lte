package com.tyss.lte.pojo;

import static com.tyss.lte.common.CalendarDateConstants.DATE_CAN_NOT_BE_NULL;
import static com.tyss.lte.common.CalendarDateConstants.DESCRIPTION_CAN_NOT_BE_BLANK;
import static com.tyss.lte.common.CalendarDateConstants.LOGIN_TIME_CAN_NOT_BE_NULL;
import static com.tyss.lte.common.CalendarDateConstants.LOGOUT_TIME_CAN_NOT_BE_NULL;
import static com.tyss.lte.common.CalendarDateConstants.MESSAGE_CAN_NOT_BE_BLANK;
import static com.tyss.lte.common.CalendarDateConstants.PAST_OR_PRESENT_DATE;
import static com.tyss.lte.common.CalendarDateConstants.PAST_OR_PRESENT_TIME;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tyss.lte.dto.TimeSheet;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CalendarDatePojo {
	private int calendarDateId;

	@NotBlank(message =MESSAGE_CAN_NOT_BE_BLANK)
	private String dayMessage;

	@PastOrPresent(message = PAST_OR_PRESENT_TIME)
	@NotNull(message = LOGIN_TIME_CAN_NOT_BE_NULL)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm", timezone = "Asia/Kolkata")
	private LocalTime loginTime;

	@PastOrPresent(message = PAST_OR_PRESENT_TIME)
	@NotNull(message = LOGOUT_TIME_CAN_NOT_BE_NULL)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm", timezone = "Asia/Kolkata")
	private LocalTime logoutTime;
	
	@PastOrPresent(message = PAST_OR_PRESENT_DATE)
	@NotNull(message = DATE_CAN_NOT_BE_NULL)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Kolkata")
	private LocalDate date;

	@NotBlank(message = DESCRIPTION_CAN_NOT_BE_BLANK)
	private String dailyTaskDetails;

	private TimeSheet timeSheet;
}
