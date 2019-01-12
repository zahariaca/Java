package com.zahariaca.main;

import org.apache.commons.codec.digest.DigestUtils;

import java.sql.*;
import java.util.Scanner;

public enum LoggedInHandler {
    INSTANCE;

    public void handleLoggedInUser(String username, String userId) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println(String.format("Select an operation:%n" +
                    "   [1] Add/Update address. %n" +
                    "   [2] Change password %n" +
                    "   [3] See your accounts %n" +
                    "   [4] Create an account %n" +
                    "   [5] Delete an account %n" +
                    "   [6] Check balance of an account %n" +
                    "   [7] Check balance of all accounts %n" +
                    "   [8] Send units to another account %n" +
                    "   [0] Logout %n"));

            String userInput = scanner.next();
            if (Integer.valueOf(userInput) == 0) {
                break;
            }

            try (Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/cli_login?autoReconnect=true&useSSL=false", "root", "Mon.2017")) {
                switch (Integer.valueOf(userInput)) {
                    case 1:
                        addOrUpdatePassword(con, userId);
                        break;
                    case 2:
                        changePassword(con, username, userId);
                        break;
                    case 3:
                        showAccounts(con, userId);
                        break;
                    case 4:
                        createAccount(con, userId);
                        break;
                    case 5:
                        deleteAccount(con, userId);
                        break;
                    case 6:
                        checkBalanceOfAccount(con, userId);
                        break;
                    case 7:
                        checkBalanceOfAllAccounts(con, userId);
                        break;
                    case 8:
                        transferUnits(con, userId);
                        break;
                }
            } catch (SQLIntegrityConstraintViolationException eiex) {
                System.out.println("Invalid username. Already exists!");

            } catch (SQLException e) {
                System.out.println(e);
            }
        }

        System.out.println(String.format("Logging out [%s]...%n", username));
    }


    private void addOrUpdatePassword(Connection con, String userId) throws SQLException {
/*        PreparedStatement preparedStatement = con.prepareStatement("SELECT address.street, address.city, address.country " +
                "FROM address " +
                "WHERE address.userId = (SELECT users.userId FROM users WHERE username = ?)");*/
        PreparedStatement preparedStatement = con.prepareStatement("SELECT address.street, address.city, address.country " +
                "FROM address " +
                "WHERE address.user_id = ?");
        preparedStatement.setString(1, userId);

        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
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

//            preparedStatement = con.prepareStatement("INSERT INTO address (userId, street, city, country) VALUES ((SELECT users.userId FROM users WHERE username = ?), ?, ?, ?)");
            preparedStatement = con.prepareStatement("INSERT INTO address (user_id, street, city, country) VALUES (?, ?, ?, ?)");
            preparedStatement.setString(1, userId);
            preparedStatement.setString(2, streetAddress);
            preparedStatement.setString(3, city);
            preparedStatement.setString(4, country);
            preparedStatement.execute();
        }
    }

    private void changePassword(Connection con, String username, String userId) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input your current password: ");
        String currentPasswordHash = DigestUtils.sha256Hex(scanner.next());

        PreparedStatement preparedStatement = con.prepareStatement("SELECT users.password FROM users WHERE users.user_id = ? AND users.username = ?");
        preparedStatement.setString(1, userId);
        preparedStatement.setString(2, username);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (!resultSet.next()) {
            System.out.println("ERROR: No password found in DB for user!");
            return;
        }

        String passwordFromDbHash = resultSet.getString(1);

        if (!currentPasswordHash.equals(passwordFromDbHash)) {
            System.out.println("Incorrect password. Cancelling operation!");
            return;
        }

        System.out.println("Input your new password: ");
        String firstNewPasswordHash = DigestUtils.sha256Hex(scanner.next());
        System.out.println("Input your new password again: ");
        String secondNewPasswordHash = DigestUtils.sha256Hex(scanner.next());

        if (!firstNewPasswordHash.equals(secondNewPasswordHash)) {
            System.out.println("Passwords do not match. Cancelling operation!");
            return;
        }

        preparedStatement = con.prepareStatement("UPDATE users SET password = ? WHERE users.user_id = ? AND users.username = ?");
        preparedStatement.setString(1, firstNewPasswordHash);
        preparedStatement.setString(2, userId);
        preparedStatement.setString(3, username);
        preparedStatement.execute();

        System.out.println(String.format("%nPassword successfully changed!%n"));
    }

    private void showAccounts(Connection con, String userId) throws SQLException {
        PreparedStatement preparedStatement = con.prepareStatement("SELECT * FROM accounts WHERE user_id = ?");
        preparedStatement.setString(1, userId);
        ResultSet resultSet = preparedStatement.executeQuery();

        if(!resultSet.next()) {
            System.out.println(String.format("%nYou have no accounts.%n"));
            return;
        }

        resultSet.beforeFirst();

        while(resultSet.next()) {
            System.out.println(String.format("Account [%d] -> balance: %d | user_id: %d", resultSet.getInt(1), resultSet.getInt(2), resultSet.getInt(3)));
        }
        System.out.println();
    }

    private void createAccount(Connection con, String userId) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter how many units do you want to have(lol): ");
        String balance = scanner.next();

        PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO accounts (balance, user_id) VALUES(?, ?)");
        preparedStatement.setInt(1, Integer.valueOf(balance));
        preparedStatement.setString(2, userId);
        preparedStatement.execute();

        System.out.println(String.format("%nAccount create. Enjoy your free units!%n"));

    }

    private void deleteAccount(Connection con, String userId) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the ID of the account you want to delete: ");
        int accountId = Integer.valueOf(scanner.next());

        PreparedStatement preparedStatement = con.prepareStatement("SELECT account_id, balance FROM accounts WHERE accounts.user_id = ? AND accounts.account_id = ?");
        preparedStatement.setString(1, userId);
        preparedStatement.setInt(2, accountId);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (!resultSet.next()) {
            System.out.println(String.format("Account ID is incorrect: [%s]", accountId));
            return;
        }

        int accountToBeDeletedBalance = resultSet.getInt(2);

        preparedStatement = con.prepareStatement("SELECT COUNT(*) FROM accounts WHERE accounts.user_id = ?");
        preparedStatement.setString(1, userId);
        resultSet = preparedStatement.executeQuery();

        if (resultSet.next() && resultSet.getInt(1) <= 1) {
            System.out.println(String.format("%nThis is your only account. Cannot be deleted. Nowhere to transfer your units to.%n"));
            return;
        }

        System.out.println("Enter the ID of the account you want to transfer your units to: ");
        int secondAccountId = scanner.nextInt();

        preparedStatement = con.prepareStatement("SELECT account_id, balance FROM accounts WHERE accounts.user_id = ? AND accounts.account_id = ?");
        preparedStatement.setString(1, userId);
        preparedStatement.setInt(2, secondAccountId);
        resultSet = preparedStatement.executeQuery();

        if (!resultSet.next()) {
            System.out.println(String.format("Account ID is incorrect: [%s]", secondAccountId));
            return;
        }

        int secondaryAccountBalance = resultSet.getInt(2);

        preparedStatement = con.prepareStatement("UPDATE accounts SET balance = ? WHERE accounts.user_id = ? AND accounts.account_id = ?");
        preparedStatement.setInt(1, accountToBeDeletedBalance + secondaryAccountBalance);
        preparedStatement.setString(2, userId);
        preparedStatement.setInt(3, secondAccountId);
        preparedStatement.execute();

        System.out.println(String.format("%nMoved balance from account [%d] to account [%d]", accountId, secondAccountId));

        preparedStatement = con.prepareStatement("DELETE FROM accounts WHERE accounts.user_id = ? AND accounts.account_id = ?");
        preparedStatement.setString(1, userId);
        preparedStatement.setInt(2, accountId);
        preparedStatement.execute();

        System.out.println(String.format("%nDeleted account [%d].%n", accountId));
    }


    private void checkBalanceOfAccount(Connection con, String userId) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the ID of the account you want to query: ");
        int accountId = Integer.valueOf(scanner.next());

        PreparedStatement preparedStatement = con.prepareStatement("SELECT account_id, balance FROM accounts WHERE accounts.user_id = ? AND accounts.account_id = ?");
        preparedStatement.setString(1, userId);
        preparedStatement.setInt(2, accountId);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (!resultSet.next()) {
            System.out.println(String.format("Account ID is incorrect: [%s]", accountId));
            return;
        }

        resultSet.beforeFirst();

        while(resultSet.next()) {
            System.out.println(String.format("Account [%d] -> balance: %d", resultSet.getInt(1), resultSet.getInt(2)));
        }
        System.out.println();
    }

    private void checkBalanceOfAllAccounts(Connection con, String userId) throws SQLException {
        PreparedStatement preparedStatement = con.prepareStatement("SELECT account_id, balance FROM accounts WHERE user_id = ?");
        preparedStatement.setString(1, userId);
        ResultSet resultSet = preparedStatement.executeQuery();

        if(!resultSet.next()) {
            System.out.println(String.format("%nYou have no accounts.%n"));
            return;
        }

        resultSet.beforeFirst();

        while(resultSet.next()) {
            System.out.println(String.format("Account [%d] -> balance: %d", resultSet.getInt(1), resultSet.getInt(2)));
        }
        System.out.println();
    }

    private void transferUnits(Connection con, String userId) {
        System.out.println("Unimplemented");
    }
}
