package com.zahariaca.hibernate.demo1.employee;

import com.zahariaca.hibernate.demo1.employee.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateEmployeeDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                                    .configure("hibernate-employee.cfg.xml")
                                    .addAnnotatedClass(Employee.class)
                                    .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            // begin transaction
            session.beginTransaction();

            // update employee with id 1 by getting him and updating the object
            Employee employee = session.get(Employee.class, 1);
            System.out.println("Got employee: " + employee);
            employee.setFirstName("Daffy");

            System.out.println("Get employee from db again");
            employee = session.get(Employee.class, 1);
            System.out.println("Got employee: " + employee);

            // update all employees with company='APPL' to company='APPL Inc'
            System.out.println("update all employees with company='APPL' to company='APPL Inc'");
            session.createQuery("UPDATE Employee e SET e.company='APPL Inc' WHERE e.company='APPL'").executeUpdate();

            session.createQuery("FROM Employee").getResultList().stream().map(s-> "    " + s).forEach(System.out::println);

            // commit transaction
            System.out.println("Committing transaction");
            session.getTransaction().commit();
            System.out.println("Done");

        } finally {
            factory.close();
        }
    }
}
