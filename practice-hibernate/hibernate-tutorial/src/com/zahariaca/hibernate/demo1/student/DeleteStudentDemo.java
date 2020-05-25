package com.zahariaca.hibernate.demo1.student;

import com.zahariaca.hibernate.demo1.student.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentDemo {
    public static void main(String[] args) {
        // create the session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // create the session
        Session session = factory.getCurrentSession();

        try {
/*            int studentId = 1;

            // now get a new session and start transaction
            session =factory.getCurrentSession();
            session.beginTransaction();

            // retrieve student based on the id: primary key
            System.out.println("\nGetting student with id: " + studentId);
            Student myStudent = session.get(Student.class, studentId);

            // delete the student
            System.out.println("Deleting the student: " + myStudent);
            session.delete(myStudent);

            // commit the transaction
            session.getTransaction().commit();*/

            // now get a new session and start transaction*/
            session =factory.getCurrentSession();
            session.beginTransaction();

            // delete student id=2
            System.out.println("Deleting student with id=2");
            session.createQuery("DELETE FROM Student s where s.id=2").executeUpdate();

            // commit the transaction
            session.getTransaction().commit();

        } finally {
            factory.close();
        }
    }
}
