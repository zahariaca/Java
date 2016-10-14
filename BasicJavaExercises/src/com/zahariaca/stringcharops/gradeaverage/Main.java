package com.zahariaca.stringcharops.gradeaverage;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int numStudents = 0;
        int sum = 0;
        int average = 0;
        boolean test = true;
        boolean test2 = true;

        while(test){
            Scanner in = new Scanner(System.in);
            System.out.print("Please enter the number of students: ");
            numStudents = in.nextInt();
            if(numStudents >=0){
                test = false;
            }else{
                test = true;
            }
        }
        int[] student = new int[numStudents];
        for (int i = 0; i <= student.length -1; i++){
            while(test2) {
                Scanner in = new Scanner(System.in);
                System.out.printf("Please enter the grade of student #%s: ", i + 1);
                student[i] = in.nextInt();
                if (student[i] >= 0 && student[i] <= 100){
                    System.out.println("Invalid grade, try again [0;100]");
                    test2 = false;
                }else{
                    System.out.println("Invalid grade, try again [0;100]");
                    test2 = true;
                }
            }
            test2 = true;
            sum += student[i];
        }
        average = sum / student.length;
        System.out.printf("The average is: %s", average);
    }
}
