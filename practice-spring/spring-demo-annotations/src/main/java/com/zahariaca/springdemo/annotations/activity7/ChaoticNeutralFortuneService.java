package com.zahariaca.springdemo.annotations.activity7;

import com.zahariaca.springdemo.annotations.FortuneService;
import org.springframework.stereotype.Component;

@Component
public class ChaoticNeutralFortuneService implements FortuneService {
    @Override
    public String getDailyFortune() {
        return "Your fortune may be good or bad,  who know?";
    }
}
