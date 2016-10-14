package com.zahariaca.inovice;

public class Main {

    public static void main(String[] args) {
        useInvoice();
        useAccount();
    }

    private static void useAccount() {
        Customer customer = new Customer(1, "Alexandru Zaharia", 50, 'M');
        Account account = new Account(customer.getId(), customer, 500);
        System.out.println(account.toString());
        account.deposit(500);
        System.out.println(account.toString());
        account.withdraw(250);
        System.out.println(account.toString());
        account.withdraw(1000);
        System.out.println(account.toString());

    }

    private static void useInvoice() {
        Customer customer = new Customer(1, "Alexandru Zaharia", 50);
        Invoice invoice = new Invoice(customer.getId(), customer, 500);
        System.out.println(invoice.toString());
    }
}
