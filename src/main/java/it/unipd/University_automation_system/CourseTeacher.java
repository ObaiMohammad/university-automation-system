package it.unipd.University_automation_system;

public class CourseTeacher {
	
	private Course course;
	private Teacher teacher;

	public CourseTeacher (Course course,Teacher teacher) {
		this.course = course;
		this.teacher = teacher;

	}

	public Course getCourse() {
		return this.course;
	}

	public Teacher getTeacher() {
		return this.teacher;
	}





}
