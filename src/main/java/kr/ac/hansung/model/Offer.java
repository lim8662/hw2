package kr.ac.hansung.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString //객체 출력
public class Offer {
	
	private int id;
	
	@Min(value=2013, message="year minimum value is 2013")
	@Max(value=2019, message="year maximum value is 2019")
	private int year;

	@Min(value=1, message="semester minimum value is 1")
	@Max(value=2, message="semester maximum value is 2")
	private int semester;
	
	@NotEmpty(message="The course_id cannot be empty")
	private String course_id;
	
	@NotEmpty(message="The title cannot be empty")
	private String title;
	
	@NotEmpty(message="The division cannot be empty")
	private String division;
	
	@Min(value=1, message="credit minimum value is 1")
	@Max(value=3, message="credit maximum value is 3")
	private int credit;

}