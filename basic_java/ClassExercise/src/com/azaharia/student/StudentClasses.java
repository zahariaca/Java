package com.azaharia.student;

/**
 * Created by Zaharia Costin-Alexandru, email: zaharia.c.alexandru@gmail.com on 11/4/2016.
 */
public enum StudentClasses {
    CLASS_A("A"),
    CLASS_B("B"),
    CLASS_C("C");

    private String value;

    StudentClasses(String value) {
        this.value=value;
    }
    public String getValue(){
        return value;
    }

}
