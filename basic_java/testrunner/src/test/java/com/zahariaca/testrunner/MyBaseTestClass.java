package com.zahariaca.testrunner;

import org.junit.AfterClass;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyBaseTestClass {
    private static String location = "";
    private static String watchedLog = "";
    private static Map<String, List<ReportPojo>> reports = new HashMap<>();

    @ClassRule
    public static TestWatcher classWatch = new TestWatcher() {
        @Override
        protected void starting(Description description) {
            location = description.getTestClass().getAnnotation(ReportLocation.class).value();
        }
    };

    @Rule
    public TestWatcher watchman = new TestWatcher() {
        @Override
        protected void failed(Throwable e, Description description) {
            String value = description.getTestClass().getAnnotation(TestSuiteName.class).value();
            String id = description.getAnnotation(TestId.class).value();

            reports.putIfAbsent(value, new ArrayList<ReportPojo>());
            reports.get(value).add(new ReportPojo(id, false));

            watchedLog += description + "\n";
        }

        @Override
        protected void succeeded(Description description) {
            String value = description.getTestClass().getAnnotation(TestSuiteName.class).value();
            String id = description.getAnnotation(TestId.class).value();
            reports.putIfAbsent(value, new ArrayList<ReportPojo>());
            reports.get(value).add(new ReportPojo(id, true));

            watchedLog += description + " " + "success!\n";
        }
    };

    @AfterClass
    public static void test() {
        System.out.println("---------------------------------");
        System.out.println(location);
        reports.forEach((k, v) -> System.out.println("Key " + k + " Value " + v));
        reports.clear();
    }
}