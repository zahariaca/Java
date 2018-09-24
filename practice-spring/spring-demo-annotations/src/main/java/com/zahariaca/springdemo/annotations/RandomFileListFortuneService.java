package com.zahariaca.springdemo.annotations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Component
public class RandomFileListFortuneService implements FortuneService {
    @Value("#{'${fortune.list}'.split(',')}")
    private List<String> myList;

    @Override
    public String getDailyFortune() {
        return myList.get(new Random().nextInt(myList.size()));
    }
}
