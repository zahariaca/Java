package com.zahariaca.springdemo.annotations;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Component
public class RandomFortuneService implements FortuneService {
    List<String> randomFortuneList = Arrays.asList(
            "Good fortune",
            "Neutral fortune",
            "Bad fortune",
            "Chaotic netural fortune"
    );

    Random myRandomNumberGenerator = new Random();

    @Override
    public String getDailyFortune() {
        return randomFortuneList.get(myRandomNumberGenerator.nextInt(randomFortuneList.size()));
    }
}
