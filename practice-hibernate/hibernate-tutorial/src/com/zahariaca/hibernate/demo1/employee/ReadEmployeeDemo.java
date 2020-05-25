package com.zahariaca.hibernate.demo1.employee;

import com.zahariaca.hibernate.demo1.employee.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ReadEmployeeDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                                    .configure("hibernate-employee.cfg.xml")
                                    .addAnnotatedClass(Employee.class)
                                    .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            // begin transaction
            session.beginTransaction();

            // get employee based on id
            System.out.println("Getting employee with id: " + 1);
            Employee dbEmployee = session.get(Employee.class, 1);
            System.out.println("Got from db -> employee: " + dbEmployee);

            // get all employees
            System.out.println("get all employees");
            List<Employee> employeeList = session.createQuery("FROM Employee").getResultList();
            employeeList.stream().map(s -> "    " + s).forEach(System.out::println);

            // get all employees with lastName='Marco'
            System.out.println("get all employees with lastName='Marco'");
            employeeList = session.createQuery("FROM Employee e WHERE e.lastName='Marco'").getResultList();
            employeeList.stream().map(s -> "    " + s).forEach(System.out::println);

            // get all employees with lastName='Marco' or firstName='Jane'
            System.out.println("get all employees with lastName='Marco' or firstName='Jane'");
            employeeList = session.createQuery("FROM Employee e WHERE e.lastName='Marco' OR e.firstName='Mary'").getResultList();
            employeeList.stream().map(s -> "    " + s).forEach(System.out::println);

            // get all employees with company='ABC Inc'
            System.out.println("get all employees with company='ABC Inc'");
            employeeList = session.createQuery("FROM Employee e WHERE e.company='ABC Inc'").getResultList();
            employeeList.stream().map(s -> "    " + s).forEach(System.out::println);

            // get all employees with company ending in 'Inc'
            System.out.println("get all employees with company ending in 'Inc'");
            employeeList = session.createQuery("FROM Employee e WHERE e.company LIKE '%Inc'").getResultList();
            employeeList.stream().map(s -> "    " + s).forEach(System.out::println);

            // commit transaction
            System.out.println("Committing transaction");
            session.getTransaction().commit();
            System.out.println("Done!");

        } finally {
            factory.close();
        }
    }
}
