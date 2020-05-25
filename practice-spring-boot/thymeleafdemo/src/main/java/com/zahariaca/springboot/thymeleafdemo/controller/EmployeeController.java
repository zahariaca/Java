package com.zahariaca.springboot.thymeleafdemo.controller;

import com.zahariaca.springboot.thymeleafdemo.entity.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @GetMapping("/list")
    public String listEmployees(Model model) {
        Employee employee1 = new Employee(1, "Timothy", "Vergara", "tv@luv2code.com");
        Employee employee2 = new Employee(2, "Marcy", "Banks", "mb@luv2code.com");
        Employee employee3 = new Employee(3, "John", "Wick", "babayaga@luv2code.com");

        List<Employee> list = new ArrayList<>();

        list.add(employee1);
        list.add(employee2);
        list.add(employee3);

        model.addAttribute("employeeList", list);

        return "list-employees";
    }
}
