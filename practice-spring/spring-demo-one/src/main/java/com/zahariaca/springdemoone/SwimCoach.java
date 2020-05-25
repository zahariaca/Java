package com.zahariaca.springdemoone;

/**
 * Created by Alex on 05.06.2017.
 */
public class SwimCoach implements Coach{

    @Override
    public String getDailyWorkout() {
        return "Swim for 45 minutes";
    }

    @Override
    public String getDailyFortune() {
        return null;
    }
}
