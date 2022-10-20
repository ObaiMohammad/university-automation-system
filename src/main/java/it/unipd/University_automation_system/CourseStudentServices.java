package it.unipd.University_automation_system;
import java.util.ArrayList;
import java.util.List;

public class CourseStudentServices {
//	private static final ArrayList<CourseStudent> courseStudentList = new ArrayList<CourseStudent>();
	private static final List<CourseStudent> courseStudentList = new ArrayList<>();
	
	
	public static void addCourseStudent (Course course, Student student) {
		courseStudentList.add(new CourseStudent(course,student));
		
//		CourseStudent temp = new CourseStudent(course,student);
//		courseStudentList.add(temp);
		
	}
	
	public static void searchStudent(Course course) {
		int id = course.getId();
		System.out.println("the student enroled in the course: "+course.toString()+" are ");
		for (int i=0; i <courseStudentList.size();i++ ) {
			if (courseStudentList.get(i).getCourse().getId()==id) {
				System.out.println(courseStudentList.get(i).getStudent().toString());
			}else System.out.println("There are no Student enrolled in this course");
		}
	}
	

}
