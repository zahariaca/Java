package com.zahariaca.circlecomputation;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    double radius;
        double area;
        double circumfrence;

        Scanner in = new Scanner(System.in);
        System.out.print("Enter a radius: ");
        radius = in.nextDouble();

        while( radius != -1){
            area = Math.PI * (radius * radius);
            circumfrence = 2 * Math.PI * radius;
            System.out.printf("The circle area is: %.2f%n", area);
            System.out.printf("The circle circumfrence is: %.2f%n", circumfrence);
            System.out.print("Enter another radius or -1 to exit: ");
            radius = in.nextDouble();
        }
    }
}
