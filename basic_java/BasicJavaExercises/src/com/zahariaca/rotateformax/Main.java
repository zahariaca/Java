package com.zahariaca.rotateformax;

public class Main {

    public static void main(String[] args) {
        long n = 507992495;
        long result = n;
        String resultTemp;
        String temp = Long.toString(n);
        int[] array = new int[temp.length()];

        for ( int i = 0; i < temp.length(); i++){
            array[i] = temp.charAt(i) - '0';
            System.out.print(array[i]);

        }
        System.out.println();
        for (int j = 0; j < array.length; j++){
            int k = j;
            int val = array[k];
            k++;
            while ( k < array.length ){
                array[k-1] = array[k];
                ++k;
            }
            array[k-1] = val;
            resultTemp = "";
            for ( int l = 0; l < array.length; l++){
                resultTemp += array[l];
            }
            if(result < Long.valueOf(resultTemp)){
                result = Long.valueOf(resultTemp);
            }
        }
        System.out.print(result);
    }
}
