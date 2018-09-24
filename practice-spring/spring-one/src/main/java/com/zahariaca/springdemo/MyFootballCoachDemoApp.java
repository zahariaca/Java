package com.zahariaca.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyFootballCoachDemoApp {

    public static void main(String[] args) {

        // load the spring configuration file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // retrieve theFootballCoach bean from spring container
        FootballCoach theFootballCoach = context.getBean("myFootballCoach", FootballCoach.class);

        FootballCoach anotherFootballCoach = context.getBean("myFootballCoach", FootballCoach.class);

        System.out.println(theFootballCoach.getDailyWorkout());
        System.out.println(theFootballCoach.getDailyFortune());
        System.out.println(theFootballCoach.getEmailAddress());
        System.out.println(theFootballCoach.getTeam());
        System.out.println(theFootballCoach);

        System.out.println("These are prototype objects? " + (theFootballCoach == anotherFootballCoach));
        System.out.println("theFootballCoach hashcode: " + theFootballCoach.hashCode());
        System.out.println("anotherFootballCoach hashcode: " + anotherFootballCoach.hashCode());

        // close application context
        context.close();
    }
}
