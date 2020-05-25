package com.zahariaca.lists.listexample;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Zaharia Costin-Alexandru, email: zaharia.c.alexandru@gmail.com on 6/27/2016.
 */
public class ListExample {
    public static void main(String[] args) {
        List<Integer> l1 = Arrays.asList(1,2,3,4,5,6);
        l1.forEach(System.out::println);

        for(Integer integer : l1){
            System.out.println(integer);
        }
    }
}
