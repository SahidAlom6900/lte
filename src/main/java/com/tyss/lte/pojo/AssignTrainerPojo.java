package com.tyss.lte.pojo;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssignTrainerPojo implements Serializable{
	
	private int trainerId;
	
	@NotBlank(message = "")
	private String name;
	
	@NotEmpty(message = "")
	private String[] technology;
	
	@NotBlank(message = "")
	private String day;
	
	@NotBlank(message = "")
//	@Pattern(regexp = "" , message = "")
	private String email;
}
