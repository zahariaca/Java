package com.zahariaca.kbscanner;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int num1;
        double num2;
        String name;
        double sum;

        Scanner in = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        num1 = in.nextInt();
        System.out.print("Enter a floating point number: ");
        num2 = in.nextDouble();
        System.out.printf("Enter a string: ");
        name = in.next();
        in.close();

        sum = num1 * num2;
        System.out.printf("Number 1 is: %s%n", num1);
        System.out.printf("Number 2 is: %s%n", num2);
        System.out.printf("String is: %s%n", name);
        System.out.printf("Sum is: %s", sum);

    }
}
