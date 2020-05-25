package com.zahariaca.stringcharops.checkvowelsdigits;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    String word;
        int numberOfVowels = 0;
        int numberOfDigits = 0;

        Scanner in = new Scanner(System.in);
        System.out.print("Enter a word: ");
        word = in.next().toLowerCase();

        for (int i = 0; i <= word.length() -1; i++){
            char chr = word.charAt(i);
            if (!(chr >= '0' && chr <= '9')){
                if (    (chr == 'a') || (chr == 'A') ||
                        (chr == 'e') || (chr == 'E') ||
                        (chr == 'i') || (chr == 'I') ||
                        (chr == 'o') || (chr == 'O') ||
                        (chr == 'u') || (chr == 'U')){
                            numberOfVowels += 1;
                }else{
                    numberOfDigits += 1;
                }
            }
        }
        System.out.printf("Number of vowels is: %s%n", numberOfVowels);
        System.out.printf("number of chars is: %s%n", numberOfDigits);
    }
}
