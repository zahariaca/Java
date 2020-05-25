package com.azaharia.main;

import com.azaharia.dataexceptionhandling.DataException;
import com.azaharia.grade.Grade;
import com.azaharia.grade.Subjects;
import com.azaharia.student.Address;
import com.azaharia.student.Student;
import com.azaharia.student.StudentClasses;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MockData {
    private static MockData instance = new MockData();
    private List<Student> students;
    private List<Grade> grades;

    private MockData(){}

    public static MockData getInstance(){
        return instance;
    }

    public Grade createGrades( Student student, double value, Date examDate,String subject){
        Grade grade = new Grade();
        grade.setSubject(subject);
        grade.setValue(value);
        grade.setExamDate(examDate);
        grade.setStudent(student);
        return grade;
    }

    public List<Grade> getAllGrades() throws DataException {
        if(grades == null){
            grades = new ArrayList<Grade>();
            if (students == null){
                students = getAllStudents();
            }
            for (Student student : students){
                grades.add(createGrades(student,10, new Date(), Subjects.SUBJECT_1.getValue()));
                grades.add(createGrades(student,10, new Date(), Subjects.SUBJECT_2.getValue()));
                grades.add(createGrades(student,10, new Date(), Subjects.SUBJECT_3.getValue()));
                grades.add(createGrades(student,10, new Date(), Subjects.SUBJECT_4.getValue()));
            }
        }

        return grades;
    }

    public Student creatStudent(String firstName, String lastName, String CNP,
                                int age, char gender, String studentClasses,
                                String country, String city, String streetName,
                                String zipcode) throws DataException
    {
        Student student = new Student();
        student.setFirstName(firstName);
        student.setLastName(lastName.toUpperCase());
        if((CNP.charAt(0) == '1' && gender == 'F') || (CNP.charAt(0) == '2' && gender == 'M')){
            throw new DataException("CNP or gender is invalid. CNP: " + CNP + " gender: " + gender);
        } else {
            student.setCNP(CNP);
        }
        student.setAge(age);
        student.setStudentClass(studentClasses);
        student.setGender(gender);
        student.setAddress(createStudentAddress(country,city, streetName,zipcode));
        return student;
    }

    private Address createStudentAddress(String country, String city, String streetName, String zipcode) {
        return new Address(country,city, streetName,zipcode);
    }

    public List<Student> getAllStudents() throws DataException {
        if(students == null){
            students = new ArrayList<Student>();
        }
        students.add(creatStudent("Alex","Zaharia","1911216211188", 24, 'M', StudentClasses.CLASS_A.getValue(), "Romania","Bucharest","Gheorghe Sincai","920073"));
        students.add(creatStudent("Alex","Zaharia","1911216211188", 24, 'M', StudentClasses.CLASS_A.getValue(), "Romania","Bucharest","Gheorghe Sincai","920073"));
        students.add(creatStudent("Andrei","Popescu","1911216211187", 24, 'M', StudentClasses.CLASS_B.getValue(), "Romania","Bucharest","Gheorghe Sincai","920073"));
        students.add(creatStudent("Andreea","Popescu","2911216211187", 22, 'F', StudentClasses.CLASS_B.getValue(), "Romania","Bucharest","Gheorghe Sincai","920073"));
        students.add(creatStudent("Alexa","Zaharia","2911216211188", 25, 'F', StudentClasses.CLASS_C.getValue(), "Romania","Bucharest","Gheorghe Sincai","920073"));
        students.add(creatStudent("Andreea","Zaharia","2911216211188", 34, 'F', StudentClasses.CLASS_C.getValue(), "Romania","Bucharest","Gheorghe Sincai","920073"));
        return students;
    }

}
