package com.zahariaca.author;

public class Main {

    public static void main(String[] args) {
        /*Author aZaharia = new Author("Alexandru Zaharia", "zahal3x@gmail.con", 'M');
        aZaharia.setEmail("zaharia.c.alexandru@gmail.com");
        System.out.println("Name is: " + aZaharia.getName());
        System.out.println("Email is: " + aZaharia.getEmail());
        System.out.println("Gender is: " + aZaharia.getGender());
        System.out.println(aZaharia.toString());

        Book book1 = new Book("Java for dummies", aZaharia, 500);
        book1.setQty(2);
        System.out.println("Title is: " + book1.getTitle());
        System.out.println("Price is: " + book1.getPrice());
        System.out.println("Qty is: " + book1.getQty());
        System.out.println(book1.toString());
        System.out.println("Name is: " + aZaharia.getName());
        System.out.println("Email is: " + aZaharia.getEmail());
        System.out.println("Gender is: " + aZaharia.getGender());
        System.out.println(aZaharia.toString()); */


        Author[] authors = new Author[4];
        authors[0] = new Author("Tan Ah Teck", "AhTeck@somewhere.com", 'm');
        authors[1] = new Author("Paul Tan", "Paul@nowhere.com", 'm');
        authors[2] = new Author("Tan Ah Teck", "AhTeck@somewhere.com", 'm');
        authors[3] = new Author("Paul Tan", "Paul@nowhere.com", 'm');

        Book book2 = new Book("Java for dummies 2", authors, 600, 2);
        System.out.println("Title is: " + book2.getTitle());
        System.out.println("Price is: " + book2.getPrice());
        System.out.println("Qty is: " + book2.getQty());
        System.out.println(book2.toString());


    }
}
