package it.unipd.University_automation_system;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CourseStudentServices {
	//	private static final ArrayList<CourseStudent> courseStudentList = new ArrayList<CourseStudent>();
	private static final List<CourseStudent> courseStudentList = new ArrayList<>();


	public static void addCourseStudent (Course course, Student student) {
		courseStudentList.add(new CourseStudent(course,student));



	}

	public Integer getGrade (int courseId, int studentId) {
		for (int i=0; i <courseStudentList.size();i++ ) {
			if (courseStudentList.get(i).getCourse().getId()==courseId
					&& courseStudentList.get(i).getStudent().getId()==studentId	) {
				return courseStudentList.get(i).getGrade();
			}

		}
		return null;
	}

	public void setGradeOneLine (int courseId, int studentId, int studentGrade) {
		List<CourseStudent> enrolledStudent =  courseStudentList.stream()
				.filter(cs -> cs.getCourse().getId() == courseId)
				.filter(cs -> cs.getStudent().getId() == studentId)
				.collect(Collectors.toList());
		enrolledStudent.get(0).setGrade(studentGrade);

	}

	public void setGradeOneLineSimplified (int courseId, int studentId, int studentGrade) {
		courseStudentList.stream()
		.filter(cs -> cs.getCourse().getId() == courseId && cs.getStudent().getId() == studentId)
		.findFirst()
		.ifPresent(cs -> cs.setGrade(studentGrade));
	}

	public static List <Student> findStudentByCourse(int courseId) {

		List<Student> enrolledStudents = new ArrayList<>();

		for (int i=0; i <courseStudentList.size();i++ ) {
			if (courseStudentList.get(i).getCourse().getId()==courseId) {
				enrolledStudents.add(courseStudentList.get(i).getStudent());
			}	
		}
		return 	enrolledStudents;
	}

	public static List<Student> searchOneLine(int courseId){
		return courseStudentList.stream().filter(cs -> cs.getCourse().getId() == courseId).map(cs -> cs.getStudent()).collect(Collectors.toList());
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
