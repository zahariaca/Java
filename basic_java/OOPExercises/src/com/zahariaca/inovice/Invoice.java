package com.zahariaca.inovice;

/**
 * Created by azaharia on 01.06.2016.
 */
public class Invoice {
    private int id;
    private Customer customer = new Customer();
    private double amount;

    public int getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Invoice(){}
    public Invoice(int id, Customer customer, double amount){
        this.id = id;
        this.customer = customer;
        this.amount = amount;
    }
    public String getCustomerName(){
        return "[ " +customer.getName() + " (" + customer.getId() + ") ]";
    }
    public double getAmountAfterDiscount(){
        return (amount - ((amount*customer.getDiscount())/100));
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", customer=" + getCustomerName() +
                ", amount=" + getAmountAfterDiscount() +
                '}';
    }
}
