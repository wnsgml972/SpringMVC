package kr.ac.hansung.model;


import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Subject {
	private int id;
	
	@Max(value=2019, message="year must be lower than 2019 integer")
	@Min(value=2000, message="year must be higher than 2000 integer")
	private int year;
	
	@Max(value=2, message="year must be lower than 2 integer")
	@Min(value=1, message="year must be higher than 1 integer")
	private int semester;
	
	@Size(min=5, max=8, message="subjectCode must be between 5 and 8 chars")
	private String subjectCode;


	@NotNull
	private String subjectName;
	
	@Size(min=2, max=4, message="type must be between 2 and 4 chars")
	private String type;
	
	@Max(value=3, message="year must be lower than 3 integer")
	@Min(value=1, message="year must be higher than 1 integer")
	private int grade;
}
