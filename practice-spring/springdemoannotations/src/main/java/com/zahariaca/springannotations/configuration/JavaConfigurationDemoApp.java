package com.zahariaca.springannotations.configuration;

import com.zahariaca.springannotations.Coach;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Alex on 02.07.2017.
 */
public class JavaConfigurationDemoApp {
    public static void main(String[] args) {
        // get the context using the configuration class we created
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);

        // get the beans from the spring container
        Coach tennisCoach = context.getBean("tennisCoach", Coach.class);

        // call functions from the coach classes
        System.out.println(tennisCoach.getDailyWorkout());

        // close the context
        context.close();
    }
}
