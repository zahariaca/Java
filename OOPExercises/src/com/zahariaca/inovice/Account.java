package com.zahariaca.inovice;

/**
 * Created by Alex on 6/1/2016.
 */
public class Account {
    private int id;
    private Customer customer;
    private double balance = 0.0;

    public int getId() {
        return id;
    }
    public Customer getCustomer() {
        return customer;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Account() {}
    public Account(int id, Customer customer, double balance){
        this.id = id;
        this.customer = customer;
        this.balance = balance;
    }

    public String getCustomerName(){
        return "[ " +customer.getName() + " (" + customer.getId() + ") ]";
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", customer=" + getCustomerName() +
                ", balance=" + balance +
                '}';
    }

    public double deposit(double ammount){
        return balance += ammount;
    }

    public double withdraw(double ammout){
        if (ammout <= balance){
            balance -= ammout;
        }else{
            System.out.println("Insuficient funds!");
        }
        return balance;
    }

}
