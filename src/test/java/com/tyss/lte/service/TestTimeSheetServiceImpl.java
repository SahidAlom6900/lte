package com.tyss.lte.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.tyss.lte.dto.TimeSheet;
import com.tyss.lte.pojo.TimeSheetPojo;
import com.tyss.lte.repository.CalendarDateRepository;
import com.tyss.lte.repository.TimeSheetRepository;

@SpringBootTest
public class TestTimeSheetServiceImpl {
	@Mock
	private TimeSheetRepository timeSheetRepository;
	
	@Mock
	private CalendarDateRepository calendarDateRepository;

	@InjectMocks
	private TimeSheetServiceImpl timeSheetServiceImpl;

	@Test
	public void testSaveTimeSheet() {
		LocalTime loginTime = LocalTime.parse("09:30");
		LocalTime logoutTime = LocalTime.parse("11:30");
		TimeSheet timeSheet = new TimeSheet(100, "TYC0821230", "ESS Lite", "sahid@testyantra.in",
				"sahidalom1234@gmail.com", "JANUARY", loginTime, logoutTime);
		TimeSheetPojo timeSheetPojo = new TimeSheetPojo(100, "TYC0821230", "ESS Lite", "sahid@testyantra.in",
				"sahidalom1234@gmail.com", "JANUARY", loginTime, logoutTime);
		Mockito.when(timeSheetRepository.save(Mockito.any())).thenReturn(timeSheet);
		TimeSheet timeSheet2 = timeSheetServiceImpl.saveTimeSheet(timeSheetPojo);
		assertEquals(timeSheet.getTimeSheetId(), timeSheet2.getTimeSheetId());
	}

	@Test
	public void testGetTimeSheetString() {
		LocalTime loginTime = LocalTime.parse("09:30");
		LocalTime logoutTime = LocalTime.parse("11:30");
		TimeSheet timeSheet = new TimeSheet(100, "TYC0821230", "ESS Lite", "sahid@testyantra.in",
				"sahidalom1234@gmail.com", "JANUARY", loginTime, logoutTime);
		List<TimeSheet> timeSheets = new ArrayList<>();
		timeSheets.add(timeSheet);
		Mockito.when(timeSheetRepository.findByEmployeeId(Mockito.anyString())).thenReturn(timeSheets);
		List<TimeSheet> timeSheets2 = timeSheetServiceImpl.getTimeSheet(timeSheet.getEmployeeId());
		assertEquals(timeSheets.get(0).getTimeSheetId(), timeSheets2.get(0).getTimeSheetId());
	}

	@Test
	public void testDeleteTimeSheet() {
		LocalTime loginTime = LocalTime.parse("09:30");
		LocalTime logoutTime = LocalTime.parse("11:30");
		TimeSheet timeSheet = new TimeSheet(100, "TYC0821230", "ESS Lite", "sahid@testyantra.in",
				"sahidalom1234@gmail.com", "JANUARY", loginTime, logoutTime);
		List<TimeSheet> timeSheets = new ArrayList<>();
		timeSheets.add(timeSheet);
		Mockito.when(timeSheetRepository.findByEmployeeId(Mockito.anyString())).thenReturn(timeSheets);
		calendarDateRepository.deleteAll(Mockito.anyList());
		timeSheetRepository.delete(Mockito.any());
		TimeSheet timeSheet2 = timeSheetServiceImpl.deleteTimeSheet(timeSheet.getEmployeeId(),
				timeSheet.getMonth());
		assertEquals(timeSheet.getTimeSheetId(), timeSheet2.getTimeSheetId());
	}

	@Test
	public void testGetTimeSheetStringString() {
		LocalTime loginTime = LocalTime.parse("09:30");
		LocalTime logoutTime = LocalTime.parse("11:30");
		TimeSheet timeSheet = new TimeSheet(100, "TYC0821230", "ESS Lite", "sahid@testyantra.in",
				"sahidalom1234@gmail.com", "JANUARY", loginTime, logoutTime);
		List<TimeSheet> timeSheets = new ArrayList<>();
		timeSheets.add(timeSheet);
		Mockito.when(timeSheetRepository.findByEmployeeId(Mockito.anyString())).thenReturn(timeSheets);
		TimeSheet timeSheet2 = timeSheetServiceImpl.getTimeSheet(timeSheet.getEmployeeId(), timeSheet.getMonth());
		assertEquals(timeSheet.getTimeSheetId(), timeSheet2.getTimeSheetId());
	}

}
