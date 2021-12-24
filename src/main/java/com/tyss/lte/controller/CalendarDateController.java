/**
 * 
 */
package com.tyss.lte.controller;

import static com.tyss.lte.common.CalendarDateConstants.CALENDAR_DATE_ADDED_SUCCESSFILLY;
import static com.tyss.lte.common.CalendarDateConstants.CALENDAR_DATE_FETCH_SUCCESSFULLY;
import static com.tyss.lte.common.CalendarDateConstants.CALENDAR_DATE_REMOVE_SUCCESSFULLY;
import static com.tyss.lte.common.CalendarDateConstants.CALENDAR_DATE_FAIL_TO_ADDED;
import static com.tyss.lte.common.CalendarDateConstants.CALENDAR_DATE_FAIL_TO_GET;
import static com.tyss.lte.common.CalendarDateConstants.CALENDAR_DATE_FAIL_TO_REMOVE;

import java.time.LocalDate;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.lte.dto.CalendarDate;
import com.tyss.lte.pojo.CalendarDatePojo;
import com.tyss.lte.response.CalendarDateResponse;
import com.tyss.lte.service.CalendarDateService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Sahid
 *
 */
@RestController
@RequestMapping("api/v1/lte-inventory")
@Slf4j
@Validated
public class CalendarDateController {

	@Autowired
	private CalendarDateService calendarDateService;

	@PostMapping(path = "/calendar-date")
	public ResponseEntity<?> addCalendarDate(@Valid @RequestBody CalendarDatePojo calendarDatePojo) {
		CalendarDate calendarDate = calendarDateService.saveCalendarDate(calendarDatePojo);
		if (calendarDate != null) {
			log.info(CALENDAR_DATE_ADDED_SUCCESSFILLY);
			return new ResponseEntity<CalendarDateResponse>(
					new CalendarDateResponse(false, CALENDAR_DATE_ADDED_SUCCESSFILLY, calendarDate),
					HttpStatus.OK);
		}
		log.error(CALENDAR_DATE_FAIL_TO_ADDED);
		return new ResponseEntity<>(
				new CalendarDateResponse( true, CALENDAR_DATE_FAIL_TO_ADDED, null),
				HttpStatus.BAD_REQUEST);
	}//add calendar date Method Ends

	@GetMapping(path = "/calendar-date/{employeeId}/{date}")
	public ResponseEntity<?> getCalendarDate(@PathVariable("employeeId") String employeeId,
			@PathVariable("date") String date1) {
		LocalDate date = LocalDate.parse(date1);
		CalendarDate calendarDate = calendarDateService.getCalendarDate(employeeId, date);
		if (calendarDate != null) {
			log.info(CALENDAR_DATE_FETCH_SUCCESSFULLY);
			return new ResponseEntity<CalendarDateResponse>(
					new CalendarDateResponse(false, CALENDAR_DATE_FETCH_SUCCESSFULLY, calendarDate),
					HttpStatus.OK);
		}
		log.error(CALENDAR_DATE_FAIL_TO_GET);
		return new ResponseEntity<>(
				new CalendarDateResponse(true, CALENDAR_DATE_FAIL_TO_GET, null),
				HttpStatus.BAD_REQUEST);
	}//get calendar date Method Ends

	@DeleteMapping(path = "/calendar-date/{employeeId}/{date}")
	public ResponseEntity<?> deleteCalendarDate(@PathVariable("employeeId") String employeeId,
			@PathVariable("date") String date1) {
		LocalDate date = LocalDate.parse(date1);
		CalendarDate calendarDate = calendarDateService.deleteCalendarDate(employeeId, date);
		if (calendarDate != null) {
			log.info(CALENDAR_DATE_REMOVE_SUCCESSFULLY);
			return new ResponseEntity<CalendarDateResponse>(
					new CalendarDateResponse(false, CALENDAR_DATE_REMOVE_SUCCESSFULLY, calendarDate),
					HttpStatus.OK);
		}
		log.error(CALENDAR_DATE_FAIL_TO_REMOVE);
		return new ResponseEntity<>(
				new CalendarDateResponse(true, CALENDAR_DATE_FAIL_TO_REMOVE, null),
				HttpStatus.BAD_REQUEST);
	}//delete calendar date Method Ends

}
