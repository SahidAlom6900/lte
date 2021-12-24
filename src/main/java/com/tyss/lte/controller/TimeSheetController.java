/**
 * 
 */
package com.tyss.lte.controller;

import static com.tyss.lte.common.CalendarDateConstants.CALENDAR_DATE_REMOVE_SUCCESSFULLY;
import static com.tyss.lte.common.CalendarDateConstants.CALENDAR_DATE_FAIL_TO_REMOVE;
import static com.tyss.lte.common.TimeSheetConstants.TIME_SHEET_DATA_FETCH_SUCCESSFULLY;
import static com.tyss.lte.common.TimeSheetConstants.TIME_SHEET_FAIL_TO_GET;
import static com.tyss.lte.common.TimeSheetConstants.TIME_SHEET_DATA_ADDED_SUCCESSFULLY;
import static com.tyss.lte.common.TimeSheetConstants.TIME_SHEET_FAIL_TO_ADDED;

import java.util.List;

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

import com.tyss.lte.dto.TimeSheet;
import com.tyss.lte.pojo.TimeSheetPojo;
import com.tyss.lte.response.TimeSheetResponse;
import com.tyss.lte.service.TimeSheetService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Sahid
 *
 */
@RestController
@RequestMapping("api/v1/lte-inventory")
@Slf4j
@Validated
public class TimeSheetController {
	@Autowired
	private TimeSheetService timeSheetService;

	@PostMapping(path = "/time-sheet")
	public ResponseEntity<?> addTimeSheet(@Valid @RequestBody TimeSheetPojo timeSheet) {
		TimeSheet timeSheet2 = timeSheetService.saveTimeSheet(timeSheet);
		if (timeSheet2 != null) {
			log.info(TIME_SHEET_DATA_ADDED_SUCCESSFULLY);
			return new ResponseEntity<TimeSheetResponse>(
					new TimeSheetResponse(false, TIME_SHEET_DATA_ADDED_SUCCESSFULLY, timeSheet2),
					HttpStatus.OK);
		}
		log.error(TIME_SHEET_FAIL_TO_ADDED);
		return new ResponseEntity<>(
				new TimeSheetResponse(true, TIME_SHEET_FAIL_TO_ADDED, null),
				HttpStatus.BAD_REQUEST);
	}//add Time Sheet Method Ends

	@GetMapping(path = "/time-sheet/{employeeId}")
	public ResponseEntity<?> getTimeSheet(@PathVariable("employeeId") String employeeId) {
		List<TimeSheet> timeSheet2 = timeSheetService.getTimeSheet(employeeId);
		if (!timeSheet2.isEmpty()) {
			log.info(TIME_SHEET_DATA_FETCH_SUCCESSFULLY);
			return new ResponseEntity<TimeSheetResponse>(
					new TimeSheetResponse(false, TIME_SHEET_DATA_FETCH_SUCCESSFULLY, timeSheet2),
					HttpStatus.OK);
		}
		log.error(TIME_SHEET_FAIL_TO_GET);
		return new ResponseEntity<>(
				new TimeSheetResponse(true, TIME_SHEET_FAIL_TO_GET, null),
				HttpStatus.BAD_REQUEST);
	}//get Time Sheet Method Ends

	@DeleteMapping(path = "/time-sheet/{employeeId}/{month}")
	public ResponseEntity<?> removeTimeSheet(@PathVariable("employeeId") String employeeId,
			@PathVariable("month") String month) {
		System.out.println("hi");
		TimeSheet timeSheet2 = timeSheetService.deleteTimeSheet(employeeId, month);
		if (timeSheet2 != null) {
			log.info(CALENDAR_DATE_REMOVE_SUCCESSFULLY);
			return new ResponseEntity<TimeSheetResponse>(
					new TimeSheetResponse(false, CALENDAR_DATE_REMOVE_SUCCESSFULLY, timeSheet2),
					HttpStatus.OK);
		}
		log.error(CALENDAR_DATE_FAIL_TO_REMOVE);
		return new ResponseEntity<>(
				new TimeSheetResponse(true, CALENDAR_DATE_FAIL_TO_REMOVE, null),
				HttpStatus.BAD_REQUEST);
	}//remove Time Sheet Method Ends

	@GetMapping(path = "/time-sheet/{employeeId}/{month}")
	public ResponseEntity<?> getTimeSheet(@PathVariable("employeeId") String employeeId,
			@PathVariable("month") String month) {
		TimeSheet timeSheet = timeSheetService.getTimeSheet(employeeId, month);
		if (timeSheet != null) {
			log.info(TIME_SHEET_DATA_FETCH_SUCCESSFULLY);
			return new ResponseEntity<TimeSheetResponse>(
					new TimeSheetResponse(false, TIME_SHEET_DATA_FETCH_SUCCESSFULLY, timeSheet),
					HttpStatus.OK);
		}
		log.error(TIME_SHEET_FAIL_TO_GET);
		return new ResponseEntity<>(
				new TimeSheetResponse(true, TIME_SHEET_FAIL_TO_GET, null),
				HttpStatus.BAD_REQUEST);
	}//get Time Sheet Method Ends
}
