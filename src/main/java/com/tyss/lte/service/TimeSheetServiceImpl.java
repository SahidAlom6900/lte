package com.tyss.lte.service;

import static com.tyss.lte.common.TimeSheetConstants.EMPLOYEE_ID_NOT_FOUND;
import static com.tyss.lte.common.TimeSheetConstants.TIME_SHEET_MONTH_NOT_FOUND;
import static com.tyss.lte.common.TimeSheetConstants.SOMETHING_WENT_WRONG;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.tyss.lte.dto.CalendarDate;
import com.tyss.lte.dto.TimeSheet;
import com.tyss.lte.exception.IdNotFoundException;
import com.tyss.lte.exception.MonthNotFoundException;
import com.tyss.lte.exception.TimeSheetException;
import com.tyss.lte.pojo.TimeSheetPojo;
import com.tyss.lte.repository.CalendarDateRepository;
import com.tyss.lte.repository.TimeSheetRepository;

import lombok.extern.slf4j.Slf4j;

@Validated
@Service
@Slf4j
public class TimeSheetServiceImpl implements TimeSheetService {
	@Autowired
	private TimeSheetRepository timeSheetRepository;
	
	@Autowired
	private CalendarDateRepository calendarDateRepository;

	@Override
	public TimeSheet saveTimeSheet(TimeSheetPojo timeSheet) {
		try {
			@Valid
			TimeSheet timeSheet2 = new TimeSheet();
			BeanUtils.copyProperties(timeSheet, timeSheet2);
			return timeSheetRepository.save(timeSheet2);
		} catch (Exception exception) {
			log.error(SOMETHING_WENT_WRONG);
			throw new TimeSheetException(SOMETHING_WENT_WRONG);
		}
	}

	@Override
	public List<TimeSheet> getTimeSheet(String employeeId) {
		try {
			List<TimeSheet> employeeId2 = timeSheetRepository.findByEmployeeId(employeeId);
			if (!employeeId2.isEmpty()) {
				return employeeId2;
			}
			log.error(EMPLOYEE_ID_NOT_FOUND);
			throw new IdNotFoundException(EMPLOYEE_ID_NOT_FOUND);
		} catch (IdNotFoundException exceptionIdNotFoundException) {
			throw exceptionIdNotFoundException;
		} catch (Exception exception) {
			log.error(SOMETHING_WENT_WRONG);
			throw new TimeSheetException(SOMETHING_WENT_WRONG);
		}
	}

	@Override
	public TimeSheet deleteTimeSheet(String employeeId,String month) {
		try {
			List<TimeSheet> timeSheets = timeSheetRepository.findByEmployeeId(employeeId);
			if (!timeSheets.isEmpty()) {
				for (TimeSheet timeSheet : timeSheets) {
					if (timeSheet.getMonth().equalsIgnoreCase(month)) {
						List<CalendarDate> calendarDates = timeSheet.getCalendarDates();
						calendarDateRepository.deleteAll(calendarDates);
						timeSheetRepository.delete(timeSheet);
						return timeSheet;
					}
				}
				log.error(TIME_SHEET_MONTH_NOT_FOUND);
				throw new MonthNotFoundException(TIME_SHEET_MONTH_NOT_FOUND);
			}
			log.error(EMPLOYEE_ID_NOT_FOUND);
			throw new IdNotFoundException(EMPLOYEE_ID_NOT_FOUND);
		} catch (MonthNotFoundException | IdNotFoundException exception) {
			throw exception;
		} catch (Exception exception) {
			log.error(SOMETHING_WENT_WRONG);
			throw new TimeSheetException(SOMETHING_WENT_WRONG);
		}
	}

	@Override
	public TimeSheet getTimeSheet(String employeeId, String month) {
		try {
			List<TimeSheet> timeSheets = timeSheetRepository.findByEmployeeId(employeeId);
			if (!timeSheets.isEmpty()) {
				for (TimeSheet timeSheet : timeSheets) {
					if (timeSheet.getMonth().equalsIgnoreCase(month)) {
						return timeSheet;
					}
				}
				log.error(TIME_SHEET_MONTH_NOT_FOUND);
				throw new MonthNotFoundException(TIME_SHEET_MONTH_NOT_FOUND);
			}
			log.error(EMPLOYEE_ID_NOT_FOUND);
			throw new IdNotFoundException(EMPLOYEE_ID_NOT_FOUND);
		} catch (MonthNotFoundException | IdNotFoundException exception) {
			throw exception;
		} catch (Exception exception) {
			log.error(SOMETHING_WENT_WRONG);
			throw new TimeSheetException(SOMETHING_WENT_WRONG);
		}

	}

}
