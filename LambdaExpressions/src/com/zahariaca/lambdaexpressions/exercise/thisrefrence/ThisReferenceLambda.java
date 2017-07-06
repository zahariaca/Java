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
                System.out.println(this); // because this is an anonymous inner class, this is the refrence of "thisRefrenceLambad" instance
            }

            // we can even override the toString of the "thisRefrenceLambda"
            @Override
            public String toString() {
                return "This is the anonymous inner class";
            }
        });

        thisReferenceLambda.doProcess(20, (i) ->{
            System.out.println("Value of i is: " + i);
            // System.out.println(this); <- This would not work
        });

        thisReferenceLambda.execute();
    }
    public void doProcess(int i, Process p){
        p.process(i);
    }

    public void execute(){
        doProcess(20, (i) ->{
            System.out.println("Value of i is: " + i);
            System.out.println(this); // because we use it outside of a static context we can do this, this is still the reference of "thisReferenceLambda" instance
        });
    }

    @Override
    public String toString() {
        return "This is the main thisReferenceLambda example class";
    }
}

interface Process{
    void process(int i);
}
