package com.zahariaca.testrunner;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ MyFirstTestClass.class, MySecondTestClass.class})
public class MyRunner {
}
