package com.zahariaca.springdemoone;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Alex on 05.06.2017.
 */
public class HelloSpringApp {
    public static void main(String[] args) {

        // load the spring configuration file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // retrieve a bean from the spring container
        Coach theCoach = context.getBean("myCoach", Coach.class);

        // call a method on the bean
        System.out.println(theCoach.getDailyWorkout());
        System.out.println(theCoach.getDailyFortune());

        // close the context
        context.close();
    }
}
