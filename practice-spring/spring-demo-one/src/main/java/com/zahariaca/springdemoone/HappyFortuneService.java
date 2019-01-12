package com.zahariaca.springdemoone;

/**
 * Created by Alex on 05.06.2017.
 */
public class HappyFortuneService implements FortuneService{
    @Override
    public String getFortune() {
        return "Very good luck!";
    }
}
