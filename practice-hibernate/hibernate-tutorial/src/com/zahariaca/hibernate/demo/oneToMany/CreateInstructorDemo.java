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
public class CreateInstructorDemo {
    public static void main(String[] args) {
        SessionFactory factory= new Configuration()
                                    .configure("hibernate-instructor-oneToMany.cfg.xml")
                                    .addAnnotatedClass(Instructor.class)
                                    .addAnnotatedClass(InstructorDetail.class)
                                    .addAnnotatedClass(Course.class)
                                    .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            // create the objects
            Instructor tempInstructor2 = new Instructor("Susan", "Public", "susan.public@luv2code.com");
            InstructorDetail tempInstructorDetail2 = new InstructorDetail("http://www.youtube.com", "Gaming");

            // associate the objects
            tempInstructor2.setInstructorDetail(tempInstructorDetail2);

            // begin transaction
            session.beginTransaction();

            // save objects to db
            // NOTE: This will also save the instructorDetails, because CascadeType.ALL.
            System.out.println("Saving instructor: " + tempInstructor2);
            session.save(tempInstructor2);

            // commit transaction
            session.getTransaction().commit();

        } finally {
            session.close();
            factory.close();
        }
    }
}
