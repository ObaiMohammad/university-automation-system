package it.unipd.University_automation_system;

import java.util.ArrayList;
import java.util.List;

public class CourseTeacherServices {
		private static final List<CourseTeacher> courseTeacherList = new ArrayList<>();
		
		
		public static void addCourseTeacher (Course course, Teacher teacher) {
			courseTeacherList.add(new CourseTeacher(course,teacher));
			
		}
		
		public static List <Teacher> findTeacherByCourses(int courseId) {
			
			List<Teacher> designateTeacher = new ArrayList<>();
			for (int i=0; i <courseTeacherList.size();i++ ) {
				if (courseTeacherList.get(i).getCourse().getId()==courseId) {
					designateTeacher.add(courseTeacherList.get(i).getTeacher());
				}
			}
	     return designateTeacher;
		}
		
		public static List <Course> findCourseByTeacher(int teacherId) {
			
			List<Course> taughtCourse = new ArrayList<>();
			for (int i=0; i <courseTeacherList.size();i++ ) {
				if (courseTeacherList.get(i).getTeacher().getId()==teacherId) {
					taughtCourse.add(courseTeacherList.get(i).getCourse());
				}
			}
			return taughtCourse;
		}
		
		


}
