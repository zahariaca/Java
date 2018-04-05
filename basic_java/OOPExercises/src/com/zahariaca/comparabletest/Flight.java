package com.zahariaca.comparabletest;

/**
 * Created by AZaharia on 6/23/2016.
 */
public class Flight implements Comparable<Flight> {
    private int flightTime;

    public Flight(){}
    public Flight(int flightTime){
        this.flightTime = flightTime;
    }

    public int getFlightTime(){ return flightTime;}
    public void setFlightTime(int flightTime){ this.flightTime = flightTime;}

    @Override
    public int compareTo(Flight o) {
        Flight f = (Flight) o;
        return flightTime - f.getFlightTime();
    }
}
