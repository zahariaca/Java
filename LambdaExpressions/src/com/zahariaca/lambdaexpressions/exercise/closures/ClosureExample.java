package com.zahariaca.lambdaexpressions.exercise.closures;

/**
 * Created by Zaharia Costin-Alexandru, email: zaharia.c.alexandru@gmail.com on 6/22/2017.
 */
public class ClosureExample {
    public static void main(String[] args) {
        int a = 10;
        int b = 20; //effectively final

        doProcess(a, (i) -> {
            // b = 30; changing the value is not allowed here.
            // The java compiler assumes that b is final, and will not let us change it.
            // but we can use it in a different scope
            System.out.println(i + b);
        });
    }

    public static void doProcess(int i, Process process){
        process.process(i);
    }
}

interface Process{
    void process(int i);
}
