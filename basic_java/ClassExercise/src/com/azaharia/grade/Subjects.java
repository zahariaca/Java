package com.azaharia.grade;

/**
 * Created by Zaharia Costin-Alexandru, email: zaharia.c.alexandru@gmail.com on 11/4/2016.
 */
public enum Subjects {
    SUBJECT_1("Subject 1"),
    SUBJECT_2("Subject 2"),
    SUBJECT_3("Subject 3"),
    SUBJECT_4("Subject 4");

    private String value;

    Subjects(String value){
        this.value=value;
    }

    public String getValue() {
        return value;
    }
}
