package com.zahariaca.hibernate.demo.student;

import com.zahariaca.hibernate.demo.student.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudentDemo {
    public static void main(String[] args) {
        // create the session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // create the session
        Session session = factory.getCurrentSession();

        try {
            // use the session object to save the java object
            System.out.println("Creating new student object...");

            // create the student object
            Student tempStudent = new Student("Paul", "Wall", "paul@email.com");

            // start a transaction
            session.beginTransaction();

            // save the student object
            System.out.println("Saving the student");
            session.save(tempStudent);

            // commit the transaction
            session.getTransaction().commit();
            System.out.println("Done!");

        } finally {
            factory.close();
        }
    }
}
