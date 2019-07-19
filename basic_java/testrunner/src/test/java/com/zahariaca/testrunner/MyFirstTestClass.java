package com.zahariaca.testrunner;

import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;


@TestSuiteName("Test1")
@ReportLocation("~/log/Test1.json")
public class MyFirstTestClass extends MyBaseTestClass{
    @Test
    @TestId("ID1")
    public void fails() {
        fail();
    }

    @Test
    @TestId("ID2")
    public void succeeds() {
        assertTrue(true);
    }
}
