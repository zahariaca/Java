package com.zahariaca.springboot.cruddemo.dao;

import com.zahariaca.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    public Employee findById(int id);

    public void save(Employee employee);

    public void deleteById(int id);

    public List<Employee> findAll();
}
