package com.zahariaca.javatpoint.basicsofjava.insertionsort;

import com.zahariaca.javatpoint.basicsofjava.BasicTemplate;

/**
 * Created by Zaharia Costin-Alexandru, email: zaharia.c.alexandru@gmail.com on 10/13/2016.
 */
public class InsertionSort implements BasicTemplate {
    private int[] arr = new int[]{5, 1, 4, 2, 8};
    int temp;
    int j;

    @Override
    public void calculate() {
        for(int i = 1; i < arr.length; i++){
            temp = arr[i];
            j = i;
            while(j > 0 && arr[j-1] > temp){
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = temp;
        }
    }

    @Override
    public void printResult() {
        for(Integer i : arr ){
            System.out.print(i+ ", ");
        }
    }
}
