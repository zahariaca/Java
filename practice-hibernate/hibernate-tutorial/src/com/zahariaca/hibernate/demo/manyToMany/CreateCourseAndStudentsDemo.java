package com.zahariaca.hibernate.demo.manyToMany;

import com.zahariaca.hibernate.demo.manyToMany.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author Zaharia Costin-Alexandru (zaharia.c.alexandru@gmail.com) on 10.03.2019
 */
public class CreateCourseAndStudentsDemo {
    public static void main(String[] args) {
        SessionFactory factory= new Configuration()
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

            // create a course
            Course course = new Course("Pacman - How to score one million points");

            // save the course... and leverage the cascade.all to also save all the reviews
            System.out.println("Saving the course: " + course);
            session.save(course);
            System.out.println("Save complete");

            // create the students
            Student student1 = new Student("John", "Doe", "jd@gmail.com");
            Student student2 = new Student("Mary", "Public", "mp@luv2code.com");

            course.addStudent(student1);
            course.addStudent(student2);

            // save the course... and leverage the cascade.all to also save all the reviews
            System.out.println("Saving the students: " + course.getStudents());
            session.save(student1);
            session.save(student2);
            System.out.println("Save complete");

            // commit transaction
            session.getTransaction().commit();

        } finally {
            session.close();
            factory.close();
        }
    }
}
