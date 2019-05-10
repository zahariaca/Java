package com.zahariaca.hibernate.demo.manyToMany;

import com.zahariaca.hibernate.demo.manyToMany.entity.Course;
import com.zahariaca.hibernate.demo.manyToMany.entity.Instructor;
import com.zahariaca.hibernate.demo.manyToMany.entity.InstructorDetail;
import com.zahariaca.hibernate.demo.manyToMany.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author Zaharia Costin-Alexandru (zaharia.c.alexandru@gmail.com) on 05.03.2019
 */
public class CreateCourseAndReviewsDemo {
    public static void main(String[] args) {
        SessionFactory factory= new Configuration()
                                    .configure("hibernate-instructor-manyToMany.cfg.xml")
                                    .addAnnotatedClass(Instructor.class)
                                    .addAnnotatedClass(InstructorDetail.class)
                                    .addAnnotatedClass(Course.class)
                                    .addAnnotatedClass(Review.class)
                                    .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            // begin transaction
            session.beginTransaction();

            // create a course
            Course course = new Course("Pacman - How to score one million points");

            // add some reviews
            course.addReview(new Review("Great course...loved it"));
            course.addReview(new Review("Cool course, job well done"));
            course.addReview(new Review("What a dumb course, you are an idiot"));

            // save the course... and leverage the cascade.all to also save all the reviews
            System.out.println("Saving the course: " + course);
            System.out.println("Saving the course: " + course.getReviews());
            session.save(course);

            // commit transaction
            session.getTransaction().commit();

        } finally {
            session.close();
            factory.close();
        }
    }
}
