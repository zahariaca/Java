package com.zahariaca.flight;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Flight plane1 = new Flight();
        plane1.setSeats(200);
        plane1.setPassengers(30);
        System.out.printf("Number of passenger: %s%n", plane1.getPassengers());
        System.out.printf("Number of seats: %s%n", plane1.getSeats());
        plane1.add1Passenger(1);
        System.out.printf("Number of passenger: %s%n", plane1.getPassengers());
        System.out.printf("Number of seats: %s%n", plane1.getSeats());
        plane1.add1Passenger(50);
        System.out.printf("Number of passenger: %s%n", plane1.getPassengers());
        System.out.printf("Number of seats: %s%n", plane1.getSeats());

        Flight plane2 = new Flight();
        plane2.add1Passenger(120);

        Flight plane3;

        if (plane1.hasRoom(plane2)){
            plane3 = plane1.createNewWithBoth(plane2);
            System.out.printf("Number of passengers for plane 3: %S%n", plane3.getPassengers());
        }else {
            System.out.println("Not enough room");
        }
    }
}
