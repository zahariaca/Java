package com.zaharica.firsttestapp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Zaharia Costin-Alexandru, email: zaharia.c.alexandru@gmail.com on 6/30/2016.
 */
public class UpdateResultSetDemo {
    public static void main(String[] args) {
        try(
                Connection conn = DBUtil.getConnection(DBType.MYSQL);
                Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ResultSet resultSet = statement.executeQuery("SELECT ID, Name, CountryCode, District, Population FROM city");
        ){
            resultSet.absolute(6);
            resultSet.updateString("Name", "ROTTERDAM");
            resultSet.updateRow();
            System.out.println("Record update succesefully!");
            resultSet.absolute(6);
            System.out.println(resultSet.getString("Name"));



        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
