package com.zahariaca.gradestatistics;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int[] grades = readGrades();
        printArray(grades);
        System.out.printf("The average is: %.2f%n", average(grades));
        System.out.printf("The median is: %.2f%n", median(grades));
        System.out.printf("The minimum is: %s%n", minimum(grades));
        System.out.printf("The maximum is: %s%n", maximum(grades));
        System.out.printf("The standard deviation is: %.2f%n", stdDev(grades));

    }

    public static int[] readGrades(){
        int numberOfStudents, grade;
        boolean test = false;

        Scanner in = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        numberOfStudents =in.nextInt();
        int[] gradeArray = new int[numberOfStudents];
        for (int i = 0; i < gradeArray.length; i++){
            do{
                System.out.printf("Enter a grade for student %s: ", i+1);
                gradeArray[i] = in.nextInt();
                if(gradeArray[i] >= 0 && gradeArray[i] <= 100){
                    test = true;
                }else{
                    System.out.println("The number you have entered is not valid, enter a number between 0 and 100.");
                    test = false;
                }
            }while(!test);
        }
        in.close();
        return gradeArray;
    }

    public static void printArray(int [] array){
        String grades = "";
        for (int i = 0; i < array.length; i++){
            if (i < array.length -1) {
                grades += Integer.toString(array[i]) + ", ";
            }else if (i == array.length -1){
                grades += Integer.toString(array[i]);
            }
        }
        System.out.println("The grades are: {" + grades + "}");
    }

    public static double average (int[] array){
        double sum =0;
        double average;

        for (int i = 0; i < array.length; i++){
            sum += array[i];
        }
        average = sum / array.length;
        return average;
    }

    public static double median(int[] array){
        int elementPosition, middle;
        double median;

        Arrays.sort(array);
        if ( array.length % 2 == 0){
            middle = array.length / 2;
            median = (array[middle -1] + array[middle])  / 2;
        }else {
            elementPosition = (array.length + 1) / 2;
            median = array[elementPosition];
        }
        return median;
    }

    public static int minimum(int[] array){
        int minimum = array[0];
        for (int i=0; i<array.length; i++){
            if (minimum >= array[i]){
                minimum = array[i];
            }
        }
        return minimum;
    }
    public static int maximum(int[] array){
        int maximum = array[0];
        for (int i=0; i<array.length; i++){
            if (maximum <= array[i]){
                maximum = array[i];
            }
        }
        return maximum;
    }
    public static double stdDev(int[] array){
        double meanSq;
        double var = 0;
        double variance = 0;
        int arraySize;

        arraySize = array.length;
        meanSq = Math.pow(average(array),2);
        for (int i=0; i<arraySize; i++){
            var += (Math.pow(array[i],2) - meanSq);
        }
        variance = var / arraySize;
        return Math.sqrt(variance);
    }

}
