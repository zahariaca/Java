package com.zahariaca.backend.model;

import lombok.Data;

@Data
public class Employee {
    private int empId;
    private String name;
    private String designation;
    private double salary;
}
