package com.tyss.lte.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestTimeSheet {
	
	private ObjectMapper mapper;
	
	private String jsonObject="{\"timeSheetId\":100,\"employeeId\":\"TYC0821230\",\"projectName\":\"ESS Lite\",\"teEmailId\":\"sahid@testyantra.in\",\"clientEmailId\":\"sahidalom1234@gmail.com\",\"month\":\"JANUARY\",\"loginTime\":\"09:30\",\"logoutTime\":\"11:30\",\"calendarDates\":null}";

	@BeforeEach
	public void setup() {
		this.mapper = new ObjectMapper();
		this.mapper.findAndRegisterModules();
	}

	@Test
	public void testTimeSheetSerialization() throws JsonProcessingException {
		TimeSheet timeSheet = mapper.readValue(jsonObject, TimeSheet.class);
		String jsonObject = mapper.writeValueAsString(timeSheet);
		assertEquals(this.jsonObject, jsonObject);
	}

	@Test
	public void testTimeSheetDeserialization() throws JsonMappingException, JsonProcessingException {
		int expected=100;
		TimeSheet timeSheet = mapper.readValue(jsonObject, TimeSheet.class);
		assertEquals(expected, timeSheet.getTimeSheetId());
	}

}


/*
 * LocalTime loginTime = LocalTime.parse("09:30"); LocalTime logoutTime =
 * LocalTime.parse("11:30"); TimeSheet timeSheet = new TimeSheet(100,
 * "TYC0821230", "ESS Lite", "sahid@testyantra.in", "sahidalom1234@gmail.com",
 * "JANUARY", loginTime, logoutTime);
 */
