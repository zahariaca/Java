package com.zahariaca.inovice;

/**
 * Created by azaharia on 01.06.2016.
 */
public class Customer {
    private int id;
    private String name;
    private int discount;
    private char gender;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public Customer(){}
    public Customer(int id, String name, int discout){
        this.id = id;
        this.name = name;
        this.discount = discout;
    }

    public Customer(int id, String name, int discount, char gender) {
        this.id = id;
        this.name = name;
        this.discount = discount;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
