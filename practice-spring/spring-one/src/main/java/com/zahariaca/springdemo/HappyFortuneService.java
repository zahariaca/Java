package com.zahariaca.springdemo;

public class HappyFortuneService implements FortuneService {
    @Override
    public String getFortune() {
        return "Today is your lucky day";
    }

    @Override
    public String toString() {
        return "HappyFortuneService{}";
    }
}
