package com.zahariaca.filescanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException{
	    int num1;
        double num2;
        String name;
        double sum;

        Scanner in = new Scanner(new File("//home//azaharia//Desktop//Development//Java//beginnerJavaExercisesWithPseudo//KbFileInput//FileScanner//src//com/azaharia//flowcontrols//in.txt"));
        num1 = in.nextInt();
        num2 = in.nextDouble();
        name = in.next();
        in.close();

        sum = num1 + num2;
        System.out.printf("Number 1 is: %s%n", num1);
        System.out.printf("Number 2 is: %s%n", num2);
        System.out.printf("String is: %s%n", name);
        System.out.printf("Sum is: %s%n", sum);
    }
}
