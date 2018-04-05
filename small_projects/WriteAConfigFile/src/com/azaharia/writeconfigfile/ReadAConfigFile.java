package com.azaharia.writeconfigfile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;

/**
 * Created by Zaharia Costin-Alexandru, email: zaharia.c.alexandru@gmail.com on 11/7/2016.
 */

public class ReadAConfigFile {
    public static void main(String[] args) {
        new ReadAConfigFile().read();

    }

    private void read(){
        Properties prop = new Properties();
        Properties prop2 = System.getProperties();
        InputStream is = null;
        try{
            is = getClass().getClassLoader().getResourceAsStream("config.properties");
            if (is == null){
                System.out.println("Sorry");
                return;
            }
            prop.load(is);
            System.out.println("### : " + prop2.getProperty("dbpassword"));
            System.out.println("### : " + prop2.getProperty("testing"));
            Enumeration<?> e = prop.propertyNames();
            while (e.hasMoreElements()){
                String key = (String) e.nextElement();
                String value = prop.getProperty(key);
                System.out.println("Key : " + key + ", Value : " + value);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void printThemAll() {

        Properties prop = new Properties();
        InputStream input = null;

        try {

            String filename = "config.properties";
            input = getClass().getClassLoader().getResourceAsStream(filename);
            if (input == null) {
                System.out.println("Sorry, unable to find " + filename);
                return;
            }

            prop.load(input);

            Enumeration<?> e = prop.propertyNames();
            while (e.hasMoreElements()) {
                String key = (String) e.nextElement();
                String value = prop.getProperty(key);
                System.out.println("Key : " + key + ", Value : " + value);
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
