package com.zahariaca.springdemoone;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Alex on 05.06.2017.
 */
public class SetterDemoApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        CricketCoach theCoach2 = context.getBean("myCricketCoach", CricketCoach.class);

        // call methods for the 2nd bean
        System.out.println(theCoach2.getDailyWorkout());
        System.out.println(theCoach2.getDailyFortune());

        // call our methods to get the injected literal values
        System.out.println("The coach email is: " + theCoach2.getEmailAddress() + ", and the team is: " + theCoach2.getTeam());

        context.close();

    }
}
