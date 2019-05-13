package com.zahariaca.springboot.cruddemo.rest;

import com.zahariaca.springboot.cruddemo.entity.Employee;
import com.zahariaca.springboot.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // expose "/employees" and return all employees
    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    // add mapping for get by employee id
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId) {
        Employee employee = employeeService.findById(employeeId);

        if (employee == null) {
            throw  new RuntimeException("Employee id not found: " + employeeId);
        }

        return employee;
    }

    // post mapping to add a new employee
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {
        // also just in case they pass an id in JSON, set id to 0
        // this is to force a save of a new item
        employee.setId(0);
        employeeService.save(employee);

        return employee;
    }

    // put method for updating an employee
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        employeeService.save(employee);

        return employee;
    }

    // delete method for deleting an employee
    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId) {
        Employee employee = employeeService.findById(employeeId);

        if (employee == null) {
            throw new RuntimeException("Employee with id " + employeeId + " does not exist");
        }
        employeeService.deleteById(employeeId);

        return "Deleted employee with id: " + employeeId;
    }
 }
