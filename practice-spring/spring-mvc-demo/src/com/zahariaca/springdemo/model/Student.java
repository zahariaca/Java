package com.zahariaca.springdemo.model;

import org.springframework.beans.factory.annotation.Value;

import java.util.LinkedHashMap;
import java.util.Map;

public class Student {

    private String firstName;
    private String lastName;
    private String country;

//    private Map<String, String> countryOptions;

    public Student(){
        // populate country options: used ISO country code
//        countryOptions = new LinkedHashMap<>();
//
//        countryOptions.put("BR", "Brazil");
//        countryOptions.put("FR", "France");
//        countryOptions.put("DE", "Germany");
//        countryOptions.put("IN", "India");
//        countryOptions.put("US", "United States of America");
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
