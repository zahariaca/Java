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
public class CreateCoursesDemo {
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

            // create some courses
            Course course1 = new Course("Air guitar - The ultimate guide");
            Course course2 = new Course("The Pinball Masterclass");

            // add courses to instructor
            instructor.add(course1);
            instructor.add(course2);

            // save the courses
            session.save(course1);
            session.save(course2);

            // commit transaction
            session.getTransaction().commit();

        } finally {
            session.close();
            factory.close();
        }
    }
}
