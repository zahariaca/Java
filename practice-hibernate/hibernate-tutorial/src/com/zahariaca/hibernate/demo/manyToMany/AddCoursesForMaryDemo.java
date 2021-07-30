package com.zahariaca.hibernate.demo.manyToMany;

import com.zahariaca.hibernate.demo.manyToMany.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author Zaharia Costin-Alexandru (zaharia.c.alexandru@gmail.com) on 10.03.2019
 */
public class AddCoursesForMaryDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate-instructor-manyToMany.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            // begin transaction
            session.beginTransaction();

            // get the student mary from the db
            Student student = session.get(Student.class, 2);

            System.out.println("Got student: " + student);
            System.out.println("Got student with courses: " + student.getCourses());
            // create more courses
            Course course1 = new Course("Rubik's  Cube - How to Speed Cube");
            Course course2 = new Course("Atari 2600 - Game Development");
            Course course3 = new Course("Spring boot");

            // add mary to those courses
            System.out.println("Saving the courses...");
            course1.addStudent(student);
            course2.addStudent(student);
            course3.addStudent(student);
            System.out.println("Save finished");

            // save
            session.save(course1);
            session.save(course2);
            session.save(course3);

            // commit transaction
            session.getTransaction().commit();

        } finally {
            session.close();
            factory.close();
        }
    }
}
