package com.zahariaca.lists.myarraylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Zaharia Costin-Alexandru, email: zaharia.c.alexandru@gmail.com on 6/27/2016.
 */
public class MyArrayList {
    public static void main(String[] args) {
        List<String> list1 = Arrays.asList("Alex", "Sever");

        List<String> list2 = new ArrayList<>();
        list2.add("Alex");
        list2.add("Sever");

        list1.forEach(System.out::println);
        list2.forEach(System.out::println);
    }


}
