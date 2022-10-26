package it.unipd.University_automation_system;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CourseStudentMapServices {


	public static void addCourseStudent (int courseId, int studentId) {
		DataBase.addCourseStudent(courseId, studentId);

	}


	public static void setGrade (int courseId, int studentId, int studentGrade) {
		DataBase.getCourseStudent(courseId, studentId).setGrade(studentGrade);
	}
	
	public static int getGrad (int courseId, int studentId) {
		return DataBase.getCourseStudent(courseId, studentId).getGrade();
	}
	
	
	

	public static List <Student> findStudentByCourse(int courseId) {
		List <Student> enrolledStudents = new ArrayList<>();
		  DataBase.getCourseStudentMap().entrySet().stream()
				                         .filter(course -> course.getKey().startsWith(courseId+""))
				                         .map(Map.Entry::getValue)
				                         .collect(Collectors.toList())
				                         .stream().forEach(courseStudent -> enrolledStudents.add(courseStudent.getStudent()));
		  return enrolledStudents;
	}


	public static List <Course> findCourseByStudent(int studentId) {

		List<Course> enrolledCourses= new ArrayList<>();
		  DataBase.getCourseStudentMap().entrySet().stream()
          .filter(student -> student.getKey().endsWith(studentId+""))
          .map(Map.Entry::getValue)
          .collect(Collectors.toList())
          .stream().forEach(courseStudent -> enrolledCourses.add(courseStudent.getCourse()));

		return enrolledCourses;
	}



}
