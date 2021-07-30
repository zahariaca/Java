package com.zahariaca.hibernate.example1.demo;

import com.zahariaca.hibernate.example1.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by Alex on 04.06.2017.
 */
public class CreateStudentDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // create a session
        Session session = factory.getCurrentSession();

        try {
            // create the student object
            System.out.println("Creating a new student object");
            Student tempStudent = new Student("Paul", "Wall", "pwall@luv2code.com");

            // start a transaction
            session.beginTransaction();

            // save the student object
            System.out.println("Saving the student object");
            session.save(tempStudent);

            //commit the transaction
            session.getTransaction().commit();

            System.out.println("Done");
        } finally {
            factory.close();
        }
    }

}
