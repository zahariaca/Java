package com.zahariaca.springdemoone.beanScope;

import com.zahariaca.springdemoone.Coach;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Alex on 02.07.2017.
 */
public class BeanScopeDemoApp {
    public static void main(String[] args) {
        // load the scope configuration file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");

        // retrieve bean from the container
        Coach theCoach = context.getBean("myCoach", Coach.class);

        Coach alphaCoach = context.getBean("myCoach", Coach.class);

        // check if these are the same beans
        boolean result = (theCoach == alphaCoach);

        // print out the results
        System.out.println(theCoach);
        System.out.println(alphaCoach);
        System.out.println("Pointing to the same object: " + result);

        // close the context
        context.close();
    }
}
