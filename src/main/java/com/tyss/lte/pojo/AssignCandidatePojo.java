package com.tyss.lte.pojo;

import java.io.Serializable;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssignCandidatePojo implements Serializable{
	private int assignCandidateId;

	@NotBlank(message = "")
	private String name;

	private long contactnumber;

	@NotBlank(message = "")
	private String email;

	@NotBlank(message = "")
	private String degree;

	@NotBlank(message = "")
	private String stream;

	private int yearOfPass;

	@Digits(fraction = 2, integer = 2, message = "")
	private double percentage10Th;

	@Digits(fraction = 2, integer = 2, message = "")
	private double percentage12Th;

	@Digits(fraction = 2, integer = 2, message = "")
	private double degreeAggregate;

	@Digits(fraction = 2, integer = 2, message = "")
	private double masterAggregate;

	@NotBlank(message = "")
	private String branch;
}
