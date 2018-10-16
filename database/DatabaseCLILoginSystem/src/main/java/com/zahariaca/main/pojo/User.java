package com.zahariaca.main.pojo;

import org.apache.commons.codec.digest.DigestUtils;

public class User {
    private String username;
    private String passwordHash;
    private String firstName;
    private String lastName;
    private int age;
    private Sex sex;
    private Address address;


    public User(String username, String password, String firstName, String lastName, int age, Sex sex, Address address) {
        this.username = username;
        this.passwordHash = DigestUtils.sha256Hex(password);
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.sex = sex;
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public Sex getSex() {
        return sex;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                "password='" + passwordHash + '\'' +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", address=" + address +
                '}';
    }

    public enum Sex {
        MALE("M"), FEMALE("F");

        private String type;

        private Sex(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }
    }
}
