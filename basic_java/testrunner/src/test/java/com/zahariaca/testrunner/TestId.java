package com.zahariaca.testrunner;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Zaharia Costin-Alexandru (zaharia.c.alexandru@gmail.com) on 19.07.2019
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface TestId {
    String value() default "NO ID";
}
