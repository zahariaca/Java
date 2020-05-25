package com.zahariaca.springannotations;

import org.springframework.stereotype.Component;

/**
 * Created by Alex on 02.07.2017.
 */
@Component
public class DatabaseFortuneService implements FortuneService{

    @Override
    public String getFortune() {
        return "Database fortune !!!";
    }
}
