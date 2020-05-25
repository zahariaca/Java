package com.zahariaca.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterInjectionDemoApp {

    public static void main(String[] args) {

        // load the spring configuration file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // retrieve myCricketCoach bean from spring container
        CricketCoach theCricketCoach = context.getBean("myCricketCoach", CricketCoach.class);

        // call methods on bean
        System.out.println(theCricketCoach.getDailyWorkout());
        System.out.println(theCricketCoach.getDailyFortune());
        System.out.println(theCricketCoach.getEmailAddress());
        System.out.println(theCricketCoach.getTeam());
        System.out.println(theCricketCoach);
        System.out.println(String.format("%n---------------------------------%n"));

        FootballCoach theFootballCoach = context.getBean("myFootballCoach", FootballCoach.class);
        System.out.println(theFootballCoach.getDailyWorkout());
        System.out.println(theFootballCoach.getDailyFortune());
        System.out.println(theFootballCoach.getEmailAddress());
        System.out.println(theFootballCoach.getTeam());
        System.out.println(theFootballCoach);

        // close application context
        context.close();
    }
}
