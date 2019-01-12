package com.zahariaca.springdemo.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;
import java.util.Random;

@Component
@Scope("prototype")
public class FootballCoach implements Coach {

    private FortuneService fortuneService;

    public FootballCoach() {

    }

    @Autowired
    public FootballCoach(@Qualifier("fileFortuneService") FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Practice football today";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getDailyFortune();
    }

    @PostConstruct
    public void initMethod() {
        System.out.println("-- FootballCoach: initMethod()");
    }

    @PreDestroy
    public void destroyMethod() {
        System.out.println("-- FootballCoach: destroyMethod()");
    }

}
