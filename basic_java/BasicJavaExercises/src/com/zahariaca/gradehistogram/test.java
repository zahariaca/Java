package com.zahariaca.gradehistogram;

/**
 * Created by azaharia on 25.05.2016.
 */
public class test {
    public static void main(String[] args){
        int[] array = {3, 3, 5, 0, 1, 2, 5};
        int max = 0;

        for (int i=0; i< array.length; i++){
            if(max <= array[i]){
                max = array[i];
            }
        }

        System.out.println(max);

        for(int i = max; i >= 0; i--){
            for (int j=0; j<array.length; j++) {
                if(array[j] <= i) {
                    System.out.print(" ");
                }else{
                    System.out.print("*");

                }
            }
            System.out.println();
        }
    }
}
