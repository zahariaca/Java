package com.zahariaca.lambdaexpressions;

import com.zahariaca.lambdaexpressions.nonlambda.Greeter;
import com.zahariaca.lambdaexpressions.nonlambda.Greeting;

public class FirstLambdaTest {

    public static void main(String[] args) {
        // write your code here
        //gretingFunction = () -> System.out.println("Hello World");

        Greeter greeter = new Greeter();
        greeter.greet(() -> System.out.println("Hello from lambda!"));

        Greeting helloFromLambda = () -> System.out.println("Hello again from lambda!");
        Greeting randomGreeting = () -> System.out.println("Random greeting!\n");

        greeter.greet(helloFromLambda);
        greeter.greet(randomGreeting);
        randomGreeting.perform();

        // annonymous class
        Greeting annonGreeting = new Greeting() {
            @Override
            public void perform() {
                System.out.println("Hello world from annonymous class\n");
            }
        };
        annonGreeting.perform();
        greeter.greet(annonGreeting);

        MathOperation addition = (int a, int b) -> a + b;
        MathOperation subtraction = (a, b) -> a - b;
        MathOperation division = (a, b) -> {
            if (b == 0)
                return 0;
            return a / b;
        };
        MathOperation multiplication = (int a, int b) -> a * b;

        System.out.println("10 + 5 = " + operate(10, 5, addition));
        System.out.println("10 - 5 = " + operate(10, 5, subtraction));
        System.out.println("10 / 5 = " + operate(10, 5, division));
        System.out.println("10 * 5 = " + operate(10, 5, multiplication));

        MyGreeting myGreeting = message -> System.out.println("Hello " + message);
        myGreeting.greet("Alex");

    }

    private static int operate(int a, int b, MathOperation mathOperation) {
        return mathOperation.operation(a, b);
    }

    interface MathOperation {
        int operation(int a, int b);
    }

    interface MyGreeting{
        void greet(String message);
    }

}

