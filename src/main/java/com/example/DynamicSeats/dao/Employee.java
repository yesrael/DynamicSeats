package com.example.DynamicSeats.dao;

import lombok.Data;

@Data
public class Employee {
    private String name;
    private int employeeId;
    private Department department;

    public Employee(String name, int employeeId, Department department) {
        this.name = name;
        this.employeeId = employeeId;
        this.department = department;
    }
}
