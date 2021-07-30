package com.zahariaca.hibernate.demo.eagerVslazy;

import com.zahariaca.hibernate.demo.eagerVslazy.entity.Course;
import com.zahariaca.hibernate.demo.eagerVslazy.entity.Instructor;
import com.zahariaca.hibernate.demo.eagerVslazy.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author Zaharia Costin-Alexandru (zaharia.c.alexandru@gmail.com) on 05.03.2019
 */
public class EagerLazyDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate-instructor-oneToMany.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            // begin transaction
            session.beginTransaction();

            // get instructor from db
            Instructor instructor = session.get(Instructor.class, 1);

            System.out.println("DEBUG: Instructor: " + instructor);

            // Option 1, call getCourses() while the session is still open
            System.out.println("DEBUG: Courses: " + instructor.getCourses());

            // commit transaction
            session.getTransaction().commit();

            System.out.println("\nDEBUG: the session is now closed \n");
            session.close();

            System.out.println("DEBUG: Courses: " + instructor.getCourses());

        } finally {
            session.close();
            factory.close();
        }
    }
}
