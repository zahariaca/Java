package com.zahariaca.hibernate.demo.employee;

import com.zahariaca.hibernate.demo.employee.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteEmployeeDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                                    .configure("hibernate-employee.cfg.xml")
                                    .addAnnotatedClass(Employee.class)
                                    .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            // Create 2 more employees
            Employee employee1 = new Employee("Delete1", "Marco", "APPL");
            Employee employee2 = new Employee("Delete2", "Mitchel", "MSFT");

            // begin transaction
            session.beginTransaction();

            // save employees
            System.out.println("Saving employee: " + employee1);
            session.save(employee1);
            System.out.println("Saving employee: " + employee2);
            session.save(employee2);

            // commit transaction
            System.out.println("Committing transaction");
            session.getTransaction().commit();

            // get session
            session = factory.getCurrentSession();

            // begin transaction
            session.beginTransaction();

            // delete an employee we got from the db
            Employee tempEmpl = session.get(Employee.class, employee1.getId());
            System.out.println("Got employee: " + tempEmpl);
            System.out.println("Employees before delete: ");
            session.createQuery("FROM Employee").getResultList().stream().map(s-> "    " + s).forEach(System.out::println);
            System.out.println("Deleting employee: " + tempEmpl);
            session.delete(tempEmpl);
            System.out.println("Employees after delete");
            session.createQuery("FROM Employee").getResultList().stream().map(s-> "    " + s).forEach(System.out::println);

            // delete employees with firstName='Delete2'
            session.createQuery("DELETE FROM Employee e WHERE e.firstName='Delete2'").executeUpdate();
            System.out.println("Employees after second delete");
            session.createQuery("FROM Employee").getResultList().stream().map(s-> "    " + s).forEach(System.out::println);

            // commit transaction
            System.out.println("Committing transaction");
            session.getTransaction().commit();
            System.out.println("Done!");

        } finally {
            factory.close();
        }
    }
}
