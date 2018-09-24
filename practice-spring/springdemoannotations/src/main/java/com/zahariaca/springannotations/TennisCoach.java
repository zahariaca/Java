package com.zahariaca.springannotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by Alex on 02.07.2017.
 */
@Component
@Scope("singleton")
public class TennisCoach implements Coach {

    // You can inject directly in a field, using Spring
    // it uses Java Reflections to do this.
    // We use Qualifier when we have multiple implementations of FortuneService
    // this way Spring knows which one we want here.
    @Autowired
    @Qualifier("fileRandomFortuneService")
    private FortuneService fortuneService;


    // define a default constructor
    public TennisCoach(){
        System.out.println(">> TennisCoach: Inside the default constructor");
    }

    /*@Autowired
    public TennisCoach(FortuneService fortuneService){
        this.fortuneService = fortuneService;
    }*/

    @Override
    public String getDailyWorkout() {
        return "Practice your backhand volley";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

    // With spring you can inject dependencies in any method
/*    @Autowired
    public void setFortuneService(FortuneService fortuneService) {
        System.out.println(">> TennisCoach: Inside the setFortuneService method");
        this.fortuneService = fortuneService;
    }*/

/*    @Autowired
    public void doSomeCrazyStuff(FortuneService fortuneService) {
        System.out.println(">> TennisCoach: Inside the doSomeCrazyStuff method");
        this.fortuneService = fortuneService;
    }*/

    // Handling operations at initialization and at destruction
    @PostConstruct
    private void doMyInitializationStuff(){
        System.out.println(">> Calling the function doMyInitializationStuff");
    }

    @PreDestroy
    private void doMyCleanupStuff(){
        System.out.println(">> Calling the function doMyCleaunStuff");
    }
}

