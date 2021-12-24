package com.tyss.lte.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ClientMentor implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int clientMentorId;
	
	@NotBlank
	private String name;
	
	@NotBlank
	private String designation;
	
	private long contactNumber;
	
	@NotBlank
//	@Pattern(regexp = "",message = "")
	private String email;
	
	@ManyToOne
	@JoinColumn(name="batch_id")
	private Batch batch;
}
