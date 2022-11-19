package it.unipd.University_automation_system;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;


public interface StudentRepository {


    public  void addStudent(String firstName, String lastName, String email) ;

    public  Student getStudent(int id) ;

    public  void updateEmail(int id, String email) ;

    public  void deleteStudent(int id) ;




}
