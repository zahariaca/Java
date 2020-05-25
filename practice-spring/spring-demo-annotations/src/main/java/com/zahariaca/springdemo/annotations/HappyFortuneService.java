package com.zahariaca.springdemo.annotations;

import org.springframework.stereotype.Component;

@Component
public class HappyFortuneService implements FortuneService {

    @Override
    public String getDailyFortune() {
        return "Today is your lucky day";
    }
}
