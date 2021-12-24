package com.tyss.lte.dto;
import static com.tyss.lte.common.LeaveDetailsContants.*;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor 
public class LeaveDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int leaveId;
	
	@Column
	private String type;
	
	@Column(length = 15)
	@NotBlank(message = LEAVE_TYPE_CANT_BE_NULL)
	@Pattern(regexp = LEAVE_TYPE_REGEX, message = LEAVE_TYPE_REGEX_MESSAGE)
	@Size(min = 2,message = LEAVE_TYPE_SIZE)
	private String leaveType;
	
	@Column
	private String dayType; 
	
	@Column
	@FutureOrPresent(message = FROM_DATE_LIMIT)
	private LocalDate fromDate;
	
	@Column
	@Future(message = TO_DATE_LIMIT)
	private LocalDate toDate;
	
	@Column(length = 600)
	@NotBlank(message = REASON_CANT_BE_EMPTY)
	@Size(min=10 , message = REASON_LIMIT)
	@Pattern(regexp = REASON_REGEX, message = REASON_REGEX_MESSAGE)
	private String reason;

	@Column(length = 15)
	@NotBlank(message = EMPLOYEE_ID_CANT_BE_EMPTY)
	@Pattern(regexp = EMPLOYEE_ID_REGEX, message = EMPLOYEE_ID_REGEX_MESSAGE)
	private String employeeId;
	
	@Column
	private long openingBalence;

	@Column
	private long availed;
	
	@Column
	private long lapsed;
	
	@Column
	private long encashed;
	
	@Column
	private long balence;
	
	
}
