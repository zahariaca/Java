package com.zahariaca.streams;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
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


        System.out.println("Map test: ");

        String[] stringArrayOfInts = {"1", "3", "4", "2"};
        Arrays.stream(stringArrayOfInts)
                .map(Integer::valueOf)
                .forEach(i -> {
                    System.out.println(i);
                    System.out.println(i.getClass());
                });


        System.out.println("Filter test: ");
        Arrays.stream(stringArrayOfInts)
                .map(Integer::valueOf)
                .filter(i -> i % 2 != 0)
                .forEach(i -> {
                    System.out.println(i);
                    System.out.println(i.getClass());
                });

        System.out.println("Collect test: ");
        List<Integer> evenList = Arrays.stream(stringArrayOfInts)
                .map(Integer::valueOf)
                .filter(i -> i % 2 == 0)
                .collect(Collectors.toList());
        System.out.println(evenList.getClass());
        System.out.println(evenList.size());

        Stream<Integer> stream = Arrays.stream(stringArrayOfInts)
                                    .map(Integer::valueOf);

        System.out.println(stream);

        System.out.println(stream.filter(i -> i % 3 == 0).count());
        System.out.println(stream);

        System.out.println("Reduce example: ");
        Arrays.stream(stringArrayOfInts)
                .map(Integer::valueOf)
                .reduce((i1, i2) -> i1 < i2 ? i2 : i1)
                .ifPresent(System.out::println);
    }
}
