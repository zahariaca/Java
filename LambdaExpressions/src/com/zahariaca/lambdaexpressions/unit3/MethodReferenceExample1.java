package com.zahariaca.lambdaexpressions.unit3;

/**
 * Created by Zaharia Costin-Alexandru, email: zaharia.c.alexandru@gmail.com on 7/6/2017.
 */
public class MethodReferenceExample1 {
    public static void main(String[] args) {

        // normal lambda expression syntax
        Thread t = new Thread(() -> printMessage());
        t.start();

        // lambda expression using method reference
        Thread t2 = new Thread(MethodReferenceExample1::printMessage); // MethodReferenceExample1::printMessage == () -> printMessage()
        t2.start();

    }

    public static void printMessage(){
        System.out.println("Hello");
    }
}
