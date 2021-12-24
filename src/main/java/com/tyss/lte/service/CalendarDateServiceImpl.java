package com.tyss.lte.service;

import static com.tyss.lte.common.CalendarDateConstants.CALENDAR_DATE_NOT_FOUND;
import static com.tyss.lte.common.CalendarDateConstants.EMPLOYEE_ID_NOT_FOUND;
import static com.tyss.lte.common.CalendarDateConstants.SOMETHING_WENT_WRONG;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tyss.lte.dto.CalendarDate;
import com.tyss.lte.dto.TimeSheet;
import com.tyss.lte.exception.CalendarDateException;
import com.tyss.lte.exception.DateNotFoundException;
import com.tyss.lte.exception.IdNotFoundException;
import com.tyss.lte.pojo.CalendarDatePojo;
import com.tyss.lte.repository.CalendarDateRepository;
import com.tyss.lte.repository.TimeSheetRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CalendarDateServiceImpl implements CalendarDateService {

	@Autowired
	private CalendarDateRepository calendarDateRepository;

	@Autowired
	private TimeSheetRepository timeSheetRepository;

	@Override
	public CalendarDate saveCalendarDate(CalendarDatePojo calendarDatePojo) {
		TimeSheet timeSheet = timeSheetRepository.findByTimeSheetId(calendarDatePojo.getTimeSheet().getTimeSheetId());
		try {
			if (timeSheet != null || calendarDatePojo.getTimeSheet().getTimeSheetId() == 0) {
				CalendarDate calendarDate = new CalendarDate(calendarDatePojo.getCalendarDateId(),
						calendarDatePojo.getDayMessage(), calendarDatePojo.getLoginTime(),
						calendarDatePojo.getLogoutTime(), calendarDatePojo.getDate(),
						calendarDatePojo.getDailyTaskDetails(), calendarDatePojo.getTimeSheet());
				return calendarDateRepository.save(calendarDate);
			}
			log.error(EMPLOYEE_ID_NOT_FOUND);
			throw new IdNotFoundException(EMPLOYEE_ID_NOT_FOUND);
		} catch (IdNotFoundException exceptionFoundException) {
			throw exceptionFoundException;
		} catch (Exception exception) {
			log.error(SOMETHING_WENT_WRONG);
			throw new CalendarDateException(SOMETHING_WENT_WRONG);
		}
	}

	@Override
	public CalendarDate getCalendarDate(String employeeId, LocalDate date) {
		System.out.println(employeeId);
		try {
			List<CalendarDate> calendarDates = calendarDateRepository.findByDate(date);
			if (!calendarDates.isEmpty()) {
				for (CalendarDate calendarDate : calendarDates) {
					if (calendarDate.getTimeSheet().getEmployeeId().equalsIgnoreCase(employeeId)) {
						return calendarDate;
					}
				}
				log.error(EMPLOYEE_ID_NOT_FOUND);
				throw new IdNotFoundException(EMPLOYEE_ID_NOT_FOUND);
			}
			log.error(CALENDAR_DATE_NOT_FOUND);
			throw new DateNotFoundException(CALENDAR_DATE_NOT_FOUND);

		} catch (DateNotFoundException | IdNotFoundException exception) {
			throw exception;
		} catch (Exception exception) {
			log.error(SOMETHING_WENT_WRONG);
			throw new CalendarDateException(SOMETHING_WENT_WRONG);
		}
	}

	@Override
	public CalendarDate deleteCalendarDate(String employeeId, LocalDate date) {
		try {
			List<CalendarDate> calendarDates = calendarDateRepository.findByDate(date);
			if (!calendarDates.isEmpty()) {
				for (CalendarDate calendarDate : calendarDates) {
					if (calendarDate.getTimeSheet().getEmployeeId().equalsIgnoreCase(employeeId)) {
						calendarDateRepository.delete(calendarDate);
						return calendarDate;
					}
				}
				log.error(EMPLOYEE_ID_NOT_FOUND);
				throw new IdNotFoundException(EMPLOYEE_ID_NOT_FOUND);
			}
			log.error(CALENDAR_DATE_NOT_FOUND);
			throw new DateNotFoundException(CALENDAR_DATE_NOT_FOUND);
		} catch (DateNotFoundException | IdNotFoundException exception) {
			throw exception;
		} catch (Exception exception) {
			log.error(SOMETHING_WENT_WRONG);
			throw new CalendarDateException(SOMETHING_WENT_WRONG);
		}
	}

}
