/**
 * 
 */
package com.tyss.lte.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
import com.tyss.lte.dto.Expense;
import com.tyss.lte.dto.ExpenseDocument;
import com.tyss.lte.pojo.ExpensePojo;
import com.tyss.lte.response.ExpenseResponse;
import com.tyss.lte.service.ExpenseService;

/**
 * @author Sahid
 *
 */
@SpringBootTest
public class TestExpenseController {

	@Mock
	private ExpenseService expenseService;

	@InjectMocks
	private ExpenseController expenseController;

	private MockMvc mockMvc;
	private ObjectMapper mapper;

	@BeforeEach
	public void setup() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(expenseController).build();
		this.mapper = new ObjectMapper();
		this.mapper.findAndRegisterModules();
	}

	/**
	 * Test method for
	 * {@link com.tyss.lte.controller.ExpenseController#addExpence(java.util.List)}.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testAddExpence() throws Exception {
		String[] expenseDocuments = { "abc.png", "xyz.jpg" };
		ExpensePojo expensePojo = new ExpensePojo(100, "Traveling", "General", LocalDate.now(), 450,
				"sahid123@gmail.com", "TYC0821230", expenseDocuments, "Done", "Traveling X to Y");
		List<ExpensePojo> expensePojos = new ArrayList<>();
		expensePojos.add(expensePojo);
		List<ExpenseDocument> expenseDocumentList = new ArrayList<>();
		byte[] expenseDocument = { 1, 0, 1, 0, 0 };
		expenseDocumentList.add(new ExpenseDocument(100, expenseDocument));
		Expense expense = new Expense(100, "Traveling", "General", LocalDate.now(), 450, "sahid123@gmail.com",
				"TYC0821230", "Done", "Traveling X to Y", expenseDocumentList);
		String expected = expense.getClientMailId();
		String actual = null;
		List<Expense> expenses = new ArrayList<>();
		expenses.add(expense);
		Mockito.when(expenseService.saveExpences(Mockito.any())).thenReturn(expenses);
		String jsonObject = mapper.writeValueAsString(expensePojos);
		String result = mockMvc
				.perform(post("/api/v1/lte-inventory/expense").contentType(MediaType.APPLICATION_JSON)
						.content(jsonObject))
				.andExpect(MockMvcResultMatchers.status().isOk()).andReturn().getResponse().getContentAsString();
		ExpenseResponse expenseResponse = mapper.readValue(result, ExpenseResponse.class);
		List<Expense> expenseMap = (List<Expense>) expenseResponse.getData();
		for (Expense expense2 : expenseMap) {
			actual = expense2.getClientMailId();
			break;
		}
		assertEquals(expected, actual);
	}

	/**
	 * Test method for
	 * {@link com.tyss.lte.controller.ExpenseController#getExpences(java.lang.String)}.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testGetExpences() throws Exception {
		List<ExpenseDocument> expenseDocumentList = new ArrayList<>();
		byte[] expenseDocument = { 1, 0, 1, 0, 0 };
		expenseDocumentList.add(new ExpenseDocument(100, expenseDocument));
		Expense expense = new Expense(100, "Traveling", "General", LocalDate.now(), 450, "sahid123@gmail.com",
				"TYC0821230", "Done", "Traveling X to Y", expenseDocumentList);
		String expected = expense.getClientMailId();
		String actual = null;
		List<Expense> expenses = new ArrayList<>();
		expenses.add(expense);
		Mockito.when(expenseService.getAllExpencesByEmpId(Mockito.anyString())).thenReturn(expenses);
		String result = mockMvc.perform(get("/api/v1/lte-inventory/expense/" + expense.getEmployeeId()))
				.andExpect(MockMvcResultMatchers.status().isOk()).andReturn().getResponse().getContentAsString();
		ExpenseResponse expenseResponse = mapper.readValue(result, ExpenseResponse.class);
		List<Expense> expenseMap = (List<Expense>) expenseResponse.getData();
		for (Expense expense2 : expenseMap) {
			actual = expense2.getClientMailId();
			break;
		}
		assertEquals(expected, actual);

	}

}
