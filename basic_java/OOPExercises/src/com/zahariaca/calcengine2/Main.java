package com.zahariaca.calcengine2;

public class Main {

    public static void main(String[] args) {
        useCalculateBase();

        String[] statements = {
                "divide 100.0 50.0",
                "add 25.0 92.0",
                "subtract 225.0 17.0",
                "multiply 11.0 3.0"
        };
        CalculateHelper calculator = new CalculateHelper();
        for (String statement:statements){
            calculator.process(statement);
            System.out.printf("The result is: %s%n", calculator.toString());
        }
    }


    public static void useCalculateBase(){
        CalculateBase[] calculator = {
                new Adder(25.0d, 5.0d),
                new Adder(25.0d, 10.0d)
        };

        for (CalculateBase calculate:calculator){
            calculate.calculate();
            System.out.println(calculate.getResult());
        }
    }
}
