package com.zahariaca.springdemoone;

/**
 * Created by Alex on 05.06.2017.
 */
public class BaseballCoach implements Coach{
    // define a private field for the dependency
    private FortuneService fortuneService;

    // define a constructor for the dependency constructor
    public BaseballCoach(FortuneService fortuneService){
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Spend 30 minutes on batting practice";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

}
