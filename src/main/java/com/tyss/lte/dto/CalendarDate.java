package com.tyss.lte.dto;

import static com.tyss.lte.common.CalendarDateConstants.*;


import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "calendar_date")
@JsonIgnoreProperties({ "timeSheet" })
public class CalendarDate implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "calendar_date_id")
	private int calendarDateId;

	@NotBlank(message = MESSAGE_CAN_NOT_BE_BLANK)
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

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "time_sheet_id")
	private TimeSheet timeSheet;
}
