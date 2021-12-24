package com.tyss.lte.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tyss.lte.dto.ExpenseDocument;

public interface ExpenseDocumentRepository extends JpaRepository<ExpenseDocument, Integer>{

}
