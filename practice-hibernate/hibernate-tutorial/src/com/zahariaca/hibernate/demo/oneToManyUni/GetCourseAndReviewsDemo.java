package com.zahariaca.hibernate.demo.oneToManyUni;

import com.zahariaca.hibernate.demo.oneToManyUni.entity.Course;
import com.zahariaca.hibernate.demo.oneToManyUni.entity.Instructor;
import com.zahariaca.hibernate.demo.oneToManyUni.entity.InstructorDetail;
import com.zahariaca.hibernate.demo.oneToManyUni.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author Zaharia Costin-Alexandru (zaharia.c.alexandru@gmail.com) on 05.03.2019
 */
public class GetCourseAndReviewsDemo {
    public static void main(String[] args) {
        SessionFactory factory= new Configuration()
                                    .configure("hibernate-instructor-oneToManyUni.cfg.xml")
                                    .addAnnotatedClass(Instructor.class)
                                    .addAnnotatedClass(InstructorDetail.class)
                                    .addAnnotatedClass(Course.class)
                                    .addAnnotatedClass(Review.class)
                                    .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            // begin transaction
            session.beginTransaction();

            // get a course
            Course course = session.get(Course.class, 10);
            System.out.println("DEBUG: " + course);

            // get its reviews lazy
            System.out.println("DEBUG: " + course.getReviews());


            // commit transaction
            session.getTransaction().commit();

        } finally {
            session.close();
            factory.close();
        }
    }
}
