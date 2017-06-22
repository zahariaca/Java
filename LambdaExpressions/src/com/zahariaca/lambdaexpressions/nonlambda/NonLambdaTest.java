package com.zahariaca.lambdaexpressions.nonlambda;

/**
 * Created by Zaharia Costin-Alexandru, email: zaharia.c.alexandru@gmail.com on 6/19/2017.
 */
public class NonLambdaTest {
    public static void main(String[] args) {
        Greeter greeter = new Greeter();

        Greeting helloWorldGreeting = new HelloWorldGreeting();

        greeter.greet(helloWorldGreeting);
    }
}
