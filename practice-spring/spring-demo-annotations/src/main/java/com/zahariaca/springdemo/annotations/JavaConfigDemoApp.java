package com.zahariaca.springdemo.annotations;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JavaConfigDemoApp {

    public static void main(String[] args) {

        // use configuration class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);


        // get the bean from the spring container
        Coach myTennisCoach = context.getBean("tennisCoach", Coach.class);

        // call methods on bean
        System.out.println(myTennisCoach.getDailyWorkout());
        System.out.println(myTennisCoach.getDailyFortune());

        // close context
        context.close();

    }

}
