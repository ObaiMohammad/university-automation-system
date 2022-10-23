package it.unipd.University_automation_system;

public class CourseStudent {
	private Course course;
	private Student student;
	private int grade;

	public CourseStudent (Course course,Student student) {
		this.course = course;
		this.student = student;

	}
	
	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	public int getGrade() {
		return this.grade ;
	}


	public Course getCourse() {
		return this.course;
	}

	public Student getStudent() {
		return this.student;
	}

}
