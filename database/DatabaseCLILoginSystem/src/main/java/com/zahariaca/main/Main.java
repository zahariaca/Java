package com.zahariaca.main;

import com.zahariaca.main.pojo.Address;
import com.zahariaca.main.pojo.User;
import org.apache.commons.codec.digest.DigestUtils;

import java.sql.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        boolean exitCondition = false;

        while(!exitCondition) {
            System.out.println(String.format("Select an operation:%n" +
                    "   [1] See users. %n" +
                    "   [2] Create user %n" +
                    "   [3] Login. %n"  +
                    "   [q/quit] to end process. %n"));
            String userInput = scanner.next();
            if (userInput.equalsIgnoreCase("quite") || userInput.equalsIgnoreCase("q")) {
                exitCondition = true;
                break;
            }

            try (Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/cli_login?autoReconnect=true&useSSL=false", "root", "Mon.2017")) {
                if (Integer.valueOf(userInput) == 1) {
                    queryDbForAllUsers(con);
                } else if (Integer.valueOf(userInput) == 2) {
                    createNewUser(con);
                } else if (Integer.valueOf(userInput) == 3) {
                    loginUser(con);
                }
            } catch (SQLIntegrityConstraintViolationException eiex) {
                System.out.println("Invalid username. Already exists!");

            } catch (SQLException e) {
                System.out.println(e);
            }
        }

        System.out.println("Goodbye!");
    }


    private static void queryDbForAllUsers(Connection con) throws SQLException {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM users");

        while (rs.next())
            System.out.println(String.format("%s %s  %s  %s  %s",
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5)));
    }

    private static void createNewUser(Connection con) throws SQLException {
        PreparedStatement stmt;

        Scanner scanner = new Scanner(System.in);

        String username = null;
        while (username == null) {
            System.out.println("Enter your username: ");
            username = scanner.next();

                stmt = con.prepareStatement("SELECT username FROM users WHERE username = ?");
                stmt.setString(1, username);
                ResultSet resultSet = stmt.executeQuery();

                if (resultSet.next()) {
                    System.out.println(String.format("Invalid username. Already exists! Try another username! %n"));
                    username = null;
                }
        }

        System.out.println("Enter your password: ");
        String password = scanner.next();

        System.out.println("Enter your first name: ");
        String firstName = scanner.next();
        System.out.println("Enter your last name: ");
        String lastName = scanner.next();
        System.out.println("Enter your age: ");
        int age = scanner.nextInt();
        System.out.println("Enter your sex (M/F): ");
        User.Sex sex;
        if (scanner.next().equals("M")) {
            sex = User.Sex.MALE;
        } else {
            sex = User.Sex.FEMALE;
        }
        System.out.println("Enter your street name: ");
        String streetName = scanner.next();
        System.out.println("Enter your city: ");
        String city = scanner.next();
        System.out.println("Enter your country: ");
        String country = scanner.next();

        User user = new User(username, password, firstName, lastName, age, sex, new Address(streetName, city, country));

        System.out.println("Your information: " + user);


        stmt = con.prepareStatement("INSERT INTO users (username, password, first_name, last_name, age, sex) VALUES (?, ?, ?, ?, ?, ?)");
        stmt.setString(1, user.getUsername());
        stmt.setString(2, user.getPasswordHash());
        stmt.setString(3, user.getFirstName());
        stmt.setString(4, user.getLastName());
        stmt.setString(5, String.valueOf(user.getAge()));
        stmt.setString(6, user.getSex().getType());

        stmt.execute();

        Statement stmt2 = con.createStatement();
        ResultSet rs = stmt2.executeQuery("SELECT * FROM users");

        while (rs.next()) {
            System.out.println(String.format("%s  %s  %s  %s  %s  %s  %s",
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(7)));
        }
    }


    private static void loginUser(Connection con) throws SQLException {
        PreparedStatement stmt;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your username: ");
        String username = scanner.next();

        System.out.println("Enter your password: ");
        String password = scanner.next();

        stmt = con.prepareStatement("SELECT CONCAT(first_name, '  ', last_name) FROM users WHERE username = ? AND password = ?");
        stmt.setString(1, username);
        stmt.setString(2, DigestUtils.sha256Hex(password));
        ResultSet resultSet = stmt.executeQuery();

        if (!resultSet.next()) {
            System.out.println(String.format("%nInvalid login. Try again. %n"));
        } else {
            System.out.println(String.format("%nWelcome: %s%n",
                    resultSet.getString(1)));
        }
    }

}
