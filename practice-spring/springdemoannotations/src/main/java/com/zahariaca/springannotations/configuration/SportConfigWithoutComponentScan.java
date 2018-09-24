package com.zahariaca.springannotations.configuration;

import com.zahariaca.springannotations.Coach;
import com.zahariaca.springannotations.FortuneService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by Alex on 02.07.2017.
 */
@Configuration
@PropertySource("classpath:sports.properties")
public class SportConfigWithoutComponentScan {

    // define a method to expose a sad fortune service bean
    @Bean
    public FortuneService sadFortuneService(){
        return new SadFortuneService();
    }

    // define a method to expose a baseball coach bean AND inject dependecny
    @Bean
    public Coach baseballCoach(){
        return new BaseballCoach( sadFortuneService());
    }



}
