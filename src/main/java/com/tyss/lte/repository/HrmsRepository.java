package com.tyss.lte.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tyss.lte.dto.Hrms;

public interface HrmsRepository extends JpaRepository<Hrms, Integer>{

	@Query("select h from Hrms h where h.employeeId=?1")
	Hrms getLeaveByEmployeeId(String employeeId);

}
