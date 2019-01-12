package com.zahariaca.springannotations.configuration.endexercise;

import com.zahariaca.springannotations.Coach;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Alex on 02.07.2017.
 */
public class FootballConfigurationDemoApp {
    public static void main(String[] args) {
        // get the context by using the config class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(FootballConfig.class);

        // get a bean of type football coach
        Coach footballCoach = context.getBean("footballCoach", Coach.class);

        //call methods of the football coach object
        System.out.println(footballCoach.getDailyWorkout());
        System.out.println(footballCoach.getDailyFortune());

        //close the context
        context.close();
    }
}
