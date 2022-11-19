package it.unipd.University_automation_system;

import java.sql.*;

public class CourseRepositoryImplementation implements CourseRepository {

    @Override
    public  void addCourse(String name,String credit) {
        PreparedStatement pst ;
        String insertStudent = "call add_course(?, ?);";

        try (Connection conn = Connect.connect()) {
            pst = conn.prepareStatement(insertStudent);
            pst.setString(1,name);
            pst.setString(2,credit);
            pst.executeUpdate();
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }

    }

    @Override
    public void enrollInCourse(int courseId, int studentId) {
        PreparedStatement pst ;
        String insertStudent = "call add_course_student(?,?);";

        try (Connection conn = Connect.connect()) {
            pst = conn.prepareStatement(insertStudent);
            pst.setInt(1,studentId);
            pst.setInt(2,courseId);
            pst.executeUpdate();

        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }

    }

    @Override
    public void addTeacher(int courseId, int teacherId) {
        PreparedStatement pst ;
        String insertStudent = "call add_course_teacher(?,?);";

        try (Connection conn = Connect.connect()) {
            pst = conn.prepareStatement(insertStudent);
            pst.setInt(1,teacherId);
            pst.setInt(2,courseId);
            pst.executeUpdate();

        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }

    }

    @Override
    public void updateCredit(int courseId, int credit) {
        PreparedStatement pst ;
        String insertStudent = "call set_course_credit (?,?);";

        try (Connection conn = Connect.connect()) {
            pst = conn.prepareStatement(insertStudent);
            pst.setInt(1,courseId);
            pst.setInt(2,credit);
            pst.executeUpdate();

        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }


    }

    @Override
    public String getStudents(int courseId) {
        PreparedStatement pst ;
        String getStudents = "select * from get_student_by_course(?);";

        try (Connection conn = Connect.connect()) {
            pst = conn.prepareStatement(getStudents);
            pst.setInt(1,courseId);

            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                System.out.println( rs.getString("to_jsonb"));
                String jsonb = rs.getString("to_jsonb");

                return null;
            }
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public String getTeachers(int courseId) {
        PreparedStatement pst ;
        String getStudents = "select * from get_teacher_by_course(?);";

        try (Connection conn = Connect.connect()) {
            pst = conn.prepareStatement(getStudents);
            pst.setInt(1,courseId);

            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                System.out.println( rs.getString("to_jsonb"));
                String jsonb = rs.getString("to_jsonb");

                return null;
            }
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public void deleteEnrolledStudent(int courseId, int studentId) {
        PreparedStatement pst ;
        String insertStudent = "call delete_course_student(?,?);";

        try (Connection conn = Connect.connect()) {
            pst = conn.prepareStatement(insertStudent);
            pst.setInt(1,studentId);
            pst.setInt(2,courseId);
            pst.executeUpdate();

        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }

    }

    @Override
    public void enrollInExam(int examId,int studentId) {
        PreparedStatement pst ;
        String insertStudent = "call add_exam_student(?,?);";

        try (Connection conn = Connect.connect()) {
            pst = conn.prepareStatement(insertStudent);
            pst.setInt(2,studentId);
            pst.setInt(1,examId);
            pst.executeUpdate();

        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void addExam(int courseId, int hallId, Timestamp date) {
        PreparedStatement pst ;
        String insertStudent = "call add_exam(?,?,?);";

        try (Connection conn = Connect.connect()) {
            pst = conn.prepareStatement(insertStudent);
            pst.setInt(1,courseId);
            pst.setInt(2,hallId);
            pst.setTimestamp(3,date);
            pst.executeUpdate();

        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }


    }

    @Override
    public void deleteExam(int examId) {
        PreparedStatement pst ;
        String insertStudent = "call delete_exam(?);";

        try (Connection conn = Connect.connect()) {
            pst = conn.prepareStatement(insertStudent);
            pst.setInt(1,examId);

            pst.executeUpdate();

        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }


    }

    @Override
    public void setGrade(int examId, int studentId, int grade) {

        PreparedStatement pst ;
        String insertStudent = "call set_grade(?,?,?);";

        try (Connection conn = Connect.connect()) {
            pst = conn.prepareStatement(insertStudent);
            pst.setInt(1,studentId);
            pst.setInt(2,examId);
            pst.setInt(3,grade);
            pst.executeUpdate();

        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }

    }
}
