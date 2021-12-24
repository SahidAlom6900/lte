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
public class TestExpense {

	private ObjectMapper mapper;
	private String  jsonObjExpense="{\"expenseId\":100,\"expenseType\":\"Traveling\",\"businessUnit\":\"General\",\"date\":[2021,12,18],\"totalAmount\":450.0,\"clientMailId\":\"sahid123@gmail.com\",\"employeeId\":\"TYC0821230\",\"status\":\"Done\",\"expenseDetails\":\"Traveling X to Y\",\"expenseDocumentList\":[{\"expenseDocumentId\":100,\"expenseDocument\":\"AQABAAA=\"}]}";

	@BeforeEach
	public void setup() {
		this.mapper = new ObjectMapper();
		this.mapper.findAndRegisterModules();
	}
	
	@Test
	public void testTestExpenseSerialization() throws JsonProcessingException {
		Expense expense = mapper.readValue(this.jsonObjExpense, Expense.class);
		String jsonObjExpense = mapper.writeValueAsString(expense);
		assertEquals(this.jsonObjExpense, jsonObjExpense);
	}
	@Test
	public void testTestExpenseDeserialization() throws JsonMappingException, JsonProcessingException {
		String expected="sahid123@gmail.com";
		Expense expense = mapper.readValue(this.jsonObjExpense, Expense.class);
		assertEquals(expected, expense.getClientMailId());
	}

}
