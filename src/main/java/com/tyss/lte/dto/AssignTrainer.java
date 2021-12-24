package com.tyss.lte.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AssignTrainer implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int trainerId;
	@NotBlank
	private String name;

	@NotEmpty
	@Column(columnDefinition = "LONGCLOB")
	private String[] technology;

	@NotBlank
	private String day;

	@NotBlank
//	@Pattern(regexp = "" , message = "")
	private String email;

	@ManyToOne
	@JoinColumn(name = "batch_id")
	@Valid
	private Batch batch;
}
