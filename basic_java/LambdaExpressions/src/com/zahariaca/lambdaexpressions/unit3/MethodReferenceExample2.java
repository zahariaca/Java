package com.zahariaca.lambdaexpressions.unit3;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import com.zahariaca.lambdaexpressions.exercise.Person;

/**
 * Created by Zaharia Costin-Alexandru, email: zaharia.c.alexandru@gmail.com on 7/6/2017.
 */
public class MethodReferenceExample2 {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(new Person("Alex", "Zaharia", 25),
                new Person("Andrei", "Popescu", 50),
                new Person("Gigel", "Gheorghe", 55),
                new Person("Marina", "Suiu", 40),
                new Person("Andreea", "Dragomir", 35)
        );

        System.out.println("\nPrinting out all people java 8 method using the Predicate<T> interface");
        performPredicate(people, p -> true, System.out::println); // this is equivalent with (p) -> method(p)

    }

    // Printing using the Predicate<T> interface instead of an interface declared by me
    private static void performPredicate(List<Person> people, Predicate<Person> predicate, Consumer<Person> consumer) {
        for (Person p : people) {
            if (predicate.test(p)) {
                consumer.accept(p);
            }
        }
    }
}
