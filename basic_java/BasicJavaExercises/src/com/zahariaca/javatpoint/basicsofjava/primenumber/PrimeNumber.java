package com.zahariaca.javatpoint.basicsofjava.primenumber;

/**
 * Created by Zaharia Costin-Alexandru, email: zaharia.c.alexandru@gmail.com on 10/13/2016.
 */
public class PrimeNumber {
    private int number = 0 ;

    public PrimeNumber(int number){
        this.number = number;
        if(testPrime()){
            System.out.printf("The number: %s is prime! %n", number);
        }else{
            System.out.printf("The number: %s is not prime! %n", number);
        }
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
    public boolean testPrime(){
        if(number <= 1){
            return false;
        } else if (number <=3) {
            return true;
        } else if (number % 2 == 0 || number % 3 == 0){
            return false;
        } else {
            int i = 5;
            while(i*i<number){
                if(number % i == 0 || number % (i+2) == 0){
                    return false;
                }
                i += 6;
            }
            return true;

        }

    }

}
