package com.zahariaca.springboot.cruddemo.service;

import com.zahariaca.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public Employee findById(int id);
    public List<Employee> findAll();
    public void save(Employee employee);
    public void deleteById(int id);
}
