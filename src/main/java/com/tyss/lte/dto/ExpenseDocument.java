package com.tyss.lte.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class ExpenseDocument {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int expenseDocumentId;
	
	@Column(columnDefinition = "LONGBLOB")
	private byte[] expenseDocument;
	
}
