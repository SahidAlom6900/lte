/**
 * 
 */
package com.tyss.lte.dto;

import static com.tyss.lte.common.TimeSheetConstants.EMAIL_ID;
import static com.tyss.lte.common.TimeSheetConstants.EMAIL_VALIDATION;
import static com.tyss.lte.common.TimeSheetConstants.LOGIN_TIME_CAN_NOT_BE_NULL;
import static com.tyss.lte.common.TimeSheetConstants.LOGOUT_TIME_CAN_NOT_BE_NULL;
import static com.tyss.lte.common.TimeSheetConstants.MONTH_CAN_NOT_BE_BLANK;
import static com.tyss.lte.common.TimeSheetConstants.PAST_OR_PRESENT_TIME;
import static com.tyss.lte.common.TimeSheetConstants.PROJECT_NAME_CAN_NOT_BE_BLANK;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Sahid
 *
 */

@SuppressWarnings("serial")
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "time_sheet")
public class TimeSheet implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "time_sheet_id")
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

	@OneToMany(mappedBy = "timeSheet",fetch = FetchType.EAGER)
	private List<@Valid CalendarDate> calendarDates;

	public TimeSheet(int timeSheetId, String employeeId, String projectName, String teEmailId, String clientEmailId,
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

	@Override
	public String toString() {
		return "TimeSheet [timeSheetId=" + timeSheetId + ", employeeId=" + employeeId + ", projectName=" + projectName
				+ ", teEmailId=" + teEmailId + ", clientEmailId=" + clientEmailId + ", month=" + month + ", loginTime="
				+ loginTime + ", logoutTime=" + logoutTime + "]";
	}

}
