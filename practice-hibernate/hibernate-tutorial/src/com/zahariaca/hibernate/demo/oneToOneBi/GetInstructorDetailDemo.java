package com.zahariaca.hibernate.demo.oneToOneBi;

import com.zahariaca.hibernate.demo.oneToOneBi.entity.Instructor;
import com.zahariaca.hibernate.demo.oneToOneBi.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author Zaharia Costin-Alexandru (zaharia.c.alexandru@gmail.com) on 05.03.2019
 */
public class GetInstructorDetailDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate-instructor.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            // begin transaction
            session.beginTransaction();

            // get the instructor detail
            InstructorDetail instructorDetail = session.get(InstructorDetail.class, 122);

            // print the instructor detail object
            System.out.println("Instructor detail: " + instructorDetail);
            System.out.println("Instructor: " + instructorDetail.getInstructor());

            // commit transaction
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }
    }
}
