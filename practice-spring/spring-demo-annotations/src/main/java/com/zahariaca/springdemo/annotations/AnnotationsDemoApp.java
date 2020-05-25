package com.zahariaca.springdemo.annotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationsDemoApp {

    public static void main(String[] args) {

        // load the spring config file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // get the bean from the spring container
        Coach myTennisCoach = context.getBean("tennisCoach", Coach.class);

        Coach myFootballCoach = context.getBean("footballCoach", Coach.class);
        Coach anotherFootballCoach = context.getBean("footballCoach", Coach.class);

        // call methods on bean
        System.out.println(myTennisCoach.getDailyWorkout());
        System.out.println(myTennisCoach.getDailyFortune());

        // close context
        context.close();

    }

}
