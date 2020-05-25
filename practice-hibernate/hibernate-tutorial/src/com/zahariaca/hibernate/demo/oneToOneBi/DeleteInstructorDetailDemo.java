package com.zahariaca.hibernate.demo.oneToOneBi;

import com.zahariaca.hibernate.demo.oneToOneBi.entity.Instructor;
import com.zahariaca.hibernate.demo.oneToOneBi.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author Zaharia Costin-Alexandru (zaharia.c.alexandru@gmail.com) on 05.03.2019
 */
public class DeleteInstructorDetailDemo {
    public static void main(String[] args) {
        SessionFactory factory= new Configuration()
                                    .configure("hibernate-instructor.cfg.xml")
                                    .addAnnotatedClass(Instructor.class)
                                    .addAnnotatedClass(InstructorDetail.class)
                                    .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            // begin transaction
            session.beginTransaction();

            // get the instructor by their id
            InstructorDetail instructorDetail = session.get(InstructorDetail.class, 4);

            System.out.println("Instructor: " + instructorDetail);
            // delete that instructor
            if (instructorDetail != null) {
                System.out.println("Deleting instructorDetail: " + instructorDetail);

                // before delete, when removing only the instructor detail we need to first break the association between the instructor and the instructor detail
                instructorDetail.getInstructor().setInstructorDetail(null);

                //NOTE: because of CascadeType.ALL this will also delete the instructor associated with this instructor_detail
                // without CascadeType.REMOVE, this will only delete the instructor_detail and not the instructor
                session.delete(instructorDetail);
            }

            // commit transaction
            session.getTransaction().commit();
            System.out.println("Done!");

        } finally {
            factory.close();
        }
    }
}
