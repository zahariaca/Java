package com.azaharia.main;

import com.azaharia.dataexceptionhandling.DataException;
import com.azaharia.student.Student;
import com.azaharia.student.StudentClasses;

import java.util.List;

/**
 * Created by Zaharia Costin-Alexandru, email: zaharia.c.alexandru@gmail.com on 11/4/2016.
 */
public class StudentMain {
    public static void main(String[] args) {
        Student student = null;
        try {
            student = MockData.getInstance().creatStudent("Alex","Zaharia","1911216211188", 24, 'M', StudentClasses.CLASS_A.getValue(), "Romania","Bucharest","Gheorghe Sincai","920073");
        } catch (DataException e) {
            e.printStackTrace();
        }
        System.out.println(student);
        List<Student> students = null;
        try {
            students = MockData.getInstance().getAllStudents();
        } catch (DataException e) {
            e.printStackTrace();
        }
        for(Student student1 : students){
            System.out.println(student1);
        }
    }
}
