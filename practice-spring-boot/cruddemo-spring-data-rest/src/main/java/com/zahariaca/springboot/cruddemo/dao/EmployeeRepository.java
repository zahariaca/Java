package com.zahariaca.springboot.cruddemo.dao;

import com.zahariaca.springboot.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author Zaharia Costin-Alexandru (zaharia.c.alexandru@gmail.com) on 13.05.2019
 */
@RepositoryRestResource(path="members")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
