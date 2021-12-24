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
public class TestExpenseDocument {
	
	private ObjectMapper mapper;
	private String  jsonObjExpense="{\"expenseDocumentId\":100,\"expenseDocument\":\"AQABAAA=\"}";

	@BeforeEach
	public void setup() {
		this.mapper = new ObjectMapper();
	}

	@Test
	public void testExpenseDocumentSerializable() throws JsonProcessingException {
		ExpenseDocument document = mapper.readValue(jsonObjExpense, ExpenseDocument.class);
		String jsonObjExpense = mapper.writeValueAsString(document);
		assertEquals(this.jsonObjExpense, jsonObjExpense);
	}

	@Test
	public void testExpenseDocumentDeserializable() throws JsonMappingException, JsonProcessingException {
		int expected=100;
		ExpenseDocument document = mapper.readValue(jsonObjExpense, ExpenseDocument.class);
		assertEquals(expected, document.getExpenseDocumentId());
	}

}
