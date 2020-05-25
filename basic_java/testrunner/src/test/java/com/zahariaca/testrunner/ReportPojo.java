package com.zahariaca.testrunner;

public class ReportPojo {
    private String id;
    private boolean passed;

    public ReportPojo(String id, boolean passed) {
        this.id = id;
        this.passed = passed;
    }

    @Override
    public String toString() {
        return "ReportPojo{" +
                "id='" + id + '\'' +
                ", passed=" + passed +
                '}';
    }
}
