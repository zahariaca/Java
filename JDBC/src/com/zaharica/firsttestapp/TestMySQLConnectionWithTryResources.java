package com.zaharica.firsttestapp;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

/**
 * Created by Zaharia Costin-Alexandru, email: zaharia.c.alexandru@gmail.com on 6/29/2016.
 */

public class TestMySQLConnectionWithTryResources {

    static String username ="root";
    static String password = "testpw";
    static String dbURL="jdbc:mysql://localhost:3306/world";


    public static void main(String[] args) throws SQLException {
        PrintWriter output = null;

        try(
                Connection conn = DriverManager.getConnection(dbURL,username,password);
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("select * from country");
                ) {

/*            resultSet.last();
            System.out.println("Total rows: " + resultSet.getRow());*/
            String format="%-50s| %-20s| %-35s| %-10f %n";
            output = new PrintWriter(new FileWriter("output.txt"));
            while(resultSet.next()){
                System.out.format(format, resultSet.getString("Name"), resultSet.getString("Continent"), resultSet.getString("Region"), resultSet.getDouble("SurfaceArea"));
                output.format(format, resultSet.getString("Name"), resultSet.getString("Continent"), resultSet.getString("Region"), resultSet.getDouble("SurfaceArea"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        }

    }
}
