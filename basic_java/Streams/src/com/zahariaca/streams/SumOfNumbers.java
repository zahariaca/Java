package com.zahariaca.streams;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SumOfNumbers {
    public static void main(String[] args) {
        int result = 0;
        for(int i = 1; i<= 100; i++) {
            result+=i;
        }
        System.out.println("OldSchool:");
        System.out.println(result);

        System.out.println("Stream sum():");
        System.out.println(IntStream.range(1,101).sum());

        System.out.println("Stream reduce():");
        System.out.println(IntStream.range(1,101).reduce(0, (left, right) -> left+right));

        System.out.println("Stream Iterate: ");
        System.out.println(IntStream.iterate(0, i -> i+1).limit(101).sum());
    }
}
