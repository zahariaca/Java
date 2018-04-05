package com.zahariaca.lambdaexpressions.unit3;

import java.util.Arrays;
import java.util.List;

import com.zahariaca.lambdaexpressions.exercise.Person;

/**
 * Created by Zaharia Costin-Alexandru, email: zaharia.c.alexandru@gmail.com on 7/6/2017.
 */
public class CollectionIterationExample {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(new Person("Alex", "Zaharia", 25),
                new Person("Andrei", "Popescu", 50),
                new Person("Gigel", "Gheorghe", 55),
                new Person("Marina", "Suiu", 40),
                new Person("Andreea", "Dragomir", 35)
        );

        System.out.println("Using the classic for loop:");
        // using the classic for loop to print all elements of an array
        for (int i=0; i<people.size(); i++){
            System.out.println(people.get(i));
        }

        System.out.println("Using a for each loop:");

        // using the for each loop
        for(Person p : people){
            System.out.println(p);
        }

        System.out.println("Using forEach, internal iterator");
        // using lambda forEach internal iterator
        people.forEach(System.out::println);
    }
}
