package com.zahariaca.springannotations;

import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * Created by Alex on 02.07.2017.
 */
@Component
public class RandomFortuneService implements FortuneService {
    // create an Array of strings
    private String[] data = {
            "Fortune number 1",
            "Fortune number 2",
            "Fortune number 3",
            "Fortune number 4",
            "Fortune nubmer 5",
    };
    private Random myRandom = new Random();

    @Override
    public String getFortune() {
        // pick a random element from our array
        return data[myRandom.nextInt(data.length)];
    }
}
