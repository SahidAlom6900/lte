/**
 * 
 */
package com.tyss.lte.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Sahid
 *
 */
public class TestCalendarDate {
private ObjectMapper mapper;
	
	private String jsonObject="{\"calendarDateId\":100,\"dayMessage\":\"Work day\",\"loginTime\":\"09:30\",\"logoutTime\":\"11:30\",\"date\":\"2021-12-11\",\"dailyTaskDetails\":\"Work DOne\"}";

	@BeforeEach
	public void setup() {
		this.mapper = new ObjectMapper();
		this.mapper.findAndRegisterModules();
	}

	@Test
	public void testCalendarDateSerialization() throws JsonProcessingException {
		CalendarDate calendarDate = mapper.readValue(jsonObject, CalendarDate.class);
		String jsonObject = mapper.writeValueAsString(calendarDate);
		assertEquals(this.jsonObject, jsonObject);
	}

	@Test
	public void testCalendarDateDeserialization() throws JsonMappingException, JsonProcessingException {
		int expected=100;
		CalendarDate calendarDate = mapper.readValue(jsonObject, CalendarDate.class);
		assertEquals(expected, calendarDate.getCalendarDateId());
	}


}







/*
LocalTime loginTime = LocalTime.parse("09:30");
		LocalTime logoutTime = LocalTime.parse("11:30");
		LocalDate date=LocalDate.parse("2021-12-11");
		CalendarDate calendarDate = new CalendarDate(100, "Work day", loginTime, logoutTime, date, "Work DOne", null);
		TimeSheet timeSheet = new TimeSheet(100, "TYC0821230", "ESS Lite", "sahid@testyantra.in",
				"sahidalom1234@gmail.com", "JANUARY", loginTime, logoutTime);
		calendarDate.setTimeSheet(timeSheet);
*/

