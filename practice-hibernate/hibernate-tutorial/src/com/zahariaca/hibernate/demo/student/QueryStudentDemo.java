package com.zahariaca.hibernate.demo.student;

import com.zahariaca.hibernate.demo.student.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudentDemo {
    public static void main(String[] args) {
        // create the session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // create the session
        Session session = factory.getCurrentSession();

        try {

            // start a transaction
            session.beginTransaction();

            // query the students
            System.out.println("\nPrint students");
            List<Student> theStudents = session.createQuery("from Student").getResultList();

            // display the students
            theStudents.stream().map(s -> "    " + s).forEach(System.out::println);


            //query the students with lastName = Doe
            System.out.println("\nPrint students with lastName='Doe'");
            theStudents = session.createQuery("from Student s where s.lastName='Doe'").getResultList();

            // display the students
            theStudents.stream().map(s -> "    " + s).forEach(System.out::println);

            // query students with lastName='Doe' or firstName='Daffy'
            System.out.println("\nPrint students with lastName='Doe' or firstName='Daffy'");
            theStudents = session.createQuery("FROM Student s WHERE s.lastName='Doe' OR s.firstName='Daffy'").getResultList();

            // display the students
            theStudents.stream().map(s -> "    " + s).forEach(System.out::println);

            // query the students with email ending in gmail.com
            System.out.println("\nPrint students with email ending in 'gmail.com'");
            theStudents = session.createQuery("FROM Student s WHERE s.email LIKE '%gmail.com'").getResultList();

            //display the students
            theStudents.stream().map(s -> "    " + s).forEach(System.out::println);

            // commit the transaction
            session.getTransaction().commit();
            System.out.println("Done!");

        } finally {
            factory.close();
        }
    }
}
