package com.zahariaca.javatpoint.basicsofjava.selectionsort;

import com.zahariaca.javatpoint.basicsofjava.BasicTemplate;

/**
 * Created by Zaharia Costin-Alexandru, email: zaharia.c.alexandru@gmail.com on 10/13/2016.
 */
public class SelectionSort implements BasicTemplate {
    private int[] arr = new int[]{5, 1, 4, 2, 8};

    @Override
    public void calculate() {
        for(int i = 0 ; i < arr.length-1; i++){
            int index = i;
            for(int j = i +1; j < arr.length; i++){
                if(arr[j]<arr[index]){
                    index = j;
                }
            }
            int lowestNumber = arr[index];
            arr[index] = arr[i];
            arr[i] = lowestNumber;
        }
    }

    @Override
    public void printResult() {
        for(Integer i : arr ){
            System.out.print(i+ ", ");
        }
    }
}
