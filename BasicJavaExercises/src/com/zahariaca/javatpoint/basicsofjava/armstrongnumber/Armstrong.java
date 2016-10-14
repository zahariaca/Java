package com.zahariaca.javatpoint.basicsofjava.armstrongnumber;

/**
 * Created by Zaharia Costin-Alexandru, email: zaharia.c.alexandru@gmail.com on 10/13/2016.
 */
public class Armstrong {
    private int number;

    public Armstrong(int number){
        this.number=number;

    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
    private double calculateArmstrong(){
        String numberToProcess = Integer.toString(number);
        char[] digits = numberToProcess.toCharArray();
        double result = 0;
        for(char output : digits){
            result += Math.pow(Character.getNumericValue(output), 3);
        }
        return result;
    }
    public void getResult(){
        if(!(calculateArmstrong() == number)){
            System.out.printf("The number: %s is not an Armstrong number! %n", number);
        }else {
            System.out.printf("The number: %s is an Armstrong number! %n", number);
        }
    }
}
