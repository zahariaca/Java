package com.zahariaca.stringcharops.bin2dec;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        String binary;
        int strLength;
        int decimal = 0;
        double order;
        boolean test = true;

        Scanner in = new Scanner(System.in);
        System.out.print("Enter a binary number: ");
        binary = in.next();
        strLength = binary.length() -1;


        for ( int i = 0; i <= strLength; i++){
            char chr = binary.charAt(i);
            order = binary.length()-i-1;
            if (!(chr == '0') || chr != '1' || (chr >= 'a' || chr <= 'z')){
                test = false;
            }
            if (chr == '1'){
                decimal += Math.pow(2, order);
                test = true;
            }else if (chr == '0'){
                test = true;
            }
        }
        if(test == true){
            System.out.printf("The decimal value of %s is: %s", binary, decimal);
        }else{
            System.out.printf("%s is not binary! %n", binary);
        }
    }
}
