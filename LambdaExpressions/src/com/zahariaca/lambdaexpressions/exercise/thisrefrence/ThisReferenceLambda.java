package com.zahariaca.lambdaexpressions.exercise.thisrefrence;

/**
 * Created by Zaharia Costin-Alexandru, email: zaharia.c.alexandru@gmail.com on 6/22/2017.
 */
public class ThisReferenceLambda {
    public static void main(String[] args) {
        ThisReferenceLambda thisReferenceLambda = new ThisReferenceLambda();
        thisReferenceLambda.doProcess(10, new Process() {
            @Override
            public void process(int i) {
                System.out.println("Value of i is: " + i);
                System.out.println(this);
            }
        });

        thisReferenceLambda.doProcess(20, (i) ->{
            System.out.println("Value of i is: " + i);
            System.out.println(this);
        });
    }
    public void doProcess(int i, Process p){
        p.process(i);
    }
}

interface Process{
    void process(int i);
}
