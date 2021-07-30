package com.zahariaca.hibernate.demo.oneToOneUni;

import com.zahariaca.hibernate.demo.oneToOneUni.entity.InstructorDetail;
import com.zahariaca.hibernate.demo.oneToOneUni.entity.Instructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author Zaharia Costin-Alexandru (zaharia.c.alexandru@gmail.com) on 05.03.2019
 */
public class DeleteDemo {
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

            // get the instructor by their id
            Instructor tempInstructor = session.get(Instructor.class, 2);

            System.out.println("Instructor: " + tempInstructor);
            // delete that instructor
            if (tempInstructor != null) {
                System.out.println("Deleting instructor: " + tempInstructor);

                //NOTE: because of CascadeType.ALL this will also delete the instructor_detail associated with this instructor
                session.delete(tempInstructor);
            }

            // commit transaction
            session.getTransaction().commit();
            System.out.println("Done!");

        } finally {
            factory.close();
        }
    }
}
