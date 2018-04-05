package com.zahariaca.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Alex", "Zaharia", 25),
                new Person("Andrei", "Popescu", 50),
                new Person("Gigel", "Gheorghe", 55),
                new Person("Marina", "Suiu", 40),
                new Person("Andreea", "Dragomir", 35)
        );

        people.stream()
                .forEach(System.out::println);

        people.stream()
                .filter(p -> p.getLastName().startsWith("Z"))
                .forEach(p -> System.out.println(p.getFirstName()));

        long count = people.stream()
                .filter(p->p.getLastName().startsWith("Z"))
                .count();
        System.out.println("the count: " + count);

        people.parallelStream()
                .filter(p->p.getLastName().startsWith("Z"))
                .forEach(System.out::println);


        String test = "";
        String[] elements = test.split(" ");
        for (String s : elements) {
            System.out.println(s);
        }
        for(int i = 0; i < elements.length; i++){
            elements[i] = elements[i].substring(0,1).toUpperCase() + elements[i].substring(1);
        }

        String result = "";
        for(String s : elements){
            result += s;
        }

        System.out.println(result);
    }
}
