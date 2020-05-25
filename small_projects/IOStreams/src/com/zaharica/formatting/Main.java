package com.zaharica.formatting;

public class Main {

    public static void main(String[] args) {
        int i = 2;
        double r = Math.sqrt(i);

        System.out.format("The square root of %d is %f. %n", i ,r);
        System.out.println("***********************************************");
        System.out.format("%f, %1$+020.10f %n", Math.PI);
    }
}

/*
    d - formats an integer as a double
    f - formats a floating point as a decimal value
    n - line termination
    x - formats an integer as a hexadecimal value
    s - formats any value as a string
    tB - formats an integer as a locale-specific month name



 */