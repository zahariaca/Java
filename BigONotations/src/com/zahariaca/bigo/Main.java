package com.zahariaca.bigo;

public class Main {
    private int[] theArray;
    private int arraySize = 0;

    public static void main(String[] args) {
        Main bigArray = new Main(100);
        bigArray.generateRandomArray();
        System.out.println(bigArray.theArray[70]);
    }

    public Main(int arraySize){
        this.arraySize = arraySize;
        theArray = new int[arraySize];
    }
    public void generateRandomArray(){
        for (int i = 0; i < arraySize; i++){
            theArray[i] = (int) (Math.random() * 1000) + 10;
        }
    }

}
