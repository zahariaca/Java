package com.zahariaca.ooptest.testoop;

import com.zahariaca.ooptest.account.Account;
import com.zahariaca.ooptest.circle.Circle;
import com.zahariaca.ooptest.date.Date;
import com.zahariaca.ooptest.employee.Employee;
import com.zahariaca.ooptest.invoiceitem.InvoiceItem;
import com.zahariaca.ooptest.rectangle.Rectangle;

public class Main {

    public static void main(String[] args) {
        circle();
        rectagle();
        employee();
        invoiceitem();
        account();
        date();
    }

    static void circle(){
        Circle c1 = new Circle();
        System.out.println( "The circle radius is : " + c1.getRadius() + " and area is: " + c1.getArea() + " and color is: " + c1.getColor());

        Circle c2 = new Circle(2.0);
        System.out.println( "The circle radius is : " + c2.getRadius() + " and area is: " + c2.getArea() + " and color is: " + c2.getColor());

        Circle c3 = new Circle();
        c3.setRadius(5.0);
        c3.setColor("blue");
        System.out.println( "The circle radius is : " + c3.getRadius() + " and area is: " + c3.getArea()+ " and color is: " + c3.getColor());

        Circle c4 = new Circle(5.0, "green");
        System.out.println(c4.toString());
    }

    static void rectagle(){
        Rectangle r1 = new Rectangle(2.0f, 2.0f);
        System.out.println(r1.toString());
    }

    static void employee(){
        Employee e1 = new Employee(1, "Andrei", "Popescu", 500);
        System.out.println("Old: " + e1.toString());
        e1.raisesalary(10);
        System.out.println("New: " + e1.toString());
    }

    static void invoiceitem(){
        InvoiceItem i1 = new InvoiceItem("1", 3, "potatoe", 4);
        System.out.println(i1.toString());
    }

    static void account(){
        Account a1 = new Account("1", "Andrei Popescu", 500);
        System.out.println(a1.toString());
        a1.credit(500);
        System.out.println(a1.toString());
        a1.debit(300);
        System.out.println(a1.toString());
    }

    static void date(){
        Date d1 = new Date(3,30,2015);
        d1.setDate();
        System.out.println(d1.toString());
    }
}
