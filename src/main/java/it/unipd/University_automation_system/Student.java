
package it.unipd.University_automation_system;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonTypeName("Student")

public class Student extends User {

    public  Student (){

	}
	public Student(int id, String FIRST_NAME, String LAST_NAME, String email) {

		super(id, FIRST_NAME, LAST_NAME, email);
	}


	
}