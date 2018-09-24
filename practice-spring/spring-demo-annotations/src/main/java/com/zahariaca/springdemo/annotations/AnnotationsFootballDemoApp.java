package com.zahariaca.springdemo.annotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationsFootballDemoApp {

    public static void main(String[] args) {

        // load the spring config file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // get the bean from the spring container
        Coach myFootballCoach = context.getBean("footballCoach", Coach.class);
        Coach anotherFootballCoach = context.getBean("footballCoach", Coach.class);

        System.out.println("Is this the same object? " + (myFootballCoach == anotherFootballCoach));
        System.out.println("myFootballCoach hashCode: " + myFootballCoach.hashCode());
        System.out.println("anotherFootballCoach hashCode: " + anotherFootballCoach.hashCode());
        System.out.println(myFootballCoach.getDailyWorkout());
        System.out.println(myFootballCoach.getDailyFortune());

        // close context
        context.close();

    }

}
