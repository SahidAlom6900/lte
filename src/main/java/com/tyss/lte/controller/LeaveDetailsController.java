package com.tyss.lte.controller;
import static com.tyss.lte.common.LeaveDetailsContants.*;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.lte.dto.LeaveDetails;
import com.tyss.lte.exception.LeaveDeclinedException;
import com.tyss.lte.exception.LeaveDetailsException;
import com.tyss.lte.response.LeaveDetailsListResponse;
import com.tyss.lte.response.LeaveDetailsResponse;
import com.tyss.lte.service.LeaveDetailsService;


/**
 * This is the controller class for LeaveDetails DTO
 * Which consist of all the APIs with respect to LeaveDetails
 * @author TYSS
 *
 */




@RestController
@CrossOrigin
@RequestMapping("/api/v1/")
@Validated
public class LeaveDetailsController {
	/**
	 * This enables automatic dependency injection of LeaveDetailsService.
	 * This object is used by methods in the LeaveDetailsController to
	 * call the respective methods.
	 */
	@Autowired
	private LeaveDetailsService leaveDetailsService;
	
	
	/**
	 * This is the add and update method for Leaves
	 * @param leave
	 * @return
	 * @throws LeaveDetailsException
	 * @throws LeaveDeclinedException 
	 */
	@PostMapping("lte-inventory/leave-details")
	public ResponseEntity<LeaveDetailsResponse> addLeaveDetails(@Valid @RequestBody LeaveDetails leave) throws LeaveDetailsException, LeaveDeclinedException{
		LeaveDetails leaveResponse = leaveDetailsService.saveLeaveDetailos(leave);
		if(leaveResponse!=null) {
			return new ResponseEntity<>(new LeaveDetailsResponse(false,LEAVE_DETAILS_ADD_SUCCESS_MESSAGE,leaveResponse),HttpStatus.OK);
		}else {
			return new ResponseEntity<>(new LeaveDetailsResponse(true,LEAVE_DETAILS_ADD_FAIL_MESSAGE,null),HttpStatus.BAD_REQUEST);
		}
	}
	
	
	/**
	 * This is the get method getting the leaves for an particular employee.
	 * @param employeeId
	 * @return
	 * @throws LeaveDetailsException
	 */
	@GetMapping("lte-inventory/leave-details/{employeeId}")
	public ResponseEntity<LeaveDetailsListResponse> getLeaveDetails(@PathVariable("employeeId") String employeeId) throws LeaveDetailsException{
		List<LeaveDetails> leaveList = leaveDetailsService.getAllLeavesByEmpId(employeeId);
		if(!leaveList.isEmpty()) {
			return new ResponseEntity<>(new LeaveDetailsListResponse(false,LEAVE_DETAILS_GET_SUCCESS_MESSAGE , leaveList),HttpStatus.OK);
		}else {
			return new ResponseEntity<>(new LeaveDetailsListResponse(true,LEAVE_DETAILS_GET_FAIL_MESSAGE,leaveList),HttpStatus.BAD_REQUEST);
		}
	}
	
	
}
