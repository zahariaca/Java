package com.zahariaca.springannotations.configuration;

import com.zahariaca.springannotations.FortuneService;

/**
 * Created by Alex on 02.07.2017.
 */
public class SadFortuneService implements FortuneService {
    @Override
    public String getFortune() {
        return "Very bad luck today!!!";
    }
}
