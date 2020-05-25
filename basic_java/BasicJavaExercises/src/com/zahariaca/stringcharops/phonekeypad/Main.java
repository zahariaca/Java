package com.zahariaca.stringcharops.phonekeypad;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String word;


        Scanner in = new Scanner(System.in);
        System.out.print("Enter a word: ");
        word = in.next().toLowerCase();

        for (int i = 0; i <= word.length() -1; i++){
            char chr = word.charAt(i);
            if (!(chr >= '0' && chr <= '9')) {
                switch (chr) {
                    case 'a':
                    case 'b':
                    case 'c':
                        System.out.print("2");
                        break;
                    case 'd':
                    case 'e':
                    case 'f':
                        System.out.print("3");
                        break;
                    case 'g':
                    case 'h':
                    case 'i':
                        System.out.print("4");
                        break;
                    case 'j':
                    case 'k':
                    case 'l':
                        System.out.print("5");
                        break;
                    case 'm':
                    case 'n':
                    case 'o':
                        System.out.print("6");
                        break;
                    case 'p':
                    case 'q':
                    case 'r':
                    case 's':
                        System.out.print("7");
                        break;
                    case 't':
                    case 'u':
                    case 'v':
                        System.out.print("8");
                        break;
                    case 'w':
                    case 'x':
                    case 'y':
                    case 'z':
                        System.out.print('9');
                        break;
                    default:
                        System.out.println("Something went wrong");
                }
            }
        }
    }
}
