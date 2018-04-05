package com.zaharica.numberscanner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

/**
 * Created by Zaharia Costin-Alexandru, email: zaharia.c.alexandru@gmail.com on 6/28/2016.
 */
public class Main {
    public static void main(String[] args) throws IOException{
        Scanner sc = null;
        int sum = 0;

        try {
            sc = new Scanner(new BufferedReader(new FileReader("usnumbers.txt")));
            sc.useLocale(Locale.US);
            while (sc.hasNext()){
                if (sc.hasNextInt()){
                    sum += sc.nextInt();
                }else{
                    System.out.println(sc.next());
                }
            }
        }finally {
            sc.close();
        }
        System.out.println(sum);
    }
}
