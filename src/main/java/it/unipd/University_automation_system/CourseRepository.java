package it.unipd.University_automation_system;

import java.sql.Timestamp;



public interface CourseRepository {

    public  void addCourse(String name,String credit) ;


    public  void enrollInCourse(int courseId,int studentId) ;

    public  void addTeacher(int courseId,int teacherId) ;

    public void updateCredit (int courseId,int credit);

    public String getStudents(int courseId) ;

    public String getTeachers(int courseId) ;

    public  void deleteEnrolledStudent(int courseId,int studentId) ;

    public void enrollInExam (int examId,int studentId);


    void addExam(int courseId, int hallId, Timestamp date);

    public  void deleteExam(int examId) ;

    public  void setGrade(int examId,int studentId, int grade) ;




}
