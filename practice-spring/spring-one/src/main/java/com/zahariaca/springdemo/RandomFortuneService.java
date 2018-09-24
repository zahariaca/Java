package com.zahariaca.springdemo;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RandomFortuneService implements FortuneService{
    List<String> randomFortuneList = Arrays.asList(
            "Bad fortune",
            "Neutral fortune",
            "Good fortune"
    );

    @Override
    public String getFortune() {
        return randomFortuneList.get(new Random().nextInt(2));
    }

    @Override
    public String toString() {
        return "RandomFortuneService{" +
                "randomFortuneList=" + randomFortuneList +
                '}';
    }
}
