package com.zaharica.consoleinput;

import java.io.Console;
import java.util.Arrays;

public class Main {
    static String login = "azaharia";
    static char[] password = {'t','e','s','t'};

    public static void main(String[] args) {
        Console c = System.console();
        if (c == null){
            System.err.println("No console available");
            System.exit(1);
        }

        String oldLogin;
        oldLogin = c.readLine("Enter you login: ");
        char[] oldPassword = c.readPassword("Enter your old password: ");

        if(verify(oldLogin,oldPassword)){
            boolean noMatch;
            do{
                char[] newPassword1 = c.readPassword("Enter your new password: ");
                char[] newPassword2 = c.readPassword("enter your new password again: ");
                noMatch= Arrays.equals(newPassword1,newPassword2);
                if(!noMatch){
                    c.format("Your passwords don't match. Try again! %n");
                }else{
                    change(oldLogin, newPassword1);
                    c.format("Password for %s has been changed! %n", login);
                }
                Arrays.fill(newPassword1, ' ');
                Arrays.fill(newPassword2, ' ');
            }while(noMatch);
        }
    }

    private static boolean verify(String oldLogin, char[] oldPassword){

        if((oldLogin == login) && (oldPassword == password)){
            return true;
        }else{
            return false;
        }
    }
    private static void change(String oldLogin, char[] newPassword){
        login = oldLogin;
        password = newPassword;
    }
}
