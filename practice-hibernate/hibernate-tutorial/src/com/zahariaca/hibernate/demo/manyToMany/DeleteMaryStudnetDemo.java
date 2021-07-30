package com.zahariaca.hibernate.demo.manyToMany;

import com.zahariaca.hibernate.demo.manyToMany.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author Zaharia Costin-Alexandru (zaharia.c.alexandru@gmail.com) on 10.03.2019
 */
public class DeleteMaryStudnetDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate-instructor-manyToMany.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            // begin transaction
            session.beginTransaction();

            // get the PacMan course
            Student student = session.get(Student.class, 2);

            System.out.println("Got the student: " + student);
            System.out.println("Got the student with courses: " + student.getCourses());
            //delete the course
            System.out.println("Deleting student..");
            session.delete(student);

            // commit transaction
            session.getTransaction().commit();

        } finally {
            session.close();
            factory.close();
        }
    }
}
