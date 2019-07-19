package com.zahariaca.testrunner;

import org.junit.Test;
import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.notification.RunNotifier;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Zaharia Costin-Alexandru (zaharia.c.alexandru@gmail.com) on 19.07.2019
 */
public class MyTestRunner extends Runner {
    private Class testClass;
    private Map<Method, Description> methodDescriptions;

    public MyTestRunner(Class testClass) {
        this.testClass = testClass;
        methodDescriptions = new HashMap<>();
    }

    @Override
    public Description getDescription() {
        Description description =
                Description.createSuiteDescription(
                        testClass.getName(),
                        testClass.getAnnotations());

        for (Method method : testClass.getMethods()) {
            Annotation annotation =
                    method.getAnnotation(Test.class);
            if (annotation != null) {
                Description methodDescription =
                        Description.createTestDescription(
                                testClass,
                                method.getName(),
                                annotation);
                description.addChild(methodDescription);

                methodDescriptions.put(method, methodDescription);
            }
        }

        return description;
    }

    @Override
    public void run(RunNotifier notifier) {
        System.out.println("running the tests from MyRunner: " + testClass);
        try {
            Object testObject = testClass.newInstance();
            for (Method method : testClass.getMethods()) {
                if (method.isAnnotationPresent(Test.class)) {
                    notifier.fireTestStarted(Description
                            .createTestDescription(testClass, method.getName()));
                    method.invoke(testObject);
                    Description ds = Description
                            .createTestDescription(
                                    testClass,
                                    method.getName(),
                                    method.getAnnotations());
                    System.out.println(ds);
                    notifier.fireTestFinished(ds);
                }
            }
        } catch (Exception e) {
            System.out.println("AZAHARIA IN CATCH");
            throw new RuntimeException(e);
        }
    }


}
