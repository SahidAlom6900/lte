package com.tyss.lte.service;

import java.time.LocalDate;

import com.tyss.lte.dto.CalendarDate;
import com.tyss.lte.pojo.CalendarDatePojo;

public interface CalendarDateService {
	CalendarDate saveCalendarDate(CalendarDatePojo calendarDatePojo);

	CalendarDate getCalendarDate(String employeeId, LocalDate date);

	CalendarDate deleteCalendarDate(String employeeId, LocalDate date);
}
