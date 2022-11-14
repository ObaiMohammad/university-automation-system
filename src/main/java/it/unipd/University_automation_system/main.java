package it.unipd.University_automation_system;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {

	public static void main(String[] args) {

		StudentRepositoryImplementation.getStudent(2);

//		Connect.connect();
//
//		String insertStudent = "insert into students(first_name, last_name, email) values (?, ?, ?);";
//		PreparedStatement pst;
//		try (Connection conn = Connect.connect()){
//
//			pst = conn.prepareStatement(insertStudent);
//			pst.setString(1,"Ali");
//			pst.setString(2,"Ali");
//			pst.setString(3,"Ali@gmail.com");
//			pst.executeUpdate();
//
//
//		} catch (SQLException e) {
//			throw new RuntimeException(e);
//		}

	}



}
