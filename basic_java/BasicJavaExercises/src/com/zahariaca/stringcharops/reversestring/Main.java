package com.zahariaca.stringcharops.reversestring;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    String inStr;
        int stringLenght;

        Scanner in = new Scanner(System.in);
        System.out.print("Enter a string: ");
        inStr = in.next();
        stringLenght = inStr.length();

        for (int i = stringLenght -1; i >= 0; i--){
            System.out.print(inStr.charAt(i));
        }
    }
}
