package it.unipd.University_automation_system;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as = Student.class)

public class User {


	private int id;
	@JsonProperty("first_name")
	private  String firstName;
	@JsonProperty("last_name")
	private  String lastName;
	private  String email;

	public User() {
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public User (int id, String FIRST_NAME, String LAST_NAME, String email ) {

		this.id = id;
		this.firstName = FIRST_NAME;
		this.lastName = LAST_NAME;
		this.email = email;

	}

	public int getId () {
		return id;
	}

	public String getFirstName () {
		return firstName;
	}

	public String getLastName () {
		return lastName;
	}

	public String getEmail () {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "id: "+id+ " First name: " + firstName + " last name : "+ lastName + " Email: " + email;
	}


}
