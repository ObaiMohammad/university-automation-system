package it.unipd.University_automation_system;

public class CourseStudent {
	private Course course;
	private Student student;

	public CourseStudent (Course course,Student student) {
		this.course = course;
		this.student = student;

	}

	public Course getCourse() {
		return this.course;
	}

	public Student getStudent() {
		return this.student;
	}





}
