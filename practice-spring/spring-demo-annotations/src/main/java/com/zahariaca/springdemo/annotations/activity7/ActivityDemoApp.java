package com.zahariaca.springdemo.annotations.activity7;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ActivityDemoApp {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ActivityConfig.class);

        SquashCoach theCoach = context.getBean("squashCoach", SquashCoach.class);

        System.out.println(theCoach.getDailyWorkout());
        System.out.println(theCoach.getDailyFortune());
        System.out.println("email: " + theCoach.getEmail());
        System.out.println("team: " + theCoach.getTeam());

        context.close();
    }

}
