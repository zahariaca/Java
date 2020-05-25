package com.zaharica.firsttestapp;

import java.sql.*;

/**
 * Created by Zaharia Costin-Alexandru, email: zaharia.c.alexandru@gmail.com on 6/29/2016.
 */

public class TestMySQLConnection {

    static String username ="root";
    static String password = "testpw";
    static String dbURL="jdbc:mysql://localhost:3306/world";


    public static void main(String[] args) throws SQLException {

        Connection conn = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            conn = DriverManager.getConnection(dbURL,username,password);
            statement = conn.createStatement();
            resultSet = statement.executeQuery("select * from country");
/*            resultSet.last();
            System.out.println("Total rows: " + resultSet.getRow());*/

            while(resultSet.next()){
                System.out.format("%-4s%-50s%-60s%-10f %n", resultSet.getString("Name"), resultSet.getString("Continent"), resultSet.getString("Region"), resultSet.getDouble("SurfaceArea"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        } finally {
            if (conn != null){
                conn.close();
            }
            if(statement!=null){
                statement.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }
        }

    }
}
