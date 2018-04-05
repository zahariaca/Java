package com.zahariaca.javatpoint.basicsofjava.bubblesort;

import com.zahariaca.javatpoint.basicsofjava.BasicTemplate;

/**
 * Created by Zaharia Costin-Alexandru, email: zaharia.c.alexandru@gmail.com on 10/13/2016.
 */
public class BubbleSort implements BasicTemplate {
    private int[] arr = new int[]{5, 1, 4, 2, 8};

    public BubbleSort(){}
    public BubbleSort(int[] arr){
        this.arr=arr;
    }

    @Override
    public void calculate() {
        boolean swapped = false;
        while (!swapped) {
            swapped = true;
            for (int i = 1; i < arr.length; i++) {
                int temp = 0;
                if (arr[i - 1] > arr[i]) {
                    temp = arr[i - 1];
                    arr[i - 1] = arr[i];
                    arr[i] = temp;
                    swapped=false;
                }
            }
        }
    }

    @Override
    public void printResult() {
        for(Integer i : arr){
            System.out.print(i + " ");
        }
    }

}
