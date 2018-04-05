package com.zahariaca.javatpoint.javaoopconcepts;

import com.zahariaca.javatpoint.basicsofjava.insertionsort.InsertionSort;

/**
 * Created by Zaharia Costin-Alexandru, email: zaharia.c.alexandru@gmail.com on 10/13/2016.
 */
public class Main {
    public static void main(String[] args) {
        //Fibonacci number exercise
        //Fibonacci fibonacci = new Fibonacci(100);
        //fibonacci.calculate();

        //Prime number exercise
        //PrimeNumber primeNumber = new PrimeNumber(59);

        //Palindrome number exercise
        //PalindromeNumber palindromeNumber = new PalindromeNumber(12321);

        //Factorial number exercise
        //Factorial factorial = new Factorial(6);
        //System.out.println(factorial.calculateFactorial());

        //Armstrong number exercise
        //Armstrong armstrong = new Armstrong(555);
        //armstrong.getResult();

        //BubbleSort exercise
        //BubbleSort sort1 = new BubbleSort();
        //sort1.calculate();
        //sort1.printResult();

        InsertionSort sort2 = new InsertionSort();
        sort2.calculate();
        sort2.printResult();

    }
}
