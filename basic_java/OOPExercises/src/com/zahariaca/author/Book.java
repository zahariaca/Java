package com.zahariaca.author;

import sun.awt.AWTIcon32_security_icon_yellow16_png;

/**
 * Created by azaharia on 31.05.2016.
 */
public class Book {
    private String title;
    private Author author;
    private Author[] authors;
    private double price;
    private int qty = 0;

    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public Book(String title, Author author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public Book(String title, Author author, double price, int qty) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.qty = qty;
    }

    public Book(String title, Author[] authors, double price, int qty) {
        this.title = title;
        this.authors = authors;
        this.price = price;
        this.qty = qty;
    }

    public String getAuthors(){
        String str = "";
        int i = 0;
        for (Author author:authors){
            if(i < authors.length-1) {
                str += author.toString() + ", ";
            }else{
                str += author.toString();
            }
            i++;
        }
        return str;
    }

    public String toString(){
        return "Book[ title= " +title+ ", " +
                "{ " + getAuthors() + "} " +
                ", price= " +price+
                ",qty= " +qty+ " ]";
    }
}
