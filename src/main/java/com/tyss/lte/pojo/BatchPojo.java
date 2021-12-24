package com.tyss.lte.pojo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BatchPojo implements Serializable {
	
	private int batchId;

	@NotBlank(message = "")
	private String location;

	@NotBlank(message = "")
	private String technology;

	@FutureOrPresent(message = "")
	private LocalDate date;

	@NotBlank(message = "")
	private String toc;

	@NotEmpty(message = "")
	private String[] tyMentor;

	@NotBlank(message = "")
	private String typeOfMentor;

	private List<@Valid ClientMentorPojo> clientMentors;

	private List<@Valid AssignTrainerPojo> assignTrainers;

	@Valid
	private AssignCandidatePojo assignCandidate;
}
