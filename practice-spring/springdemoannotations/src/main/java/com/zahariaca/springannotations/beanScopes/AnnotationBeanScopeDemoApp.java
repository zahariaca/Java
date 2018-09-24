package com.zahariaca.springannotations.beanScopes;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Alex on 02.07.2017.
 */
public class AnnotationBeanScopeDemoApp {
    public static void main(String[] args) {
        // create the contex by loading the configuration file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext");

        // get the beans from the spring container


        // close the context
    }
}
