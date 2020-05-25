package com.zahariaca.springdemo.annotations.activity7;

import com.zahariaca.springdemo.annotations.Coach;
import com.zahariaca.springdemo.annotations.FortuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class SquashCoach implements Coach {

    private FortuneService fortuneService;

    private String email;

    private String team;

    @PostConstruct
    private void initMethod(){
        System.out.println("-- SquashCoach: init method PostConstruct");
    }

    public SquashCoach() {
        System.out.println(">> SquashCoach: default constructor");
    }

    @Override
    public String getDailyWorkout() {
        return "Bounce a ball of the wall for 10000 times";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getDailyFortune();
    }

    public FortuneService getFortuneService() {
        return fortuneService;
    }

    @Autowired
    @Qualifier("chaoticNeutralFortuneService")
    public void setFortuneService(FortuneService fortuneService) {
        System.out.println(">> SquashCoach: setFortuneService");
        this.fortuneService = fortuneService;
    }

    public String getEmail() {
        return email;
    }

    @Value("${foo.email}")
    public void setEmail(String email) {
        System.out.println(">> SquashCoach: setEmail");
        this.email = email;
    }

    public String getTeam() {
        return team;
    }

    @Value("${foo.team}")
    public void setTeam(String team) {
        System.out.println(">> SquashCoach: setTeam");
        this.team = team;
    }

    @PreDestroy
    private void destroyMethod() {
        System.out.println("-- SquashCoach: destroy method PreDestroy");
    }
}
