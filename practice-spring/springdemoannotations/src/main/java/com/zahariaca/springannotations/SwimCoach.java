package com.zahariaca.springannotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by Alex on 02.07.2017.
 */
@Component
@Scope("prototype")
public class SwimCoach implements Coach {
    @Autowired
    @Qualifier("RESTFortuneService")
    FortuneService fortuneService;

    @Value("${foo.email}")
    private String email;
    @Value("${foo.team}")
    private String teamName;

    public String getCoachCredentials(){
        return "Email: " + email +" , team: " + teamName;
    }

    @Override
    public String getDailyWorkout() {
        return "Email: " + email +" , team: " + teamName + " said you should swim for 1.4 million hours";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
