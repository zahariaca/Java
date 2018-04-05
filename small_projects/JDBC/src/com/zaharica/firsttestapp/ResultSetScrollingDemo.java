package com.zaharica.firsttestapp;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

/**
 * Created by Zaharia Costin-Alexandru, email: zaharia.c.alexandru@gmail.com on 6/29/2016.
 */

public class ResultSetScrollingDemo {




    public static void main(String[] args) throws SQLException {

        try(
                Connection conn = DBUtil.getConnection(DBType.MYSQL);
                Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
                ResultSet resultSet = statement.executeQuery("select * from country");
                PrintWriter output = new PrintWriter(new FileWriter("outputResultSetScrolling.txt"))
                ) {
            String format="%-50s| %-20s| %-35s| %-10f %n";
            resultSet.beforeFirst();
            System.out.println("First 10 rows: ");
            output.println("************************************************************************************************************************************************");
            output.println("First 10 rows: ");
            int i =0;
            while(resultSet.next() && i <= 9){
                System.out.format(format, resultSet.getString("Name"), resultSet.getString("Continent"), resultSet.getString("Region"), resultSet.getDouble("SurfaceArea"));
                output.format(format, resultSet.getString("Name"), resultSet.getString("Continent"), resultSet.getString("Region"), resultSet.getDouble("SurfaceArea"));
                i++;
            }

            resultSet.afterLast();
            System.out.println("Last 10 rows: ");
            output.println("************************************************************************************************************************************************");
            output.println("Last 10 rows: ");
            i=0;
            while(resultSet.previous() && i <= 9){
                System.out.format(format, resultSet.getString("Name"), resultSet.getString("Continent"), resultSet.getString("Region"), resultSet.getDouble("SurfaceArea"));
                output.format(format, resultSet.getString("Name"), resultSet.getString("Continent"), resultSet.getString("Region"), resultSet.getDouble("SurfaceArea"));
                i++;
            }

            resultSet.first();
            System.out.println("First record: ");
            output.println("************************************************************************************************************************************************");
            output.println("First record: ");
            System.out.format(format, resultSet.getString("Name"), resultSet.getString("Continent"), resultSet.getString("Region"), resultSet.getDouble("SurfaceArea"));
            output.format(format, resultSet.getString("Name"), resultSet.getString("Continent"), resultSet.getString("Region"), resultSet.getDouble("SurfaceArea"));

            resultSet.last();
            System.out.println("Last record: ");
            output.println("************************************************************************************************************************************************");
            output.println("Last record: ");
            System.out.format(format, resultSet.getString("Name"), resultSet.getString("Continent"), resultSet.getString("Region"), resultSet.getDouble("SurfaceArea"));
            output.format(format, resultSet.getString("Name"), resultSet.getString("Continent"), resultSet.getString("Region"), resultSet.getDouble("SurfaceArea"));

            resultSet.absolute(4);
            System.out.println("4th record: ");
            output.println("************************************************************************************************************************************************");
            output.println("4th record: ");
            System.out.format(format, resultSet.getString("Name"), resultSet.getString("Continent"), resultSet.getString("Region"), resultSet.getDouble("SurfaceArea"));
            output.format(format, resultSet.getString("Name"), resultSet.getString("Continent"), resultSet.getString("Region"), resultSet.getDouble("SurfaceArea"));

            resultSet.relative(2);
            System.out.println("6th record: ");
            output.println("************************************************************************************************************************************************");
            output.println("6th record: ");
            System.out.format(format, resultSet.getString("Name"), resultSet.getString("Continent"), resultSet.getString("Region"), resultSet.getDouble("SurfaceArea"));
            output.format(format, resultSet.getString("Name"), resultSet.getString("Continent"), resultSet.getString("Region"), resultSet.getDouble("SurfaceArea"));

            resultSet.relative(-4);
            System.out.println("2nd record: ");
            output.println("************************************************************************************************************************************************");
            output.println("2nd record: ");
            System.out.format(format, resultSet.getString("Name"), resultSet.getString("Continent"), resultSet.getString("Region"), resultSet.getDouble("SurfaceArea"));
            output.format(format, resultSet.getString("Name"), resultSet.getString("Continent"), resultSet.getString("Region"), resultSet.getDouble("SurfaceArea"));

        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        }

    }
}
