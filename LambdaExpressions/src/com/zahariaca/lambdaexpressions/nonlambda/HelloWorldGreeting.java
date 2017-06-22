package com.zahariaca.lambdaexpressions.nonlambda;

/**
 * Created by Zaharia Costin-Alexandru, email: zaharia.c.alexandru@gmail.com on 6/19/2017.
 */
public class HelloWorldGreeting implements Greeting {
    @Override
    public void perform() {
        System.out.println("Hello WORLD!");
    }
}
