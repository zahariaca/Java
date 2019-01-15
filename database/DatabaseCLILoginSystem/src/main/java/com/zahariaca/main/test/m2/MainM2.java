package com.zahariaca.main.test.m2;

import org.apache.commons.codec.digest.DigestUtils;

import java.sql.*;

public class MainM2 {
    public static void main(String[] args) {
        try (Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/vendingmachine_m2?autoReconnect=true&useSSL=false", "root", "root")) {
            PreparedStatement stmt;
            stmt = con.prepareStatement("INSERT INTO users (username, password, isSupplier) VALUES (?, ?, ?)");
            stmt.setString(1, "jackson");
            stmt.setString(2, DigestUtils.sha256Hex("1234567890"));
            stmt.setInt(3, 0);

            stmt.execute();

            Statement stmt2 = con.createStatement();
            ResultSet rs = stmt2.executeQuery("SELECT * FROM users");

            while (rs.next()) {
                System.out.println(String.format("%s  %s  %s  %s",
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4)));
            }
        } catch (SQLIntegrityConstraintViolationException eiex) {
            System.out.println("Invalid username. Already exists!");

        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
