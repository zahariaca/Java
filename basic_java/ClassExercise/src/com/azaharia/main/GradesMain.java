package com.azaharia.main;

import com.azaharia.dataexceptionhandling.DataException;
import com.azaharia.grade.Grade;

import java.util.List;

/**
 * Created by Zaharia Costin-Alexandru, email: zaharia.c.alexandru@gmail.com on 11/4/2016.
 */
public class GradesMain {
    public static void main(String[] args) {
        List<Grade> grades = null;
        try {
            grades = MockData.getInstance().getAllGrades();
        } catch (DataException e) {
            e.printStackTrace();
        }
        for(Grade grade : grades){
            System.out.println(grade);
        }
    }
}
