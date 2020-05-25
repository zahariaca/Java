package com.zahariaca.stringcharops.testpalindrome;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String word, wordOriginal, wordWithoutSpecialCharacters;
        int strLength;
        int bckIndex;

        Scanner in = new Scanner(System.in);
        System.out.print("Please enter a word: ");
        wordOriginal = in.nextLine();
        word = wordOriginal.toLowerCase();
        in.close();
        wordWithoutSpecialCharacters = word.replaceAll("[\\W]","");

        strLength = wordWithoutSpecialCharacters.length() -1;
        bckIndex = strLength;
        boolean test = true;
            for (int fwdIndex = 0; fwdIndex <= strLength; fwdIndex++) {

                char fwdChar = wordWithoutSpecialCharacters.charAt(fwdIndex);
                char bckChar = wordWithoutSpecialCharacters.charAt(bckIndex);
                bckIndex--;
                if (!(fwdChar == bckChar)) {
                    test = false;
                }
            }
        if (test == true){
            System.out.printf("This word \" %s \" is a palindrome", wordOriginal);
        }else{
            System.out.printf("This word \" %s \" is not a palindrome", wordOriginal);
        }
    }
}
