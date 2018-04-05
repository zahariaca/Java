package com.zahariaca.lists.removeiflist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class RemoveIfList {
    public static void main(String[] args) {
        System.out.println("Demonstration of removeIf");
        List<String> l1 = new ArrayList<>(createList());
        // remove all items which contains an "x"
        l1.removeIf(s -> s.toLowerCase().contains("x"));
        l1.forEach(System.out::println);
    }

    private static List<String>  createList() {
        return Arrays.asList("iPhone", "Ubuntu", "Android", "Mac OS X");
    }
}
