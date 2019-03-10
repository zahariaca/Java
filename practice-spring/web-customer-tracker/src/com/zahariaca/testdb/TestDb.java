package com.zahariaca.testdb;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;
import java.sql.*;

/**
 * @author Zaharia Costin-Alexandru (zaharia.c.alexandru@gmail.com) on 10.03.2019
 */
@WebServlet("/TestDb")
public class TestDb extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // setup connection variables
        String user = "springstudent";
        String password = "springstudent";

        String jdbcUrl = "jdbc:mysql://localhost:7000/web_customer_tracker?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        String driver = "com.mysql.jdbc.Driver";

        // get a connection

        try {
            PrintWriter out = response.getWriter();

            out.println("Connecting to jdbc URL: " + jdbcUrl);

            Class.forName(driver);

            Connection connection = DriverManager.getConnection(jdbcUrl, user, password);

            out.println("Connection successfull");

            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
