package it.unipd.University_automation_system;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;

public class TeacherRepositoryImplementation implements TeacherRepository {


    @Override
    public void addTeacher(String firstName, String lastName, String email) {
        PreparedStatement pst ;
        String insertTeacher = "insert into teachers(first_name, last_name, email) values (?, ?, ?);";

        try (Connection conn = Connect.connect()) {
            pst = conn.prepareStatement(insertTeacher);
            pst.setString(1,firstName);
            pst.setString(2,lastName);
            pst.setString(3,email);
            pst.executeUpdate();
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }

    }

    @Override
    public Teacher getTeacher(int id) {
        PreparedStatement pst ;
        String selectStudent = "select to_jsonb(st) from (select * from teachers where id = ? )st;";

        try (Connection conn = Connect.connect()) {
            pst = conn.prepareStatement(selectStudent);
            pst.setInt(1,id);

            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                System.out.println( rs.getString("to_jsonb"));
                String jsonb = rs.getString("to_jsonb");

                String target = "}";
                String replacement = ", \"role\": \"Teacher\"}";
                String teacher = jsonb.replace(target, replacement);
                System.out.println( teacher);

                ObjectMapper objectMapper = new ObjectMapper();
                //Student std = objectMapper.readValue(jsonb, Student.class);
                Teacher tech =  objectMapper.reader().forType(Student.class).readValue(teacher);
                return tech;
            }
        }
        catch (SQLException | JsonProcessingException e){
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public void updateEmail(int id, String email) {
        PreparedStatement pst ;
        String insertStudent = "call set_teacher_email (?,?);";

        try (Connection conn = Connect.connect()) {
            pst = conn.prepareStatement(insertStudent);
            pst.setInt(1,id);
            pst.setString(2,email);
            pst.executeUpdate();

        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }

    }

    @Override
    public void deleteTeacher(int id) {
        PreparedStatement pst ;
        String insertStudent = "call delete_teacher(?);";

        try (Connection conn = Connect.connect()) {
            pst = conn.prepareStatement(insertStudent);
            pst.setInt(1,id);
            pst.executeUpdate();

        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }

    }
}
