package com.zahariaca.springannotations.configuration.endexercise;

import com.zahariaca.springannotations.Coach;
import com.zahariaca.springannotations.FortuneService;

/**
 * Created by Alex on 02.07.2017.
 */
public class FootballCoach implements Coach {
    private FortuneService fortuneService;

    public FootballCoach(FortuneService fortuneService){
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Run 20 laps of the football field";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
