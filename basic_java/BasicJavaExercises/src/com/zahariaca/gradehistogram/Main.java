package com.zahariaca.gradehistogram;

import java.util.Scanner;

public class Main {
    private int max = 0;
    private int[] bins = new int[10];

    public static void main(String[] args) {
        Main main = new Main();
        //int[] grades = main.readGrades();
        int[] grades = main.readGrades();
        main.computeHistogram(grades);
        //main.printBins();
        main.maxBins();
        main.drawHorizontalHistogram();
        System.out.println("--------------------------------------------------------------------------------");
        main.drawVerticalHistogram();
    }



    private int[] readGrades(){
        int nrOfStudents;
        boolean test = false;

        Scanner in = new Scanner(System.in);

        do {
            System.out.print("Please input the number of students: ");
            nrOfStudents = in.nextInt();
            if(nrOfStudents > 0){
                test = true;
            }else{
                System.out.println("The number of students you have entered is not valid!");
            }
        }while(!test);
        test = false;

        int[] grades = new int[nrOfStudents];
        for (int i = 0; i<grades.length; i++){
            do {
                System.out.printf("Please input the grade for student #%s: ", i);
                grades[i] = in.nextInt();
                if(grades[i] >= 0 && grades[i] <= 100){
                    test = true;
                }else{
                    System.out.println("The grade you have entered is not valid! Please input a number between 0 and 100!(");
                }
            }while(!test);
            test = false;
        }
        return grades;
    }


    private void computeHistogram(int[] grades){
        for(int i = 0; i < grades.length; i++) {
            int j = (grades[i] == 100) ? 9 : grades[i] / 10;
            bins[j] += 1;
        }
    }

    private void printBins(){
        for (int i = 0; i <= bins.length -1; i++){
            System.out.print(bins[i] + " ");
        }
        System.out.println();
    }

    private void maxBins(){
        for (int i=0; i<bins.length; i++){
            if (max < bins[i]){
                max = bins[i];
            }
        }
    }

    private void drawHorizontalHistogram(){
        for (int row =0; row <= bins.length -1; row++){
            for( int col = 0; col <= bins[row]; col++) {
                if(col == 0){
                    int delta = (row == bins.length-1) ? 10:9;
                    System.out.printf("%2d -%3d:", (row*10), (row*10 + delta));
                }else {
                    System.out.printf("%2s", "|*|");
                }
            }
            System.out.println();
        }
    }

    private void drawVerticalHistogram(){
        for (int row=max; row >= 0; row--){
            if(row ==0){
                for(int col=0;col<bins.length; col++){
                    int delta = (col == bins.length-1) ? 10:9;
                    System.out.printf("|%2d-%-2d| ", (col*10), (col*10 + delta));
                }
            }else {
                for (int j = 0; j < bins.length; j++) {
                    String str = (bins[j] < row) ? " " : "|*|";
                    System.out.printf("%4s%-4s", str, " ");
                }
            }
            System.out.println();
        }
    }
}
