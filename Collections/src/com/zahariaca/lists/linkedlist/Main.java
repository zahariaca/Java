package com.zahariaca.lists.linkedlist;

import java.util.LinkedList;
import java.util.ListIterator;

public class Main {

    public static void main(String[] args) {

        LinkedList<String> passengerList = new LinkedList();
        passengerList.add("Alex Smith");
        passengerList.add("Mary Lou");
        passengerList.add("Sim Monk");
        ListIterator iterator = passengerList.listIterator();
        System.out.println(iterator.next());
        iterator.add("VIP CUSTOMER");
        iterator.previous();
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());


        ListIterator iterator2 = passengerList.listIterator();
        System.out.println(iterator2.next());
        System.out.println(iterator2.next());
        System.out.println(iterator2.next());
        System.out.println(iterator2.next());

        Lambdatest.useMethod();

    }
}
