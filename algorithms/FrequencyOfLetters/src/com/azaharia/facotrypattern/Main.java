package com.azaharia.facotrypattern;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        /*HashMap<Character,Integer> charCountMap = new HashMap<Character,Integer>();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("string.txt"));
            String line = br.readLine();

            while (line != null) {
                char[] chars = line.toCharArray();
                for(char c: chars){
                    if(charCountMap.containsKey(c)){
                        charCountMap.put(c,charCountMap.get(c)+1);
                    }else{
                        charCountMap.put(c,1);
                    }
                }
                Iterator it = charCountMap.entrySet().iterator();
                it.forEachRemaining(System.out::println);

                *//*while(it.hasNext()){
                    System.out.println(it.next());
                    it.remove();
                }*//*
                line = br.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/
                B b = new B();
        b.test();
    }
}
