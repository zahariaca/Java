package com.zahariaca.stringcharops.oct2dec;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String octString;
        char octChar;
        int position = 0;
        int octLenght;
        int octNumber = 0;
        int decimal = 0;
        boolean test = true;

        Scanner in = new Scanner(System.in);
        System.out.print("Enter the octal you want to convert to decimal: ");
        octString = in.next();
        octLenght = octString.length() -1;

        for (int i = octLenght; i >= 0; i--){
            octChar = octString.charAt(i);
            if ( octChar >= '0' && octChar <= '9'){
                octNumber = octChar - '0';
                decimal = decimal + (int)(octNumber*Math.pow(8,position));
            }else{
                System.out.println("ERROR. That is not a number");
                test = false;
            }
            position++;
        }
        if(test && decimal == 25) {
            System.out.println("Why do programmers think Christmas and New Years Eve are on the same day?");
        }else if(test){
            System.out.printf("The decimal value of \"%s\" is: %s%n", octString, decimal);
        }

    }
}
