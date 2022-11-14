package it.unipd.University_automation_system;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.sql.SQLException;
import java.util.List;

public interface StudentRepository {

    public void addStudent ( String firstName,String lastName, String email) throws SQLException;

    public static Student getStudent(int id) {
        return null;
    }

    public void updateEmail (String email);

    public void deleteStudent (int id);

    }
