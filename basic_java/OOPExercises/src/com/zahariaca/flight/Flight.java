package com.zahariaca.flight;

/**
 * Created by azaharia on 05.05.2016.
 */
public class Flight {
    private int passengers = 0;
    private int seats = 150;
    private int flightNumber;
    private char flightClass;
    private boolean[] isSeatAvailable;

    public int getPassengers(){
        return passengers;
    }
    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }
    public int getSeats() {
        return seats;
    }
    public void setSeats(int seats) {
        this.seats = seats;
    }
    public int getFlightNumber(){
        return flightNumber;
    }
    public void setFlightNumber(int flightNumber){
        this.flightNumber = flightNumber;
    }
    public char getFlightClass(){
        return flightClass;
    }
    public void setFlightClass(char flightClass){
        this.flightClass = flightClass;
    }

    {
        isSeatAvailable = new boolean[seats];
        for (int i = 0; i < seats; i++){
            isSeatAvailable[i] = true;
        }
    }

    public Flight(){

    }
    public Flight(int flightNumber){
        this.flightNumber = flightNumber;
    }
    public Flight(char flightClass){
        this.flightClass = flightClass;
    }
    public void add1Passenger(){
        if (passengers < seats){
            passengers += 1;
        }
        else{
            handleFullPlane();
        }
    }
    private void handleFullPlane(){
        System.out.println("The plane is full, no more seats");
    }
    public boolean hasRoom(Flight f2){
        int total = this.passengers + f2.passengers;
        return total <= seats;
    }
    public Flight createNewWithBoth(Flight f2){
        Flight newFlight = new Flight();
        newFlight.seats = seats;
        newFlight.passengers = passengers + f2.passengers;
        return newFlight;
    }

}
