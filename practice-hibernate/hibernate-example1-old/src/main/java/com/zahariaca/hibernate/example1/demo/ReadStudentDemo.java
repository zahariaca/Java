package com.zahariaca.hibernate.example1.demo;

import com.zahariaca.hibernate.example1.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by Alex on 04.06.2017.
 */
public class ReadStudentDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // create a session
        Session session = factory.getCurrentSession();

        try {
            // WRITING OBJECT TO DB
            // create the student object
            System.out.println("Creating a new student object");
            Student tempStudent = new Student("Daffy", "Duck", "dduck@gmail.com");

            // start a transaction
            session.beginTransaction();

            // save the student object
            System.out.println("Saving the student object");
            System.out.println(tempStudent);
            session.save(tempStudent);

            // commit the transaction
            session.getTransaction().commit();

            // find out the students primary key
            System.out.println("Saved student with id: " + tempStudent.getId());
            System.out.println("Done!");

            // RETRIEVING OBJECT FROM DB
            System.out.println("Retrieving a student object by id");

            // get a new session
            Session session2 = factory.getCurrentSession();

            // start a new transaction
            session2.beginTransaction();

            // retrieve student based on ID
            System.out.println("\nGetting student with id: " + tempStudent.getId());
            Student student1 = session2.get(Student.class, tempStudent.getId());

            System.out.println("Get complete: " + student1);

            // commit transaction
            session2.getTransaction().commit();
            System.out.println("Done!");

        } finally {
            factory.close();
        }
    }

}
