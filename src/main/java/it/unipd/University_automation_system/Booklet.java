package it.unipd.University_automation_system;


public class Booklet {
	private Integer grade;	
	private Course course;
	private Integer credit;
	
	
	public Booklet (Course course, Integer grade,Integer credit) {
		this.course = course;
		this.grade = grade;
		this.credit = credit;

	}
	
	public String toString() {
		return "Course : "+ course+ " Grade : "+""+grade+ " crdeit achived: " + credit;
	}
	
}
