package com.tyss.lte.service;

import java.util.List;

import com.tyss.lte.dto.LeaveDetails;
import com.tyss.lte.exception.LeaveDeclinedException;
import com.tyss.lte.exception.LeaveDetailsException;
/**
 * This is the service interface of the Leave Details.
 * It is implemented by LeaveDetailsServiceImpl class. 
 * @author TYSS
 *
 */
public interface LeaveDetailsService {

	/**
	 * THis is the add and update method for adding the Leave details
	 * @param leave = its an object for Leave Details
	 * @return It returns an object of LeaveDetails 
	 * @throws LeaveDetailsException
	 * @throws LeaveDeclinedException 
	 */
	public LeaveDetails saveLeaveDetailos(LeaveDetails leave) throws LeaveDetailsException, LeaveDeclinedException;

	/**
	 * This is the get method for fetching the leave details based on the employee id
	 * @param employeeId
	 * @return
	 * @throws LeaveDetailsException
	 */
	public List<LeaveDetails> getAllLeavesByEmpId(String employeeId) throws LeaveDetailsException;

}
