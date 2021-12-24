/**
 * 
 */
package com.tyss.lte.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tyss.lte.dto.CalendarDate;
import com.tyss.lte.dto.TimeSheet;
import com.tyss.lte.pojo.CalendarDatePojo;
import com.tyss.lte.response.CalendarDateResponse;
import com.tyss.lte.service.CalendarDateService;

/**
 * @author Sahid
 *
 */
@SpringBootTest
public class TestCalendarDateController {
	
	@Mock
	private CalendarDateService calendarDateService;
	
	@InjectMocks
	private CalendarDateController calendarDateController;
	
	private MockMvc mockMvc;
	private ObjectMapper mapper;

	@BeforeEach
	public void setup() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(calendarDateController).build();
		this.mapper = new ObjectMapper();
		this.mapper.findAndRegisterModules();
	}
	

	/**
	 * Test method for {@link com.tyss.lte.controller.CalendarDateController#addCalendarDate(com.tyss.lte.pojo.CalendarDatePojo)}.
	 * @throws Exception 
	 * @throws UnsupportedEncodingException 
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testAddCalendarDate() throws UnsupportedEncodingException, Exception {
		LocalTime loginTime = LocalTime.parse("09:30");
		LocalTime logoutTime = LocalTime.parse("11:30");
		LocalDate date=LocalDate.parse("2021-12-11");
		CalendarDate calendarDate = new CalendarDate(100, "Work day", loginTime, logoutTime, date, "Work DOne", null);
		CalendarDatePojo calendarDatePojo = new CalendarDatePojo(100, "Work day", loginTime, logoutTime, date, "Work DOne", null);
		Mockito.when(calendarDateService.saveCalendarDate(Mockito.any())).thenReturn(calendarDate);
		String jsonObject = mapper.writeValueAsString(calendarDatePojo);
		String result = mockMvc
				.perform(
						post("/api/v1/calendar-date/add-data").contentType(MediaType.APPLICATION_JSON).content(jsonObject))
				.andExpect(MockMvcResultMatchers.status().isOk()).andReturn().getResponse().getContentAsString();
		CalendarDateResponse calendarDateResponse = mapper.readValue(result, CalendarDateResponse.class);
		Map<String, String> timeSheetResponseMap = (Map<String, String>) calendarDateResponse.getData();
		for (Map.Entry<String, String> message : timeSheetResponseMap.entrySet()) {
			assertEquals(calendarDate.getCalendarDateId(), message.getValue());
			break;
		}
	}

	/**
	 * Test method for {@link com.tyss.lte.controller.CalendarDateController#getCalendarDate(java.lang.String, java.lang.String)}.
	 * @throws Exception 
	 * @throws UnsupportedEncodingException 
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testGetCalendarDate() throws UnsupportedEncodingException, Exception {
		LocalTime loginTime = LocalTime.parse("09:30");
		LocalTime logoutTime = LocalTime.parse("11:30");
		LocalDate date=LocalDate.parse("2021-12-11");
		CalendarDate calendarDate = new CalendarDate(100, "Work day", loginTime, logoutTime, date, "Work DOne", null);
		TimeSheet timeSheet = new TimeSheet(100, "TYC0821230", "ESS Lite", "sahid@testyantra.in",
				"sahidalom1234@gmail.com", "JANUARY", loginTime, logoutTime);
		calendarDate.setTimeSheet(timeSheet);
		Mockito.when(calendarDateService.getCalendarDate(Mockito.anyString(), Mockito.any())).thenReturn(calendarDate);
		String result = mockMvc
				.perform(
						get("/api/v1/calendar-date/"+calendarDate.getTimeSheet().getEmployeeId()+"/"+"2021-12-11"))
				.andExpect(MockMvcResultMatchers.status().isOk()).andReturn().getResponse().getContentAsString();
		CalendarDateResponse calendarDateResponse = mapper.readValue(result, CalendarDateResponse.class);
		Map<String, String> timeSheetResponseMap = (Map<String, String>) calendarDateResponse.getData();
		for (Map.Entry<String, String> message : timeSheetResponseMap.entrySet()) {
			assertEquals(calendarDate.getCalendarDateId(), message.getValue());
			break;
		}
	}

	/**
	 * Test method for {@link com.tyss.lte.controller.CalendarDateController#deleteCalendarDate(java.lang.String, java.lang.String)}.
	 * @throws Exception 
	 * @throws UnsupportedEncodingException 
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testDeleteCalendarDate() throws UnsupportedEncodingException, Exception {
		LocalTime loginTime = LocalTime.parse("09:30");
		LocalTime logoutTime = LocalTime.parse("11:30");
		LocalDate date=LocalDate.parse("2021-12-11");
		CalendarDate calendarDate = new CalendarDate(100, "Work day", loginTime, logoutTime, date, "Work DOne", null);
		TimeSheet timeSheet = new TimeSheet(100, "TYC0821230", "ESS Lite", "sahid@testyantra.in",
				"sahidalom1234@gmail.com", "JANUARY", loginTime, logoutTime);
		calendarDate.setTimeSheet(timeSheet);
		Mockito.when(calendarDateService.deleteCalendarDate(Mockito.anyString(), Mockito.any())).thenReturn(calendarDate);
		String result = mockMvc
				.perform(
						delete("/api/v1/calendar-date/"+calendarDate.getTimeSheet().getEmployeeId()+"/"+"2021-12-11"))
				.andExpect(MockMvcResultMatchers.status().isOk()).andReturn().getResponse().getContentAsString();
		CalendarDateResponse calendarDateResponse = mapper.readValue(result, CalendarDateResponse.class);
		Map<String, String> timeSheetResponseMap = (Map<String, String>) calendarDateResponse.getData();
		for (Map.Entry<String, String> message : timeSheetResponseMap.entrySet()) {
			assertEquals(calendarDate.getCalendarDateId(), message.getValue());
			break;
		}
	}

}
