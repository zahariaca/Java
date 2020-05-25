package com.zahariaca.hibernate.example1.demo;

import com.zahariaca.hibernate.example1.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by Alex on 04.06.2017.
 */
public class PrimaryKeyDemo {
    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // create a session
        Session session = factory.getCurrentSession();

        try{
            // create the students objects
            System.out.println("Creating 3 new students objects");
            Student student1 = new Student("Bonita", "Applebum", "bonita.applebum@gmail.com");
            Student student2 = new Student("John", "Doe", "jdoe@gmail.com");
            Student student3 = new Student("Mary", "Public", "mary.public@gmail.com");

            // start a transaction
            session.beginTransaction();

            // save the student object
            System.out.println("Saving the student object");
            session.save(student1);
            session.save(student2);
            session.save(student3);


            //commit the transaction
            session.getTransaction().commit();

            System.out.println("Done");
        }finally {
            factory.close();
        }
    }
}
