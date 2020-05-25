package com.zahariaca.springdemo.annotations;

import org.springframework.stereotype.Component;

@Component
public class RESTFortuneService implements FortuneService {
    @Override
    public String getDailyFortune() {
        return "RESTFortune";
    }
}
