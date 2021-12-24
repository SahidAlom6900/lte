package com.tyss.lte.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tyss.lte.dto.LeaveDetails;
import static com.tyss.lte.common.LeaveDetailsContants.*;
public interface LeaveDetailsRepository extends JpaRepository<LeaveDetails, Integer>{

	@Query(GET_ALL_LEAVE_DETAILS_BY_EMPLOYEE_ID)
	public List<LeaveDetails> findLeavesByEmployeeId(String employeeId);

	@Query("select ld from LeaveDetails ld where ld.leaveType=?1 and ld.employeeId=?2")
	public LeaveDetails getLeaveByLeaveType(String leaveType, String employeeId);
	
}
