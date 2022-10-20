package it.unipd.University_automation_system;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CourseStudentServices {
//	private static final ArrayList<CourseStudent> courseStudentList = new ArrayList<CourseStudent>();
	private static final List<CourseStudent> courseStudentList = new ArrayList<>();
	
	
	public static void addCourseStudent (Course course, Student student) {
		courseStudentList.add(new CourseStudent(course,student));
		

		
	}
	
	public static List <Student> findStudentByCourse(Course course) {
		int id = course.getId();
		List<Student> enrolledStudents = new ArrayList<>();
		
		for (int i=0; i <courseStudentList.size();i++ ) {
			if (courseStudentList.get(i).getCourse().getId()==id) {
				enrolledStudents.add(courseStudentList.get(i).getStudent());
			}	
		}
	return 	enrolledStudents;
	}
	
	public static List<Student> searchOneLine(Course course){
		return courseStudentList.stream().filter(cs -> cs.getCourse().getId() == course.getId()).map(cs -> cs.getStudent()).collect(Collectors.toList());
	}
	
	public static List <Course> findCourseByStudent(int studentId) {
		
		List<Course> enrolledCourses= new ArrayList<>();
		for (int i=0; i <courseStudentList.size();i++ ) {
			if (courseStudentList.get(i).getStudent().getId()==studentId) {
				enrolledCourses.add(courseStudentList.get(i).getCourse());
			}
		}
		return enrolledCourses;
	}
	

}
