package com.zahariaca.sumdigits;

import java.util.IntSummaryStatistics;

public class Main {
    private double result = 0;
    private String str = "";

    public static void main(String[] args) {
        Main main = new Main();
        main.checkArgs(args);
        main.checkNr(args);
        main.sum(args);
        main.printSum();
    }

    private void checkArgs(String[] args){
        if (args.length != 1){
            System.err.print("Please input only 1 argument");
        }
    }
    private void checkNr(String[] args){
        try{
            Integer.parseInt(args[0]);
        }catch (NumberFormatException e){
            System.err.print("This is not a valid number");
        }
    }

    private void printSum(){
        System.out.println("The sum of digits = " + str + " = " + result);
    }

    private void sum(String[] args){
        char nr;

        for (int i=0; i < args[0].length(); i++){
            nr = args[0].charAt(i);
            if( i < args[0].length() -1) {
                str += nr + " + ";
            }else{
                str += nr ;
            }
            result += (nr - '0');
        }
    }
}
