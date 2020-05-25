package com.zahariaca.stringcharops.hex2dec;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        char c = 'A';
        int num = c;
	    System.out.println(10 + c - 'A');

        String hexString;
        char hexChar;
        int decVal = 0;
        int hexLength;
        int decimal = 0;
        int position = 0;

        Scanner in = new Scanner(System.in);
        System.out.print("Please insert a hexadecimal value: ");
        hexString = in.next().toUpperCase();
        hexLength = hexString.length() -1;
        for (int i = hexLength; i >= 0; i--){
            hexChar = hexString.charAt(i);
            if ( hexChar >= '0' && hexChar <= '9'){
                decVal = hexChar -'0';
            }else if( hexChar >= 'A' && hexChar <= 'F'){
                decVal = hexChar - 'A' + 10;
            }
            decimal = decimal + (int)(decVal*(Math.pow(16,position)));
            position++;
        }
        System.out.printf("%s",decimal);
    }
}
