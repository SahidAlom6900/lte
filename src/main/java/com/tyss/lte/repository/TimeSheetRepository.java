package com.tyss.lte.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tyss.lte.dto.TimeSheet;

@Repository
public interface TimeSheetRepository extends JpaRepository<TimeSheet, Integer> {
	List<TimeSheet> findByEmployeeId(String employeeId);
	TimeSheet findByTimeSheetId(int timeSheetId);
}
