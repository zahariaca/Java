package com.zahariaca.hibernate.demo1.employee;

import com.zahariaca.hibernate.demo1.employee.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateEmployeeDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                                    .configure("hibernate-employee.cfg.xml")
                                    .addAnnotatedClass(Employee.class)
                                    .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            // create 1 employee
            System.out.println("Creating one employee object");
            Employee employee = new Employee("Jake", "Polo", "ABC Inc");

            // begin transaction
            session.beginTransaction();

            // save employee
            System.out.println("Saving employee: " + employee);
            session.save(employee);

            // commit transaction
            System.out.println("Committing transaction");
            session.getTransaction().commit();

            // get current session from factory
            session = factory.getCurrentSession();

            // Create 3 more employees
            Employee employee1 = new Employee("Jane", "Marco", "APPL");
            Employee employee2 = new Employee("Andrew", "Mitchel", "MSFT");
            Employee employee3 = new Employee("Mary", "Public", "ABC Inc");


            // begin transaction
            session.beginTransaction();

            // save employees
            System.out.println("Saving employee: " + employee1);
            session.save(employee1);
            System.out.println("Saving employee: " + employee2);
            session.save(employee2);
            System.out.println("Saving employee: " + employee3);
            session.save(employee3);

            // commit transaction
            System.out.println("Committing transaction");
            session.getTransaction().commit();
            System.out.println("Done!");

        } finally {
            factory.close();
        }
    }
}
