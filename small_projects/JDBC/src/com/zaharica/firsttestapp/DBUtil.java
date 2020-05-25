package com.zaharica.firsttestapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Zaharia Costin-Alexandru, email: zaharia.c.alexandru@gmail.com on 6/30/2016.
 */
public class DBUtil {
    static final String usernameMySQL ="root";
    static final String passwordMySQL = "testpw";
    static final String dbURLMySQL ="jdbc:mysql://localhost:3306/world";

    static final String usernameOracle ="system";
    static final String passwordOracle = "testpw";
    static final String dbURLOracle ="jdbc:oracel:thin://localhost:1521:xe";

    public static Connection getConnection(DBType dbType) throws SQLException {
        switch (dbType){
            case MYSQL:
                return DriverManager.getConnection(dbURLMySQL, usernameMySQL, passwordMySQL);
            case OracleDB:
                return DriverManager.getConnection(dbURLOracle, usernameOracle, passwordOracle);
            default:
                return null;
        }
    }
}
