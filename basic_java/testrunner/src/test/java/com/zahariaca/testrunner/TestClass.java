package com.zahariaca.testrunner;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertTrue;

/**
 * @author Zaharia Costin-Alexandru (zaharia.c.alexandru@gmail.com) on 19.07.2019
 */
@RunWith(MyTestRunner.class)
@TestSuiteName
public class TestClass {

    @AfterClass
    public void name() {
        System.out.println("teardown");
    }

    @Test
    @TestId("ID_1")
    public void test() {
        assertTrue(true);
    }
}
