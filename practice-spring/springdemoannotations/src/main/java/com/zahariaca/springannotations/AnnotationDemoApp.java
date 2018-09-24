package com.zahariaca.springannotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Alex on 02.07.2017.
 */
public class AnnotationDemoApp {
    public static void main(String[] args) {
        // get the application context from the  spring configuration file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // get a bean from the spring container
        Coach tennisCoash = context.getBean("tennisCoach", Coach.class);
        Coach swimCoach = context.getBean("swimCoach", Coach.class);
        Coach swimCoach2 = context.getBean("swimCoach", Coach.class);

        boolean result = (swimCoach == swimCoach2);

        // call a method on the bean
        System.out.println(tennisCoash.getDailyWorkout());

        // call a method to get the daily fortune
        System.out.println(tennisCoash.getDailyFortune());

        // call a method from the Swim Coach
        System.out.println(swimCoach.getDailyWorkout());
        System.out.println(" The swim coaches are the same object: " + result);
        // close the spring container
        context.close();
    }
}
