package com.zahariaca.hibernate.demo.oneToOneUni;

import com.zahariaca.hibernate.demo.oneToOneUni.entity.InstructorDetail;
import com.zahariaca.hibernate.demo.oneToOneUni.entity.Instructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author Zaharia Costin-Alexandru (zaharia.c.alexandru@gmail.com) on 05.03.2019
 */
public class CreateDemo {
    public static void main(String[] args) {
        SessionFactory factory= new Configuration()
                                    .configure("hibernate-instructor.cfg.xml")
                                    .addAnnotatedClass(Instructor.class)
                                    .addAnnotatedClass(InstructorDetail.class)
                                    .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            // create the objects
            Instructor tempInstructor = new Instructor("Chad", "Darby", "darby@luv2code.com");
            InstructorDetail tempInstructorDetail = new InstructorDetail("http://luv2code.com/youtube", "Luv 2 code!!!");

            Instructor tempInstructor2 = new Instructor("Madhu", "Patel", "madhu@luv2code.com");
            InstructorDetail tempInstructorDetail2 = new InstructorDetail("http://www.youtube.com", "Guitar");

            // associate the objects
            tempInstructor.setInstructorDetail(tempInstructorDetail);
            tempInstructor2.setInstructorDetail(tempInstructorDetail2);

            // begin transaction
            session.beginTransaction();

            // save objects to db
            // NOTE: This will also save the instructorDetails, because CascadeType.ALL.
            System.out.println("Saving instructor: " + tempInstructor);
            session.save(tempInstructor);
            System.out.println("Saving instructor: " + tempInstructor2);
            session.save(tempInstructor2);

            // commit transaction
            session.getTransaction().commit();

        } finally {
            factory.close();
        }
    }
}
