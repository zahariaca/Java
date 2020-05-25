package com.zahariaca.springannotations.configuration;

import com.zahariaca.springannotations.Coach;
import com.zahariaca.springannotations.FortuneService;
import org.springframework.beans.factory.annotation.Value;

/**
 * Created by Alex on 02.07.2017.
 */
public class BaseballCoach implements Coach {
    private FortuneService fortuneService;
    @Value("${foo.email}")
    private String email;
    @Value("${foo.team}")
    private String teamName;


    public BaseballCoach(FortuneService fortuneService){
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Email: " + email +" , team: " + teamName + "said: Do some basebally stuff!";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
