package com.zahariaca.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/testdb", "root", "Mon.2017");
            Statement stmt = con.createStatement();
//            stmt.execute("INSERT INTO `students` (`first_name`, `last_name`, `sex`) VALUES ('Betty', 'White', 'F')");
            ResultSet rs = stmt.executeQuery("SELECT * FROM students");
            while (rs.next())
                System.out.println(rs.getInt(1) +
                        "  " +
                        rs.getString(2) +
                        "  " +
                        rs.getString(3) +
                        "  " +
                        rs.getString(4));
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
