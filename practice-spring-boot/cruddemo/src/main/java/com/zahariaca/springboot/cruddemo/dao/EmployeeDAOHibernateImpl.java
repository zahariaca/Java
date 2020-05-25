package com.zahariaca.springboot.cruddemo.dao;

import com.zahariaca.springboot.cruddemo.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

    // define field for entity manager
    private EntityManager entityManager;

    // setup constructor injection
    @Autowired
    public EmployeeDAOHibernateImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public Employee findById(int id) {
        // get the current hibernate session
        Session session = entityManager.unwrap(Session.class);

        // get the employee
        Employee employee = session.get(Employee.class, id);

        // return employee
        return employee;
    }

    @Override
    public void save(Employee employee) {
        // get the current hibernate session
        Session session = entityManager.unwrap(Session.class);

        // save the employee
        session.saveOrUpdate(employee);
    }

    @Override
    public void deleteById(int id) {
        // get the current hibernate session
        Session session = entityManager.unwrap(Session.class);

        // delete the employee by primary key
        Query<Employee> query = session.createQuery("delete from Employee where id=:employeeId");
        query.setParameter("employeeId", id);

        query.executeUpdate();
    }

    @Override
    public List<Employee> findAll() {

        // get the current hibernate session
        Session session = entityManager.unwrap(Session.class);

        // create a query
        Query<Employee> query = session.createQuery("from Employee", Employee.class);

        // execute query
        List<Employee> employees = query.getResultList();

        // get results
        return employees;
    }
}
