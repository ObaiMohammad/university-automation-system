package it.unipd.University_automation_system;

public class User {
	
	private int id;
	private final String FIRST_NAME;
	private final String LAST_NAME;
	private  String email;

	public User (int id, String FIRST_NAME, String LAST_NAME,String email ) {
		this.id = id;
		this.FIRST_NAME = FIRST_NAME;
		this.LAST_NAME = LAST_NAME;
		this.email = email;

	}

	public int getId () {
		return id;	 
	}

	public String getFirstName () {
		return FIRST_NAME;	 
	}    

	public String getLastName () {
		return LAST_NAME;	 
	}

	public String getEmail () {
		return email;	 
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String toString() {
		return "id: "+id+ " First name: " +FIRST_NAME + " last name : "+LAST_NAME+ " Email: " + email;
	}


}
