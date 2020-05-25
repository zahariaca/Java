package com.zahariaca.lambdaexpressions.runnable;

/**
 * Created by Zaharia Costin-Alexandru, email: zaharia.c.alexandru@gmail.com on 6/19/2017.
 */
public class RunnableExample {
    public static void main(String[] args) {
        Thread myThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Printed inside Runnable Annonymous inner class");
            }
        });

        myThread.run();

        Thread myLambdaThread = new Thread(() -> System.out.println("Printed inside Runnable from inline Lambda"));
        myLambdaThread.run();
    }
}
