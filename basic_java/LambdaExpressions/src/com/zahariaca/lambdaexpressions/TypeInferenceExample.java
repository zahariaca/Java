package com.zahariaca.lambdaexpressions;

/**
 * Created by Zaharia Costin-Alexandru, email: zaharia.c.alexandru@gmail.com on 6/19/2017.
 */
public class TypeInferenceExample {
    public static void main(String[] args) {

        StringLengthLambda myLambda = (String s) -> s.length();
        StringLengthLambda my2ndLambda = s -> s.length();
        System.out.println("This is the length: " + myLambda.getLength("Alex"));
        printLambda(my2ndLambda);

        Addition addition = (a,b,c) -> a+b+c;
        System.out.println("The addition returns: " + addition.add(5,4,1));

    }

    public static void printLambda(StringLengthLambda l){
        System.out.println(l.getLength("Hello lambda") + "\n");
    }

    interface StringLengthLambda{
        int getLength(String s);
    }

    interface Addition{
        int add(int a, int b, int c);
    }
}

