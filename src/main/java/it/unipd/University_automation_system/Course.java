package it.unipd.University_automation_system;

public class Course {
	private int id;
	private String name;
	private int credit;

	public Course (int id, String name, int cridet) {
		this.id = id;
		this.name = name;
		this.credit = cridet;
	}
	
	public int getId () {
		return this.id;
	}

	public int getCredit () {
		return this.credit;
	}
	public String getName () {
		return this.name;
	}

	
	public void setCredit (int credit) {
		this.credit = credit;
	}
	public String toString() {
		return "id: "+id+ "Name: " +name+" Cridet: " + credit;
	}

}
