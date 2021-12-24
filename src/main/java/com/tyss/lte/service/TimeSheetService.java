package com.tyss.lte.service;

import java.util.List;

import com.tyss.lte.dto.TimeSheet;
import com.tyss.lte.pojo.TimeSheetPojo;

public interface TimeSheetService {

	TimeSheet saveTimeSheet(TimeSheetPojo timeSheet);

	List<TimeSheet> getTimeSheet(String employeeId);

	TimeSheet deleteTimeSheet(String employeeId, String month);

	TimeSheet getTimeSheet(String employeeId, String month);
	
}
