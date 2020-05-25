package com.azaharia.configurationloader;

public class Main {

    public static void main(String[] args) {
        ConfigurationLoader.getInstance();
        System.out.println(ConfigurationLoader.getInstance().getProperty("prop4"));

    }
}
