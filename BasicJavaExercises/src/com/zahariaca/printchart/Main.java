package com.zahariaca.printchart;

import java.util.Scanner;

public class Main {
    private int[] barsArray;

    public static void main(String[] args) {
	    Main main = new Main();
        main.readInput();
        main.printValues();
    }

    private void readInput(){
        int bars;
        boolean test = false;
        Scanner in = new Scanner(System.in);
        do{
            System.out.print("Input the number of bars: ");
            bars = in.nextInt();
            if (bars > 0){
                test = true;
            }else{
                test = false;
            }
        }while(!test);
        barsArray = new int[bars];
        do{
            for (int i = 0; i < barsArray.length; i++) {
                System.out.printf("Input bar #%s value: ", i+1);
                barsArray[i] = in.nextInt();
                if (barsArray[i] > 0) {
                    test = true;
                } else {
                    test = false;
                }
            }
        }while(!test);
    }

    private void printValues(){
        for (int i = 0; i<barsArray.length; i++){
            for (int j = 0; j<barsArray[i]; j++){
                System.out.print("*");
            }
            System.out.printf(" (%s)%n",barsArray[i]);
        }
    }
}
