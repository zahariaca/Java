package com.zahariaca.imperialtostandard.main;

import com.azaharia.imperialtostandard.ConverterHelper;
import com.azaharia.imperialtostandard.InvalidStatementException;

import java.util.Scanner;

/**
 * Created by azaharia on 30.05.2016.
 */
public class Main {
    public static void main(String[] args){
        String statement = readInput();
        /*String[] statements={
                "InchesToCentimeters 1",
                "InchesToCentimeters 2",
                "InchesToCentimeters 3",
                "CentimeterToInches 2.54",
                "CentimeterToInches 5.08",
                "CentimeterToInches 7.62"
        };
        ConverterHelper converter = new ConverterHelper();
        for(String statement:statements){
            converter.process(statement);
            System.out.println(converter.toString());
        }*/
        ConverterHelper converter = new ConverterHelper();
        try {
            converter.process(statement);
            System.out.println(converter.toString());
        }catch(InvalidStatementException e){
            System.out.println(e.getMessage());
            if (e.getCause() != null){
                System.out.println("Original EXCEPTION: " + e.getCause().getMessage());
            }
        }
    }

    public static String readInput(){
        System.out.println("Please input a conversion type and a number to be converted: (Example: InchesToCentimeters 2): ");
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }
}
