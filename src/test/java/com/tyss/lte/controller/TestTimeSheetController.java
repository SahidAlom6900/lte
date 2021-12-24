/**
 * 
 */
package com.tyss.lte.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.io.UnsupportedEncodingException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
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
import com.tyss.lte.dto.TimeSheet;
import com.tyss.lte.pojo.TimeSheetPojo;
import com.tyss.lte.response.TimeSheetResponse;
import com.tyss.lte.service.TimeSheetService;

/**
 * @author Sahid
 *
 */
@SpringBootTest
public class TestTimeSheetController {

	@Mock
	private TimeSheetService timeSheetService;

	@InjectMocks
	private TimeSheetController timeSheetController;

	private MockMvc mockMvc;
	private ObjectMapper mapper;

	@BeforeEach
	public void setup() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(timeSheetController).build();
		this.mapper = new ObjectMapper();
		this.mapper.findAndRegisterModules();
	}

	/**
	 * Test method for
	 * {@link com.tyss.lte.controller.TimeSheetController#addTimeSheet(com.tyss.lte.pojo.TimeSheetPojo)}.
	 * 
	 * @throws Exception
	 * @throws UnsupportedEncodingException
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testAddTimeSheet() throws UnsupportedEncodingException, Exception {
		LocalTime loginTime = LocalTime.parse("09:30");
		LocalTime logoutTime = LocalTime.parse("11:30");
		TimeSheet timeSheet = new TimeSheet(100, "TYC0821230", "ESS Lite", "sahid@testyantra.in",
				"sahidalom1234@gmail.com", "JANUARY", loginTime, logoutTime);
		TimeSheetPojo timeSheetPojo = new TimeSheetPojo(100, "TYC0821230", "ESS Lite", "sahid@testyantra.in",
				"sahidalom1234@gmail.com", "JANUARY", loginTime, logoutTime);
		Mockito.when(timeSheetService.saveTimeSheet(Mockito.any())).thenReturn(timeSheet);
		String jsonObject = mapper.writeValueAsString(timeSheetPojo);
		String result = mockMvc
				.perform(
						post("/api/v1/time-sheet/add-data").contentType(MediaType.APPLICATION_JSON).content(jsonObject))
				.andExpect(MockMvcResultMatchers.status().isOk()).andReturn().getResponse().getContentAsString();
		TimeSheetResponse timeSheetResponse = mapper.readValue(result, TimeSheetResponse.class);
		Map<String, String> timeSheetResponseMap = (Map<String, String>) timeSheetResponse.getData();
		for (Map.Entry<String, String> message : timeSheetResponseMap.entrySet()) {
			assertEquals(timeSheet.getTimeSheetId(), message.getValue());
			break;
		}
	}

	/**
	 * Test method for
	 * {@link com.tyss.lte.controller.TimeSheetController#getTimeSheet(java.lang.String)}.
	 * 
	 * @throws Exception
	 * @throws UnsupportedEncodingException
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testGetTimeSheetString() throws UnsupportedEncodingException, Exception {
		LocalTime loginTime = LocalTime.parse("09:30");
		LocalTime logoutTime = LocalTime.parse("11:30");
		TimeSheet timeSheet = new TimeSheet(100, "TYC0821230", "ESS Lite", "sahid@testyantra.in",
				"sahidalom1234@gmail.com", "JANUARY", loginTime, logoutTime);
		List<TimeSheet> timeSheets = new ArrayList<>();
		timeSheets.add(timeSheet);
		Mockito.when(timeSheetService.getTimeSheet(Mockito.anyString())).thenReturn(timeSheets);
		String result = mockMvc.perform(get("/api/v1/time-sheet/get/" + timeSheet.getEmployeeId()))
				.andExpect(MockMvcResultMatchers.status().isOk()).andReturn().getResponse().getContentAsString();
		TimeSheetResponse timeSheetResponse = mapper.readValue(result, TimeSheetResponse.class);
		List<Map<String, String>> timeSheetResponseMap = (List<Map<String, String>>) timeSheetResponse.getData();
		for (Map.Entry<String, String> message : timeSheetResponseMap.get(0).entrySet()) {
			assertEquals(timeSheet.getTimeSheetId(), message.getValue());
			break;
		}
	}

	/**
	 * Test method for
	 * 
	 * @throws Exception
	 * @throws UnsupportedEncodingException {@link com.tyss.lte.controller.TimeSheetController#removeTimeSheet(java.lang.String, int)}.
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testRemoveTimeSheet() throws UnsupportedEncodingException, Exception {
		LocalTime loginTime = LocalTime.parse("09:30");
		LocalTime logoutTime = LocalTime.parse("11:30");
		TimeSheet timeSheet = new TimeSheet(100, "TYC0821230", "ESS Lite", "sahid@testyantra.in",
				"sahidalom1234@gmail.com", "JANUARY", loginTime, logoutTime);
		Mockito.when(timeSheetService.deleteTimeSheet(Mockito.anyString(), Mockito.anyString())).thenReturn(timeSheet);
		String result = mockMvc
				.perform(delete(
						"/api/v1/time-sheet/remove/" + timeSheet.getEmployeeId() + "/" + timeSheet.getTimeSheetId()))
				.andExpect(MockMvcResultMatchers.status().isOk()).andReturn().getResponse().getContentAsString();
		TimeSheetResponse timeSheetResponse = mapper.readValue(result, TimeSheetResponse.class);
		Map<String, String> timeSheetResponseMap = (Map<String, String>) timeSheetResponse.getData();
		for (Map.Entry<String, String> message : timeSheetResponseMap.entrySet()) {
			assertEquals(timeSheet.getTimeSheetId(), message.getValue());
			break;
		}
	}

	/**
	 * Test method for
	 * {@link com.tyss.lte.controller.TimeSheetController#getTimeSheet(java.lang.String, java.lang.String)}.
	 * @throws Exception 
	 * @throws UnsupportedEncodingException 
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testGetTimeSheetStringString() throws UnsupportedEncodingException, Exception {
		LocalTime loginTime = LocalTime.parse("09:30");
		LocalTime logoutTime = LocalTime.parse("11:30");
		TimeSheet timeSheet = new TimeSheet(100, "TYC0821230", "ESS Lite", "sahid@testyantra.in",
				"sahidalom1234@gmail.com", "JANUARY", loginTime, logoutTime);
		Mockito.when(timeSheetService.getTimeSheet(Mockito.anyString(), Mockito.anyString())).thenReturn(timeSheet);
		String result = mockMvc
				.perform(get(
						"/api/v1/time-sheet/get/" + timeSheet.getEmployeeId() + "/" + timeSheet.getMonth()))
				.andExpect(MockMvcResultMatchers.status().isOk()).andReturn().getResponse().getContentAsString();
		TimeSheetResponse timeSheetResponse = mapper.readValue(result, TimeSheetResponse.class);
		Map<String, String> timeSheetResponseMap = (Map<String, String>) timeSheetResponse.getData();
		for (Map.Entry<String, String> message : timeSheetResponseMap.entrySet()) {
			assertEquals(timeSheet.getTimeSheetId(), message.getValue());
			break;
		}
	}

}
