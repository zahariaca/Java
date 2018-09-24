package com.zahariaca.bigo;

public class Main {
    private int[] theArray;
    private int arraySize = 0;
    private double startTime;
    private double endTime;

    public static void main(String[] args) {
        Main bigArray = new Main(100000);
        bigArray.generateRandomArray();
        System.out.println(bigArray.theArray[70]);
        bigArray.selectionSort();
        System.out.println(bigArray.theArray[70]);
        System.out.println(bigArray.theArray[71]);

        Main bigArray2 = new Main(200000);
        bigArray2.generateRandomArray();
        System.out.println(bigArray2.theArray[80]);
        bigArray2.selectionSort();
        System.out.println(bigArray2.theArray[80]);
        System.out.println(bigArray2.theArray[81]);


    }

    public Main(int arraySize){
        this.arraySize = arraySize;
    }

    public void addElementToArray(int element) {                    //O(1)
        theArray[theArray.length]=element;
    }       //O(1)
    public void addElementToIndex(int index, int element){          //O(1)
        theArray[index]=element;
    }      //O(1)

    public void selectionSort(){                                                            //O(n^2)
        startTime = System.currentTimeMillis();
        for(int i = 0; i < theArray.length; i++){
                for(int j = i+1; j <theArray.length; j++){
                    if(theArray[i] >= theArray[j]){
                        theArray[i] = theArray[i]^theArray[j];
                        theArray[j] = theArray[i]^theArray[j];
                        theArray[i] = theArray[i]^theArray[j];
                    }
                }
        }
        endTime = System.currentTimeMillis();
        System.out.println("Selection sort took: " + (endTime-startTime)/1000);
    }

    public void generateRandomArray(){
        theArray = new int[arraySize];
        for (int i = 0; i < arraySize; i++){
            theArray[i] = ((int) (Math.random() * 10000) + 10) + ((int) (Math.random() * 1000) + 10);
        }
    }

}
