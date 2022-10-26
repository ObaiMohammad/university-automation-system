package it.unipd.University_automation_system;
import java.util.HashMap;
public class DataBase {


	private static HashMap <Integer ,Student> studentMap = new HashMap<>() ;
	private static  HashMap <Integer ,Course> courseMap  = new HashMap<>() ;
	private static  HashMap <Integer ,Teacher> teacherMap  = new HashMap<>() ;
	private static  HashMap <String ,CourseStudent> courseStudentMap  = new HashMap<>() ;
	private static HashMap <String ,CourseTeacher> courseTeacherMap  = new HashMap<>() ;

	public void addStudent(Student student) {
		studentMap.put(student.getId(), student);

	}
	public void addCourse(Course course) {
		courseMap.put(course.getId(), course);

	}
	public void addTeacher(Teacher teacher) {
		teacherMap.put(teacher.getId(), teacher);

	}

	public static void addCourseStudent(int courseId,int studentId) {
		String courseStudentId = courseId+""+studentId+"";
		courseStudentMap.put(courseStudentId,new CourseStudent(getCourse(courseId),getStudent(studentId)));
	}

	public static void addCourseTeacher(int courseId,int teacherId) {
		String courseTeacherId = courseId+""+teacherId+"";
		courseTeacherMap.put(courseTeacherId,new CourseTeacher(getCourse(courseId),getTeacher(teacherId)));
	}



	public void deletStudent(int studentId) {
		studentMap.remove(studentId);

	}
	public void deletCourse(int courseId) {
		courseMap.remove(courseId);

	}
	public void deletTeacher(int teacherId) {
		teacherMap.remove(teacherId);

	}

	public static Student getStudent(int studentId) {
		return studentMap.get(studentId);
	}
	public static Course getCourse(int courseId) {
		return courseMap.get(courseId);

	}
	public static Teacher getTeacher(int teacherId) {
		return teacherMap.get(teacherId);

	}

	public static CourseStudent getCourseStudent(int courseId,int studentId) {
		String courseStudentId = courseId+""+studentId+"";
		return courseStudentMap.get(courseStudentId);
	}

	public static CourseTeacher getCourseTeacher(int courseId,int teacherId) {
		String courseTeacherId = courseId+""+teacherId+"";
		return courseTeacherMap.get(courseTeacherId);
	}

	public static HashMap <String ,CourseStudent> getCourseStudentMap() {

		return courseStudentMap;
	}

	public static HashMap <String ,CourseTeacher> getCourseTeacherMap() {
		return courseTeacherMap;
	}


	public void updateStudentEmai(int studentId,String newEmail) {
		studentMap.get(studentId).setEmail(newEmail);

	}
	public void updateCourseCridet(int courseId, int newCridet) {
		courseMap.get(courseId).setCredit(newCridet);

	}
	public void updateTeacherEmail(int teacherId,String newEmail ) {
		teacherMap.get(teacherId).setEmail(newEmail);

	}



}
