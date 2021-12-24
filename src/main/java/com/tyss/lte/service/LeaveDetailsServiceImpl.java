package com.tyss.lte.service;

import static com.tyss.lte.common.LeaveDetailsContants.EMPLOYEE_ID_NOT_PRESENT;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tyss.lte.dto.Hrms;
import com.tyss.lte.dto.LeaveDetails;
import com.tyss.lte.exception.LeaveDeclinedException;
import com.tyss.lte.exception.LeaveDetailsException;
import com.tyss.lte.repository.HrmsRepository;
import com.tyss.lte.repository.LeaveDetailsRepository;

/**
 * 
 * @author TYSS
 *
 */
@Service
public class LeaveDetailsServiceImpl implements LeaveDetailsService {

	/**
	 * This enables automatic dependency injection of LeaveDetailsRepository
	 * interface. This object is used by methods in the LeaveDetailsServiceImpl to
	 * call the respective methods.
	 */
	@Autowired
	private LeaveDetailsRepository leaveDetailsRepository;

	@Autowired
	private HrmsRepository hrmsRepository;

	
	
	private void excelSheetReading() throws IOException { 
		FileInputStream fis = new FileInputStream(new File("D:\\TY-InternalProduct\\LTE\\Holiday excel_sheet\\leavedate.xls"));
	}
	
	/**
	 * @throws LeaveDetailsException
	 * 
	 */

	public long leaveChecking(LeaveDetails leave) {
		LocalDate fromDate = LocalDate.parse(leave.getFromDate().toString(), DateTimeFormatter.ISO_LOCAL_DATE);
		LocalDate toDate = LocalDate.parse(leave.getToDate().toString(), DateTimeFormatter.ISO_LOCAL_DATE);
		Duration diff = Duration.between(fromDate.atStartOfDay(), toDate.atStartOfDay());
		long totalDays = diff.toDays();
		
		for(int i=0;i<totalDays;i++) {
			if(fromDate.plusDays(i).getDayOfWeek().toString().equals("SUNDAY")||fromDate.plusDays(i).getDayOfWeek().toString()	.equals("SATURDAY")) {
				totalDays--;
			}
		}
		return totalDays;
	}

	@Override
	public LeaveDetails saveLeaveDetailos(LeaveDetails leave) throws LeaveDetailsException, LeaveDeclinedException {
		LeaveDetails leaveObj = leaveDetailsRepository.getLeaveByLeaveType(leave.getLeaveType(), leave.getEmployeeId());
		long dateDiff = leaveChecking(leave);
		try {
			if (leaveObj == null) {
				Hrms hrmsObj = hrmsRepository.getLeaveByEmployeeId(leave.getEmployeeId());
				long actualLeaveAmount = hrmsObj.getNoOfLeave();
				if (hrmsObj.getNoOfLeave() >= dateDiff) {
					leave.setOpeningBalence(actualLeaveAmount);
					leave.setAvailed(dateDiff);
					leave.setBalence(actualLeaveAmount - dateDiff);
					return leaveDetailsRepository.save(leave);
				} else {
					throw new LeaveDeclinedException("Leave can't be accepted. ");
				}
			} else {
				if (leaveObj.getBalence() > dateDiff) {
					long leaveLeft = leaveObj.getBalence() - dateDiff;
					leaveObj.setBalence(leaveLeft);
					leaveObj.setAvailed(leaveObj.getAvailed() + dateDiff);
					return leaveDetailsRepository.save(leaveObj);
				} else {
					throw new LeaveDeclinedException("Leave can't be accepted. ");
				}
			}
		}catch(LeaveDeclinedException ex) {
			throw ex;
		}catch(Exception ex) {
			throw new LeaveDetailsException("Leave request decliened. ");
		}
	}

	/**
	 * 
	 */
	@Override
	public List<LeaveDetails> getAllLeavesByEmpId(String employeeId) throws LeaveDetailsException {
		List<LeaveDetails> leaveList = leaveDetailsRepository.findLeavesByEmployeeId(employeeId);
		if (!leaveList.isEmpty()) {
			return leaveList;
		} else {
			throw new LeaveDetailsException(EMPLOYEE_ID_NOT_PRESENT);
		}
	}

}
