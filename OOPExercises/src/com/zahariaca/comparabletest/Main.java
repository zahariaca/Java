package com.zahariaca.comparabletest;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Flight f1 = new Flight(15);
        Flight f2 = new Flight(45);
        Flight f3 = new Flight(300);
        Flight f4 = new Flight(5);
        Flight f5 = new Flight(189);
        Flight f6 = new Flight(546);

        Flight[] flights= {f1,f2,f3,f4,f5,f6};
        Arrays.sort(flights);
        for(Flight flight:flights){
            System.out.println(flight.getFlightTime());
        }
    }
}
