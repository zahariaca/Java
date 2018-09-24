package com.zahariaca.springdemo.annotations;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class FootballCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Practice football today";
    }

    @Override
    public String getDailyFortune() {
        return null;
    }
}
