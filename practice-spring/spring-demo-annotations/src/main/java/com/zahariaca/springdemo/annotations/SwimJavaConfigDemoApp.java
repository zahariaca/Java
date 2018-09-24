package com.zahariaca.springdemo.annotations;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp {

    public static void main(String[] args) {
        // use configuration class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfigNoScan.class);


        // get the bean from the spring container
        SwimCoach theCoach = context.getBean("swimCoach", SwimCoach.class);

        // call methods on bean
        System.out.println(theCoach.getDailyWorkout());
        System.out.println(theCoach.getDailyFortune());
        System.out.println(theCoach.getEmailAddress());
        System.out.println(theCoach.getTeam());

        // close context
        context.close();
    }
}
