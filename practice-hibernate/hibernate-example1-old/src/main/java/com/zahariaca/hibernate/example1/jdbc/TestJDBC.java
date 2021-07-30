package com.zahariaca.hibernate.example1.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by Alex on 04.06.2017.
 */

public class TestJDBC {

    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Europe/Bucharest";
        String username = "hbstudent";
        String password = "hbstudent";


        try {
            System.out.println("Connecting to database: " + jdbcURL);

            Connection connection = DriverManager.getConnection(jdbcURL, username, password);

            System.out.println("Connection successful");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
