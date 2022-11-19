package it.unipd.University_automation_system;

import java.time.LocalDateTime;

public interface TeacherRepository {

    public  void addTeacher(String firstName, String lastName, String email) ;

    public  Teacher getTeacher(int id);

    public  void updateEmail(int id, String email) ;

    public  void deleteTeacher(int id) ;




}
