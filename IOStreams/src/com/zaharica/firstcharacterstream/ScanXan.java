package com.zaharica.firstcharacterstream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Zaharia Costin-Alexandru, email: zaharia.c.alexandru@gmail.com on 6/28/2016.
 */

public class ScanXan {
   public static void main(String[] args) throws IOException {
       Scanner sc =null;
       List<String> list = new ArrayList<>();

       try {
           sc = new Scanner(new BufferedReader(new FileReader("xanadu.txt")));
           while(sc.hasNext()){
               list.add(sc.next());
           }
       } finally {
           if (sc != null){
               sc.close();
           }
       }

       list.forEach(System.out::println);

    }
}
