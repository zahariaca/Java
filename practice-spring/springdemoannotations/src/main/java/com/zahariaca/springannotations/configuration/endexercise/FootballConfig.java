package com.zahariaca.springannotations.configuration.endexercise;

import com.zahariaca.springannotations.Coach;
import com.zahariaca.springannotations.FortuneService;
import com.zahariaca.springannotations.RESTFortuneService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Alex on 02.07.2017.
 */
@Configuration
public class FootballConfig {

    // define a method to expose a REST fortune service bean
    @Bean
    public FortuneService RESTFortuneServiec(){
        return new RESTFortuneService();
    }

    // define a method to expose a football coach bean
    @Bean
    public Coach footballCoach(){
        return new FootballCoach( RESTFortuneServiec());
    }
}
