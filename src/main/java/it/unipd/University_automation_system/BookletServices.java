package it.unipd.University_automation_system;

import java.util.ArrayList;

public class BookletServices {

	private static final ArrayList<Booklet> StudentBooklet = new ArrayList<>();

	private static void addStudent(int studentId) {
		Integer studentGrade = null;
		Integer courseCredit = null;
		for (Course course: CourseStudentServices.findCourseByStudent(studentId)) {
			studentGrade = CourseStudentServices.getGrade(course.getId(),studentId);
			if (studentGrade >= 60 && studentGrade != null) {
				courseCredit = course.getCredit();
			}else courseCredit = null;

			StudentBooklet.add(new Booklet(course,studentGrade,courseCredit));
		}
	}

	public static ArrayList<Booklet>  getBooklet (int studentId) {		
		addStudent(studentId);	
		for (Booklet booklet :StudentBooklet ) {
			System.out.println(booklet.toString());
		}
		return StudentBooklet;
		
	}

}
