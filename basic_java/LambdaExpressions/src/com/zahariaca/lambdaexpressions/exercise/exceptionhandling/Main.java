package com.zahariaca.lambdaexpressions.exercise.exceptionhandling;

import java.util.function.BiConsumer;

/**
 * Created by Zaharia Costin-Alexandru, email: zaharia.c.alexandru@gmail.com on 6/22/2017.
 */
public class Main {
    public static void main(String[] args) {
        int[] someNumbers = {1,2,3,4,5};
        int key = 2;

        process(someNumbers, key, (v,k) -> System.out.println(v + k));

        // not so nice :(
        process(someNumbers, 0, (v,k) -> {
            try {
                System.out.println(v/k);
            }catch (ArithmeticException ex){
                System.out.println("Arithmetic exception!");
            }
        });

        // better ?
        process(someNumbers, 1, wrapperLambda((v,k) -> System.out.println(v-k)));
    }

    // BiConsumer accepts the 2 Integer objects, returns void
    // we pass in the call to println and can customize the mathematical operation that is done
    private static void process(int[] someNumbers, int key, BiConsumer<Integer, Integer> biConsumer) {
        for(int i : someNumbers){
            biConsumer.accept(i,key);
        }
    }

    // wrapper lambda for handling exceptions
    // the first lambda from main will be passed to this function,
    // thus we generate a 2nd lambda, that wraps the first one,
    // then the process function gets that wrapped lambda that also handles exceptions
    // our code is cleaner this way, instead of handling exceptions at the first lambda layer
    private static BiConsumer<Integer, Integer> wrapperLambda(BiConsumer<Integer, Integer> biConsumer){
        return (v,k) -> {
            try{
                biConsumer.accept(v,k);
            }catch (ArithmeticException ex){
                System.out.println("Arithmetic exception!");
            }
        };
    }
}
