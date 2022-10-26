package it.unipd.University_automation_system;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CourseTeacherMapServices {

	private static final List<CourseTeacher> courseTeacherList = new ArrayList<>();


	public static void addCourseTeacher (Course course, Teacher teacher) {
		courseTeacherList.add(new CourseTeacher(course,teacher));

	}

	public static List <Teacher> findTeacherByCourses(int courseId) {

		List<Teacher> designateTeacher = new ArrayList<>();

		DataBase.getCourseTeacherMap().entrySet().stream()
		.filter(course -> course.getKey().startsWith(courseId+""))
		.map(Map.Entry::getValue)
		.collect(Collectors.toList())
		.stream().forEach(courseStudent -> designateTeacher.add(courseStudent.getTeacher()));

		return designateTeacher;
	}

	public static List <Course> findCourseByTeacher(int teacherId) {

		List<Course> taughtCourse = new ArrayList<>();
		
		DataBase.getCourseStudentMap().entrySet().stream()
		.filter(teacher -> teacher.getKey().endsWith(teacherId+""))
		.map(Map.Entry::getValue)
		.collect(Collectors.toList())
		.stream().forEach(courseStudent -> taughtCourse.add(courseStudent.getCourse()));
		
		return taughtCourse;
	}



}
