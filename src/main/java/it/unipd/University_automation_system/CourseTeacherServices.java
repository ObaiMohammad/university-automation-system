package it.unipd.University_automation_system;

import java.util.ArrayList;
import java.util.List;

public class CourseTeacherServices {
		private static final List<CourseTeacher> courseTeacherList = new ArrayList<>();
		
		
		public static void addCourseTeacher (Course course, Teacher teacher) {
			courseTeacherList.add(new CourseTeacher(course,teacher));
			
		}
		
		public static void searchTeacher(Course course) {
			int id = course.getId();
			System.out.println("the student enroled in the course: "+course.toString()+" are ");
			for (int i=0; i <courseTeacherList.size();i++ ) {
				if (courseTeacherList.get(i).getCourse().getId()==id) {
					System.out.println(courseTeacherList.get(i).getTeacher().toString());
				}else System.out.println("There are no Student enrolled in this course");
			}
		}
		


}
