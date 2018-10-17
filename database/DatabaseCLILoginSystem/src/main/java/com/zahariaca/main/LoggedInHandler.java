package com.zahariaca.main;

import java.sql.*;
import java.util.Scanner;

public enum LoggedInHandler {
    INSTANCE;

    public void handleLoggedInUser(String username) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println(String.format("Select an operation:%n" +
                    "   [1] Add/Update address. %n" +
                    "   [2] Change password %n" +
                    "   [3] Logout %n"));

            String userInput = scanner.next();
            if (Integer.valueOf(userInput) == 3) {
                break;
            }

            try (Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/cli_login?autoReconnect=true&useSSL=false", "root", "Mon.2017")) {
                if (Integer.valueOf(userInput) == 1) {
                    addOrUpdatePassword(con, username);
                } else if (Integer.valueOf(userInput) == 2) {
                    changePassword(con, username);
                }
            } catch (SQLIntegrityConstraintViolationException eiex) {
                System.out.println("Invalid username. Already exists!");

            } catch (SQLException e) {
                System.out.println(e);
            }
        }

        System.out.println(String.format("Logging our...%n"));
    }

    private void addOrUpdatePassword(Connection con, String username) throws SQLException {
        PreparedStatement preparedStatement = con.prepareStatement("SELECT address.street, address.city, address.country " +
                "FROM address " +
                "WHERE address.user_id = (SELECT users.user_id FROM users WHERE username = ?)");
        preparedStatement.setString(1, username);

        ResultSet resultSet = preparedStatement.executeQuery();

        if(resultSet.next()) {
            // update address
            System.out.println(String.format("%nYour current information: %n    street address: %s, %n    city: %s, %n    country: %s%n",
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3)));
        } else {
            System.out.println(String.format("%nYou have no information stored.%n"));

            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter your street address: ");
            String streetAddress = scanner.next();
            System.out.println("Enter your city: ");
            String city = scanner.next();
            System.out.println("Enter your country: ");
            String country = scanner.next();
            System.out.println();

            preparedStatement = con.prepareStatement("INSERT INTO address (user_id, street, city, country) VALUES ((SELECT users.user_id FROM users WHERE username = ?), ?, ?, ?)");
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, streetAddress);
            preparedStatement.setString(3, city);
            preparedStatement.setString(4, country);
            preparedStatement.execute();
        }


    }

    private void changePassword(Connection con, String username) {

    }

}
