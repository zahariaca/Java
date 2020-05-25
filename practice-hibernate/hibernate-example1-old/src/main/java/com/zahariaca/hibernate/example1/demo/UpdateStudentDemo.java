package com.zahariaca.hibernate.example1.demo;

import com.zahariaca.hibernate.example1.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by Alex on 04.06.2017.
 */
public class UpdateStudentDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                                    .configure("hibernate.cfg.xml")
                                    .addAnnotatedClass(Student.class)
                                    .buildSessionFactory();

        // create a session
        Session session = factory.getCurrentSession();

        try{
            int studentID=1;
            // start a transaction
            session.beginTransaction();

            // retrieve student based on ID
            System.out.println("\nGetting student with id: " + studentID);
            Student student1 = session.get(Student.class, studentID);

            System.out.println("Get complete: " + student1);
            System.out.println("Updating the student...");

            student1.setFirstName("Scooby");

            // commit transaction
            session.getTransaction().commit();

            // update all emails to foo@bar.com
            session = factory.getCurrentSession();
            session.beginTransaction();

            // update email for all students
            System.out.println("Updating email for all students to: foo@bar.com");
            session.createQuery("update Student set email='foo@bar.com'")
                    .executeUpdate();

            // commit transaction
            session.getTransaction().commit();

            // update email for all that have family name of 'Duck' to duck@gmail.com
            session = factory.getCurrentSession();
            session.beginTransaction();

            // update email for all that have family name of 'Duck' to duck@gmail.com
            System.out.println("Updating email for all that have family name of 'Duck' to duck@gmail.com");
            session.createQuery("update Student set email='duck@gmail.com'  where lastName='Duck' ")
                    .executeUpdate();

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");

        }finally {
            factory.close();
        }
    }

}
