package com.zahariaca.testrunner;

import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

@TestSuiteName("SecondTest")
@ReportLocation("~/Documents/SecondTest.json")
public class MySecondTestClass extends MyBaseTestClass{
    @Test
    @TestId("ID3")
    public void fails() {
        fail();
    }

    @Test
    @TestId("ID4")
    public void succeeds() {
        assertTrue(true);
    }
}