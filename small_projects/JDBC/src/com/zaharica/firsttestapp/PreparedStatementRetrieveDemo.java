package com.zaharica.firsttestapp;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Zaharia Costin-Alexandru, email: zaharia.c.alexandru@gmail.com on 6/30/2016.
 */
public class PreparedStatementRetrieveDemo {
    static String sql = "SELECT * FROM city WHERE Population < ? and ID > ?";
    static String format="%-50s| %-20s| %-35s| %-4s %n";

    public static void main(String[] args) throws SQLException {


        Connection conn= null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet=null;
        try{
            conn = DBUtil.getConnection(DBType.MYSQL);
            preparedStatement = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            prepareStatement(preparedStatement,5000,15);

        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        } finally {
            if (conn!=null){
                conn.close();
            }
            if(preparedStatement!=null){
                preparedStatement.close();
            }
            if(resultSet!=null){
                resultSet.close();
            }
        }
    }

    private static void prepareStatement(PreparedStatement preparedStatement, double population, double id){
        ResultSet resultSet= null;
        PrintWriter output = null;
        try {
            preparedStatement.setDouble(1, population);
            preparedStatement.setDouble(2,id);
            resultSet = preparedStatement.executeQuery();
            output = new PrintWriter(new FileWriter("outputPreparedStatement.txt"));

            while(resultSet.next()) {
                System.out.format(format, resultSet.getString("ID"), resultSet.getString("Name"), resultSet.getString("District"), resultSet.getInt("Population"));
                output.format(format, resultSet.getString("ID"), resultSet.getString("Name"), resultSet.getString("District"), resultSet.getInt("Population"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(output!=null){
                output.close();
            }
        }


    }
}
