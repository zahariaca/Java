package com.zahariaca.springannotations;

import org.springframework.stereotype.Component;

/**
 * Created by Alex on 02.07.2017.
 */
@Component
public class RESTFortuneService implements FortuneService {
    @Override
    public String getFortune() {
        return "This is REST fortune!";
    }
}
