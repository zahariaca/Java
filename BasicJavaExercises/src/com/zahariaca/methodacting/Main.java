package com.zahariaca.methodacting;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //Test for isOdd() method
        System.out.printf("The isOdd method says: %s. %n", isOdd(4));
        System.out.printf("The isOdd method says: %s. %n", isOdd(5));
        System.out.println("****************************************************************************");

        //Test for hasEight() method
        System.out.printf("The hasEight method says: %s. %n", hasEight(88));
        System.out.printf("The hasEight method says: %s. %n", hasEight(90));
        System.out.println("****************************************************************************");

/*        //MagicSum application
        int sentinel = -1;
        int number = 0;
        int magicSum = 0;
        while ( number != sentinel){
            Scanner in = new Scanner(System.in);
            System.out.print("Enter a positive integer or -1 to exit: ");
            number = in.nextInt();
            if(hasEight(number)){
                magicSum += number;
            }
        }
        System.out.printf("The magic sum is: %s%n", magicSum);
        System.out.println("****************************************************************************");*/

        //Test for printArray() method
        String result = printArrayToString(new int[] {1,2 ,3 ,5});
        System.out.printf("The array for printArray method contains: %s%n", result);
        System.out.println("****************************************************************************");

        //Test for contains() method
        System.out.printf("The contains method says: %s. %n", contains(new int[] {1,2,3,4,5,6,7,8}, 8));
        System.out.printf("The contains method says: %s. %n", contains(new int[] {1,2,3}, 8));
        System.out.println("****************************************************************************");

        //Test for search() method
        result = search(new int[] {1,2,3,4,4}, 4);
        System.out.printf("The search method says: %s %n", result);
        System.out.println("****************************************************************************");

        //Test for equals() method
        System.out.printf("The equals method says: %s. %n", equals(new int[] {1,2,3,4,5,6,7,8}, new int[] {1,2,3,4,5,6,7,8}));
        System.out.printf("The equals method says: %s. %n", equals(new int[] {1,2,3}, new int[] {1,2,3,4,5,6,7,8}));
        System.out.println("****************************************************************************");

        //Test for copyOf() method
        int[] array = copyOf(new int[] {1, 2, 3, 5});
        for ( int i = 0; i <= array.length -1; i++) {
            System.out.printf("The array for copyOf method contains: %s%n", array[i]);
        }
        System.out.println("****************************************************************************");

        //Test for copyOf() method
        int[] array2 = copyOf(new int[] {1, 2, 3, 4}, 8);
        for ( int j = 0; j <= array2.length -1; j++) {
            System.out.printf("The array for copyOf method contains: %s%n", array2[j]);
        }
        System.out.println("****************************************************************************");

        //Test for swap() method
        System.out.printf("The swap method says: %s. %n", swap(new int[] {1,2,3,4,5,6,7,8}, new int[] {1,2,3,4,5,6,7,8}));
        System.out.printf("The swap method says: %s. %n", swap(new int[] {1,2,3}, new int[] {1,2,3,4,5,6,7,8}));
        System.out.println("****************************************************************************");

        //Test for reverse() method
        int[] arrayReverse = reverse(new int[] {1,2,3,4,5,6,7,8});
        for (int i =0; i <= arrayReverse.length -1; i++) {
            System.out.printf("The reverse method says: %s. %n", arrayReverse[i]);
        }
        System.out.println("****************************************************************************");



    }

    public static boolean isOdd(int number){
        if (number % 2 == 0){
            return true;
        }else{
            return false;
        }
    }

    public static boolean hasEight(int number){
        if (String.valueOf(number).contains("8")){
            return true;
        }else{
            return false;
        }
    }

    public static String printArrayToString(int[] array){
        String result = "";
        for (int i = 0; i <= array.length -1; i++){
            if(i < array.length -1) {
                result += String.valueOf(array[i]) + ", ";
            }else if(i == array.length -1){
                result += String.valueOf(array[i]);
            }
        }
        return "{" + result + "}";
    }

    public static boolean contains(int[] args, int key){
        boolean test = false;
        for ( int i = 0; i <= args.length -1; i++){
            if(args[i] == key){
                test = true;
            }else{
                test = false;
            }
        }
        return test;
    }

    public static String search(int[] args, int key){
        String result = "";
        for (int i = 0; i <= args.length -1; i++){
            if (key == args[i]){
                if(i < args.length -1) {
                    result += String.valueOf(i) + ", ";
                }else if (i == args.length -1){
                    result += String.valueOf(i);
                }
            }else{
                if(i < args.length -1) {
                    result += "-1, ";
                }else if (i == args.length -1){
                    result += "-1";
                }
            }
        }
        return "{" + result + "}";
    }

    public static boolean equals(int[] arr1, int[] arr2){
        boolean test = false;
        if(arr1.length == arr2.length) {
                for (int i = 0; i <= arr1.length -1; i++) {
                    if (arr1[i] == arr2[i]) {
                        test = true;
                    }else{
                        test = false;
                    }
                }
        }else{
            test = false;
        }
        if(test){
            return true;
        }else{
            return false;
        }
    }

    public static int[] copyOf(int[] array){
        int[] array2 = new int[array.length];
        for (int i = 0; i <= array.length -1; i++){
            array2[i] = array [i];
        }
        return array2;
    }

    public static int[] copyOf(int[] array, int size){
        int[] array2 = new int[size];
        for (int i = 0; i <= size -1; i++){
            if(i <= array.length -1) {
                array2[i] = array[i];
            }else if (i > array.length -1){
                array2[i] = 0;
            }
        }
        return array2;
    }
    public static boolean swap(int[] array1,int [] array2){
        int temp = 0;
        if(array1.length == array2.length){
            for (int i = 0; i <= array1.length -1; i++){
                temp = array1[i];
                array1[i] = array2[i];
                array2[i] = temp;
            }
            return true;
        }else{
            return false;
        }
    }

    public static int[] reverse(int[] arr1){
        int temp;
        int arrayLength;

        arrayLength = arr1.length -1;

        for (int i = 0; i <= arrayLength; i++){
            temp = arr1[i];
            arr1[i] = arr1[arrayLength];
            arr1[arrayLength]= temp;
            arrayLength--;
        }
        return arr1;
    }

}
