package com.zahariaca.springdemoone;

/**
 * Created by Alex on 05.06.2017.
 */
public class MyApp {

    public static void main(String[] args) {

        // create the object
        Coach baseballCoach = new TrackCoach();

        // use the object
        System.out.println(baseballCoach.getDailyWorkout());

    }

}
