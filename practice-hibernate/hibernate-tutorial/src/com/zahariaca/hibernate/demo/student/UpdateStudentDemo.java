package com.zahariaca.hibernate.demo.student;

import com.zahariaca.hibernate.demo.student.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudentDemo {
    public static void main(String[] args) {
        // create the session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // create the session
        Session session = factory.getCurrentSession();

        try {
            int studentId = 1;

            // now get a new session and start transaction
            session =factory.getCurrentSession();
            session.beginTransaction();

            // retrieve student based on the id: primary key
            System.out.println("\nGetting student with id: " + studentId);
            Student myStudent = session.get(Student.class, studentId);

            System.out.println("Updating student: " + myStudent);
            myStudent.setFirstName("Scooby");

            // commit the transaction
            session.getTransaction().commit();


            session = factory.getCurrentSession();
            session.beginTransaction();

            //update email for all students that have lastName='Doe' or firstName='Scooby'
            session.createQuery("UPDATE Student s set s.email='foo@gmail.com' WHERE s.lastName='Doe' OR s.firstName='Scooby'").executeUpdate();

            // commit the transaction
            session.getTransaction().commit();


        } finally {
            factory.close();
        }
    }
}
