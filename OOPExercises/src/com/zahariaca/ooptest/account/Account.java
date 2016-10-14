package com.zahariaca.ooptest.account;

/**
 * Created by azaharia on 31.05.2016.
 */
public class Account {
    private String id;
    private String name;
    private int balance = 0;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public Account(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Account(String id, String name, int balanse) {
        this.id = id;
        this.name = name;
        this.balance = balanse;
    }

    public int credit(int c){
        return balance += c;
    }

    public int debit(int d){
        if (d <= balance){
            balance -= d;
        }else{
            System.out.println("That amount exceeds you current balance!");
        }
        return balance;
    }
     public String toString(){
         return "Accoutn[ id= " +id+
                 ", name= " +name+
                 ", balance= " +balance+ " ]";
     }
}
