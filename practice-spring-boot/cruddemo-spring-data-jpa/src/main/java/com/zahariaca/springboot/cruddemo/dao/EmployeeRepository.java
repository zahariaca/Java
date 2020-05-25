package com.zahariaca.springboot.cruddemo.dao;

import com.zahariaca.springboot.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Zaharia Costin-Alexandru (zaharia.c.alexandru@gmail.com) on 13.05.2019
 */
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
