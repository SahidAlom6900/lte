package com.tyss.lte.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AssignCandidate implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int assignCandidateId;
	
	@NotBlank(message ="" )
	private String name;
	
	private long contactnumber;
	
	@NotBlank(message ="" )
	private String email;
	
	@NotBlank(message ="" )
	private String degree;
	
	@NotBlank(message ="" )
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
	
	@NotBlank(message ="" )
	private String branch;
	
	@OneToOne
	@JoinColumn(name = "batch_id")
	@Valid
	private Batch batch;
}
