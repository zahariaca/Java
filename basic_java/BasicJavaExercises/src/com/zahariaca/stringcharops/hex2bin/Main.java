package com.zahariaca.stringcharops.hex2bin;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String hexString = "";
        char hexChar;
        int hexLength;
        int decVal;
        String  binVal ="";
        boolean test = true;

        String[] hexBits = {"0000", "0001", "0010", "0011",
                "0100", "0101", "0110", "0111",
                "1000", "1001", "1010", "1011",
                "1100", "1101", "1110", "1111"};
        while(test) {
            Scanner in = new Scanner(System.in);
            System.out.print("Enter a Hexadecimal string: ");
            hexString = in.next().toUpperCase();
            hexLength = hexString.length() -1;
            for (int i = 0; i <= hexLength; i++) {
                hexChar = hexString.charAt(i);
                if (hexChar >= '0' && hexChar <= '9') {
                    test = false;
                } else if (hexChar >= 'A' && hexChar <= 'F') {
                    test = false;
                } else {
                    test = true;
                }
            }
        }
        hexLength = hexString.length() -1;
        for (int i = 0; i <= hexLength; i++){
            hexChar = hexString.charAt(i);
            if (hexChar >= '0' && hexChar <= '9'){
                decVal = hexChar - '0';
                binVal += hexBits[decVal] + " ";
            } else if (hexChar >='A' && hexChar <= 'F'){
                decVal = hexChar - 'A' + 10;
                binVal += hexBits[decVal] + " ";
            } else{
                System.out.print("ERROR");
            }
        }
        System.out.printf("The equivalent binary for hexadecimal \"%s\" is: %s", hexString, binVal);
    }
}
