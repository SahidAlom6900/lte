package com.tyss.lte.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Batch implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int batchId;
	
	@NotNull(message = "")
	private String location;
	
	@NotNull(message = "")
	private String technology;
	
	@FutureOrPresent(message = "")
	private LocalDate date;
	
	@NotBlank
	private String toc;
	
	@NotEmpty
	@Column(columnDefinition = "LONGCLOB")
	private String[] tyMentor;
	
	@NotBlank
	private String typeOfMentor;
	
	@OneToMany(mappedBy = "batch")
	private List<@Valid ClientMentor> clientMentors;
	
	@OneToMany(mappedBy = "batch")
	private List<@Valid AssignTrainer> assignTrainers;
	
	@OneToOne(mappedBy = "batch")
	@Valid
	private AssignCandidate assignCandidate;
}
