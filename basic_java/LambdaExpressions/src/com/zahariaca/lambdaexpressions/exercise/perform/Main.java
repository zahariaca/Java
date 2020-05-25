package com.zahariaca.lambdaexpressions.exercise.perform;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import com.zahariaca.lambdaexpressions.exercise.Person;

/**
 * Created by Zaharia Costin-Alexandru, email: zaharia.c.alexandru@gmail.com on 6/19/2017.
 */
public class Main {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(new Person("Alex", "Zaharia", 25),
                new Person("Andrei", "Popescu", 50),
                new Person("Gigel", "Gheorghe", 55),
                new Person("Marina", "Suiu", 40),
                new Person("Andreea", "Dragomir", 35)
        );

        // Step 1: sort list by last name

        // Solution in Java 8
        Collections.sort(people, (o1, o2) -> o1.getLastName().compareTo(o2.getLastName()));

        // Step 2: create a method that prints all elements in list

        // Solution in Java 8
        System.out.println("\nPrinting out all peoplem java 8 method");
        performConditionally(people, p -> true, p -> System.out.println(p));

        // Step 3: create a method that prints all people that have last name beginning with Z

        // Solution in Java 8
        System.out.println("\nPrinting out all people with last name beginning with Z, java 8 method (lambda)");
        performConditionally(people, p -> p.getLastName().startsWith("Z"),p -> System.out.println(p.getLastName()));

        System.out.println("\nPrinting out all people java 8 method using the Predicate<T> interface");
        performPredicate(people, p -> true, p -> System.out.println(p));
    }

    // Printing using one of our own functional interfaces called Condition
    private static void performConditionally(List<Person> people, Condition condition, Consumer<Person> consumer) {
        for (Person p : people){
            if(condition.test(p)) {
                consumer.accept(p);
            }
        }
    }

    // Printing using the Predicate<T> interface instead of an interface declared by me
    private static void performPredicate(List<Person> people, Predicate<Person> predicate, Consumer<Person> consumer){
        for( Person p : people){
            if(predicate.test(p)){
                consumer.accept(p);
            }
        }
    }

    @FunctionalInterface
    interface Condition{
        boolean test(Person p);
    }
}
