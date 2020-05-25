package com.zahariaca.springannotations;

import org.springframework.stereotype.Component;

/**
 * Created by Alex on 02.07.2017.
 */
@Component
public class HappyFortuneService implements FortuneService {

    public HappyFortuneService(){
        System.out.println(">> Inside the constructor of HappyFortuneService");
    }

    @Override
    public String getFortune() {
        return "Today is your lucky day!";
    }
}
