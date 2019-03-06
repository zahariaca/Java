package com.zahariaca.hibernate.demo.oneToMany;

import com.zahariaca.hibernate.demo.oneToMany.entity.Course;
import com.zahariaca.hibernate.demo.oneToMany.entity.Instructor;
import com.zahariaca.hibernate.demo.oneToMany.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author Zaharia Costin-Alexandru (zaharia.c.alexandru@gmail.com) on 05.03.2019
 */
public class GetInstructorCoursesDemo {
    public static void main(String[] args) {
        SessionFactory factory= new Configuration()
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

            System.out.println("Instructor: " + instructor);
            System.out.println("Courses: " + instructor.getCourses());

            // commit transaction
            session.getTransaction().commit();

        } finally {
            session.close();
            factory.close();
        }
    }
}
