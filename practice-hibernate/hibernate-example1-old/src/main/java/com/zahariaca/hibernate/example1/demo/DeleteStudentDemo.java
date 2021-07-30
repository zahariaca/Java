package com.zahariaca.hibernate.example1.demo;

import com.zahariaca.hibernate.example1.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by Alex on 04.06.2017.
 */
public class DeleteStudentDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // create a session
        Session session = factory.getCurrentSession();

        try {
            int studentID = 4;
            // start a transaction
            session.beginTransaction();

            // retrieve student based on ID
            System.out.println("\nGetting student with id: " + studentID);
            Student student1 = session.get(Student.class, studentID);

            System.out.println("Get complete: " + student1);
            System.out.println("Deleting the student...");

            session.delete(student1);

            // commit transaction
            session.getTransaction().commit();

            // delete all entries that have a last name of Wall
            session = factory.getCurrentSession();
            session.beginTransaction();

            // delete entries
            System.out.println("Deleting all entries that have a last name of Wall");
            session.createQuery("delete from Student where lastName='Wall'")
                    .executeUpdate();

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");

        } finally {
            factory.close();
        }
    }

}
