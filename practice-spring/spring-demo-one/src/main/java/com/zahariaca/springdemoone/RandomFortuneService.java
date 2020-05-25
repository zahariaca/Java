package com.zahariaca.springdemoone;

import java.util.Random;

/**
 * Created by Alex on 05.06.2017.
 */
public class RandomFortuneService implements FortuneService {
    String[] randomFortunes = {"Fortune 1", "Fortune 2", "Fortune 3"};

    @Override
    public String getFortune() {
        return randomFortunes[new Random().nextInt(3)];
    }
}
