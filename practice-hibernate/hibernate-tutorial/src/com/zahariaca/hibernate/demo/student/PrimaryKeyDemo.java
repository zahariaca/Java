package com.zahariaca.hibernate.demo.student;

import com.zahariaca.hibernate.demo.student.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {
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
            System.out.println("Creating 3 student objects...");

            // create 3 student objects
            Student student1 = new Student("John", "Doe", "johnd@email.com");
            Student student2 = new Student("Mary", "Public", "maryp@email.com");
            Student student3 = new Student("Bonita", "Applebum", "bonita@email.com");

            // start a transaction
            session.beginTransaction();

            // save the student object
            System.out.println("Saving the student");
            session.save(student1);
            session.save(student2);
            session.save(student3);

            // commit the transaction
            session.getTransaction().commit();
            System.out.println("Done!");

        } finally {
            factory.close();
        }
    }
}
