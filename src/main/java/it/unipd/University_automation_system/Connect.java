package it.unipd.University_automation_system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {

    private static String url = "jdbc:postgresql://localhost:5432/postgres";
    private static String user = "postgres";
    private static String password = "0000";

   private static Connection cont = null;


    public static Connection connect(){


        try {
            cont = DriverManager.getConnection(url,user,password);
            System.out.println("Connected Successfully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cont;
    }

}
