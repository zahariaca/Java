package com.zahariaca.javatpoint.basicsofjava.factorialnumber;

/**
 * Created by Zaharia Costin-Alexandru, email: zaharia.c.alexandru@gmail.com on 10/13/2016.
 */
public class Factorial {
    private int number;

    public Factorial(int number){
        this.number=number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double calculateFactorial(){
        double result = 1;
        for(int i = 1; i <= number; i++){
            result *= i;
        }
        return result;
    }
}
