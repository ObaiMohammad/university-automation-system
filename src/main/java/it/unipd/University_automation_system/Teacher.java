package it.unipd.University_automation_system;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("Teacher")

public class Teacher extends User {

	public Teacher(int id, String FIRST_NAME, String LAST_NAME, String email) {
		super(id, FIRST_NAME, LAST_NAME, email);
	}
	

}
