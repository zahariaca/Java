package com.zahariaca.hibernate.example1.demo;

import com.zahariaca.hibernate.example1.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

/**
 * Created by Alex on 04.06.2017.
 */
public class QueryStudentDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                                    .configure("hibernate.cfg.xml")
                                    .addAnnotatedClass(Student.class)
                                    .buildSessionFactory();

        // create a session
        Session session = factory.getCurrentSession();

        try{
            // start a transaction
            session.beginTransaction();

            // query students
            List<Student> theStudents = session.createQuery("from Student").getResultList();

            // display all the students
            displayStudents(theStudents);


            // query  students where lastName = "Doe"
            System.out.println("\nStudents who have a last name of DOE");
            theStudents = session.createQuery("from Student s where s.lastName='Doe'").getResultList();

            // display all the students where lastName = "Doe"
            displayStudents(theStudents);

            // query  students where lastName = "Doe" OR firstName = "DAFFY"
            System.out.println("\nStudents who have a last name of DOE or a first name of DAFFY");
            theStudents = session.createQuery("from Student s where s.lastName='Doe'" +
                    "OR s.firstName = 'DAFFY'").getResultList();

            // display all the students where lastName = "Doe" OR firstName = "Duck"
            displayStudents(theStudents);

            // query  students where email LIKE "%luv2code.com" , % = wildcard, email ends in "luv2code.com"
            System.out.println("\nStudents who have an email ending in 'luv2code.com'");
            theStudents = session.createQuery("from Student s where s.email LIKE '%luv2code.com'").getResultList();

            // display all the students where email LIKE "%luv2code.com"
            displayStudents(theStudents);

            //commit the transaction
            session.getTransaction().commit();

            System.out.println("\n==================================================\nDone");
        }finally {
            factory.close();
        }
    }

    private static void displayStudents(List<Student> theStudents) {
        // display all the students
        for (Student s : theStudents){
            System.out.println("Student: " + s);
        }
    }

}
