package com.tyss.lte.pojo;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientMentorPojo implements Serializable {

	private int clientMentorId;

	@NotBlank(message = "")
	private String name;

	@NotBlank(message = "")
	private String designation;

	private long contactNumber;

	@NotBlank(message = "")
//	@Pattern(regexp = "",message = "")
	private String email;

}
