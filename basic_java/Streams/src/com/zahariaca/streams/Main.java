package com.zahariaca.streams;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
                .filter(p -> p.getLastName().startsWith("Z"))
                .count();
        System.out.println("the count: " + count);

        people.parallelStream()
                .filter(p -> p.getLastName().startsWith("Z"))
                .forEach(System.out::println);


        int[] integerArray = {1, 3, 4, 6, 8, 12, 14, 25, 28};

        Arrays.stream(integerArray)
                .filter(i -> i % 2 == 0)
                .forEach(System.out::println);

        int result = Arrays.stream(integerArray)
                .filter(i -> i % 2 == 0)
                .sum();

        System.out.println("Result:  " + result);


        Map<String, Integer> integers = new HashMap<>();

        integers.values()
                .stream()
                .mapToInt(i -> i.intValue())
                .filter(i -> i % 2 == 0)
                .forEach(System.out::println);

    }
}
