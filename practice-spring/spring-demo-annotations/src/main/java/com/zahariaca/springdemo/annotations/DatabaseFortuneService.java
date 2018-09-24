package com.zahariaca.springdemo.annotations;

import org.springframework.stereotype.Component;

@Component
public class DatabaseFortuneService implements FortuneService {

    @Override
    public String getDailyFortune() {
        return "Database fortune";
    }
}
