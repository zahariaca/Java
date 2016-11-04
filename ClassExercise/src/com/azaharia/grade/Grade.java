package com.azaharia.grade;

import com.azaharia.student.Student;

import java.util.Date;

/**
 * Created by Zaharia Costin-Alexandru, email: zaharia.c.alexandru@gmail.com on 11/4/2016.
 */

public class Grade {
    private Student student;
    private double value;
    private Date examDate;
    private String subject;


    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Date getExamDate() {
        return examDate;
    }

    public void setExamDate(Date examDate) {
        this.examDate = examDate;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "studentFirstName= " + student.getFirstName() +
                " studentLastName= " + student.getLastName() +
                ", value=" + value +
                ", examDate=" + examDate +
                ", subject='" + subject + '\'' +
                '}';
    }

    public String toStringFull() {
        return "Grade{" +
                student +
                ", value=" + value +
                ", examDate=" + examDate +
                ", subject='" + subject + '\'' +
                '}';
    }
}
