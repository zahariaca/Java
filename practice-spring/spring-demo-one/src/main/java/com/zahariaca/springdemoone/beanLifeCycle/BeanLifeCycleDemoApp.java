package com.zahariaca.springdemoone.beanLifeCycle;

import com.zahariaca.springdemoone.Coach;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Alex on 02.07.2017.
 */
public class BeanLifeCycleDemoApp {
    public static void main(String[] args) {
        // load the bean lifecycle configuration file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanLifeCycle-applicationContext.xml");

        // retrieve bean from container
        Coach theCoach = context.getBean("myCoach", Coach.class);

        System.out.println(theCoach.getDailyWorkout());

        // close context
        context.close();
    }
}
