package com.zahariaca.backend.controllers;

import com.zahariaca.backend.model.Employee;
import com.zahariaca.backend.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/employees")
public class TestController {
    private List<Employee> employeeList = createList();

    @GetMapping(produces = "application/json")
    @RequestMapping("/validateLogin")
    @CrossOrigin(origins = "http://localhost:4200/employees/validateLogin/")
    public User validateLogin() {
        return new User("User successfully authenticated!");
    }

    @RequestMapping(produces = "application/json")
    public List<Employee> firstPage() {
        return employeeList;
    }

    @DeleteMapping(path = "/{id}")
    public Employee delete(@PathVariable("id") int id) {
        Employee deleteEmp = null;
        for (Employee emp : employeeList) {
            if (emp.getEmpId() == id) {
                employeeList.remove(emp);
                deleteEmp = emp;
                break;
            }
        }

        return deleteEmp;
    }

    @PostMapping(path = "/add")
    public Employee create(@RequestBody Employee emp) {
        employeeList.add(emp);
        System.out.println(employeeList);
        return emp;
    }


    private static List<Employee> createList() {
        List<Employee> tempEmployees = new ArrayList<>();
        Employee emp1 = new Employee();
        emp1.setName("emp1");
        emp1.setDesignation("manager");
        emp1.setEmpId(1);
        emp1.setSalary(3000);

        Employee emp2 = new Employee();
        emp2.setName("emp2");
        emp2.setDesignation("developer");
        emp2.setEmpId(2);
        emp2.setSalary(3000);
        tempEmployees.add(emp1);
        tempEmployees.add(emp2);
        return tempEmployees;
    }
}
