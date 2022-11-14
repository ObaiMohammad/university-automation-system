package it.unipd.University_automation_system;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.sql.Connection;
import java.sql.SQLException;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;

public class StudentRepositoryImplementation implements StudentRepository{

    @Override
    public void addStudent(String firstName, String lastName, String email) throws SQLException {
        PreparedStatement pst ;
        String insertStudent = "insert into students(first_name, last_name, email) values (?, ?, ?);";

        try (Connection conn = Connect.connect()) {
        pst = conn.prepareStatement(insertStudent);
        pst.setString(1,firstName);
        pst.setString(2,lastName);
        pst.setString(3,email);
    }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }



    public static Student getStudent(int id) {
        PreparedStatement pst ;
        String selectStudent = "select to_jsonb(st) from (select * from students where id = ? )st;";

        try (Connection conn = Connect.connect()) {
            pst = conn.prepareStatement(selectStudent);
            pst.setInt(1,id);

            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                System.out.println( rs.getString("to_jsonb"));
                String jsonb = rs.getString("to_jsonb");
                ObjectMapper objectMapper = new ObjectMapper();
                //Student std = objectMapper.readValue(jsonb, Student.class);
                Student std =  objectMapper.reader().forType(Student.class).readValue(jsonb);
                return (Student) std;


            }


        }
        catch (SQLException | JsonProcessingException e){
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public void updateEmail(String email) {

    }

    @Override
    public void deleteStudent(int id) {

    }


}
