package com.zahariaca.javatpoint.basicsofjava.fibonacci;

/**
 * Created by Zaharia Costin-Alexandru, email: zaharia.c.alexandru@gmail.com on 10/13/2016.
 */
public class Fibonacci {
    private double[] arr;

    public Fibonacci(double number){
        arr = new double[(int)number];
        populateArray();
    }
    private void populateArray(){
        for (int i = 0; i < arr.length; i++){
            arr[i] = i;
        }
    }
    public void calculate(){
        System.out.println(arr[0]);
        System.out.println(arr[1]);
        for(int i = 2; i < arr.length; i++){
            arr[i] = arr[i-2]+arr[i-1];
            System.out.println(arr[i]);
        }
    }
}
