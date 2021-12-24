/**
 * 
 */
package com.tyss.lte.service;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.tyss.lte.dto.CalendarDate;
import com.tyss.lte.dto.TimeSheet;
import com.tyss.lte.pojo.CalendarDatePojo;
import com.tyss.lte.repository.CalendarDateRepository;
import com.tyss.lte.repository.TimeSheetRepository;

/**
 * @author Sahid
 *
 */
@SpringBootTest
public class TestCalendarDateServiceImpl {
	
	@Mock
	private CalendarDateRepository calendarDateRepository;
	
	@Mock
	private TimeSheetRepository timeSheetRepository;
	
	@InjectMocks
	private CalendarDateServiceImpl calendarDateServiceImpl;
	

	/**
	 * Test method for {@link com.tyss.lte.service.CalendarDateServiceImpl#saveCalendarDate(com.tyss.lte.pojo.CalendarDatePojo)}.
	 */
	@Test
	public void testSaveCalendarDate() {
		LocalTime loginTime = LocalTime.parse("09:30");
		LocalTime logoutTime = LocalTime.parse("11:30");
		LocalDate date=LocalDate.parse("2021-12-11");
		TimeSheet timeSheet = new TimeSheet(100, "TYC0821230", "ESS Lite", "sahid@testyantra.in",
				"sahidalom1234@gmail.com", "JANUARY", loginTime, logoutTime);
		CalendarDate calendarDate = new CalendarDate(100, "Work day", loginTime, logoutTime, date, "Work Done", timeSheet);
		CalendarDatePojo calendarDatePojo = new CalendarDatePojo(100, "Work day", loginTime, logoutTime, date, "Work Done", timeSheet);
		Mockito.when(timeSheetRepository.findByTimeSheetId(Mockito.any())).thenReturn(timeSheet);
		Mockito.when(calendarDateRepository.save(Mockito.any())).thenReturn(calendarDate);
		CalendarDate calendarDate2 = calendarDateServiceImpl.saveCalendarDate(calendarDatePojo);
		assertEquals(calendarDate.getCalendarDateId(), calendarDate2.getCalendarDateId());
	}

	/**
	 * Test method for {@link com.tyss.lte.service.CalendarDateServiceImpl#getCalendarDate(java.lang.String, java.time.LocalDate)}.
	 */
	@Test
	public void testGetCalendarDate() {
		LocalTime loginTime = LocalTime.parse("09:30");
		LocalTime logoutTime = LocalTime.parse("11:30");
		LocalDate date=LocalDate.parse("2021-12-11");
		CalendarDate calendarDate = new CalendarDate(100, "Work day", loginTime, logoutTime, date, "Work DOne", null);
		TimeSheet timeSheet = new TimeSheet(100, "TYC0821230", "ESS Lite", "sahid@testyantra.in",
				"sahidalom1234@gmail.com", "JANUARY", loginTime, logoutTime);
		calendarDate.setTimeSheet(timeSheet);
		List<CalendarDate>  calendarDates=new ArrayList<>();
		calendarDates.add(calendarDate);
		Mockito.when(calendarDateRepository.findByDate(Mockito.any())).thenReturn(calendarDates);
		CalendarDate calendarDate2 = calendarDateServiceImpl.getCalendarDate(calendarDate.getTimeSheet().getEmployeeId(), calendarDate.getDate());
		assertEquals(calendarDate.getCalendarDateId(), calendarDate2.getCalendarDateId());
	}

	/**
	 * Test method for {@link com.tyss.lte.service.CalendarDateServiceImpl#deleteCalendarDate(java.lang.String, java.time.LocalDate)}.
	 */
	@Test
	public void testDeleteCalendarDate() {
		LocalTime loginTime = LocalTime.parse("09:30");
		LocalTime logoutTime = LocalTime.parse("11:30");
		LocalDate date=LocalDate.parse("2021-12-11");
		CalendarDate calendarDate = new CalendarDate(100, "Work day", loginTime, logoutTime, date, "Work DOne", null);
		TimeSheet timeSheet = new TimeSheet(100, "TYC0821230", "ESS Lite", "sahid@testyantra.in",
				"sahidalom1234@gmail.com", "JANUARY", loginTime, logoutTime);
		calendarDate.setTimeSheet(timeSheet);
		List<CalendarDate>  calendarDates=new ArrayList<>();
		calendarDates.add(calendarDate);
		Mockito.when(calendarDateRepository.findByDate(Mockito.any())).thenReturn(calendarDates);
		calendarDateRepository.delete(Mockito.any());
		CalendarDate calendarDate2 = calendarDateServiceImpl.deleteCalendarDate(calendarDate.getTimeSheet().getEmployeeId(), calendarDate.getDate());
		assertEquals(calendarDate.getCalendarDateId(), calendarDate2.getCalendarDateId());	
	}

}
