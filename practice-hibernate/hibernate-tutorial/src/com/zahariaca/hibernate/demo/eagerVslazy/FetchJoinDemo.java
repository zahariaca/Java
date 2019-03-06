package com.zahariaca.hibernate.demo.eagerVslazy;

import com.zahariaca.hibernate.demo.eagerVslazy.entity.Course;
import com.zahariaca.hibernate.demo.eagerVslazy.entity.Instructor;
import com.zahariaca.hibernate.demo.eagerVslazy.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

/**
 * @author Zaharia Costin-Alexandru (zaharia.c.alexandru@gmail.com) on 05.03.2019
 */
public class FetchJoinDemo {
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

            // OPTION 2: hibernate query with HQL
            Query<Instructor> query = session.createQuery("SELECT i FROM Instructor i " +
                    "JOIN FETCH i.courses " +
                    "WHERE i.id=:theInstructorId", Instructor.class);
            query.setParameter("theInstructorId", 1);

            Instructor instructor = query.getSingleResult();

            System.out.println("DEBUG: Instructor: " + instructor);

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
