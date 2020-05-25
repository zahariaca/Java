package com.zahariaca.stringcharops.radix2dec;

import java.util.Scanner;

public class Main {

        public static void main(String[] args) {
            String nrToChange = "";
            char nrChar;
            String radix = "";
            char raChar;
            int position = 0;
            int nrLenght;
            int raLenght;
            int digit =0;
            int radixInt;
            int decimal = 0;
            boolean test1 = true, test2 = true;
            boolean scannerTest = true;

            while(scannerTest) {
                Scanner in = new Scanner(System.in);
                System.out.print("Enter the number you want to convert to decimal: ");
                nrToChange = in.next();
                nrLenght = nrToChange.length() -1;
                for (int i = nrLenght; i >= 0; i--) {
                    nrChar = nrToChange.charAt(i);
                    if (nrChar >= '0' && nrChar <= '9') {
                        test1 = true;
                    }else {
                        test1 = false;
                    }
                }
                if (test1 == true){
                    scannerTest = false;
                }else {
                    scannerTest = true;
                }
                System.out.print("Enter a radix for the number you are changing: ");
                radix = in.next();
                raLenght = radix.length() -1;
                for (int i = raLenght; i >= 0; i--) {
                    raChar = radix.charAt(i);
                    if (raChar >= '0' && raChar <= '9') {
                        test2 = true;
                    }else {
                        test2 = false;
                    }
                }
                if (test1==true && test2 == true){
                    scannerTest = false;
                }else{
                    scannerTest = true;
                }
            }
            nrLenght = nrToChange.length() -1;
            for (int i = nrLenght; i >= 0; i--){
                nrChar = nrToChange.charAt(i);
                digit = Integer.parseInt(String.valueOf(nrChar));
                radixInt = Integer.parseInt(String.valueOf(radix));
                decimal = decimal + (int)(digit*Math.pow(radixInt,position));
                position++;
            }
            if(!scannerTest && decimal == 25) {
                System.out.println("Why do programmers think Christmas and New Years Eve are on the same day?");
            }else if(!scannerTest){
                System.out.printf("The decimal value of \"%s\" is: %s%n", nrToChange, decimal);
            }

        }
}
