package com.example.DynamicSeats.dao;

import com.example.DynamicSeats.dao.Employee;
//import jakarta.persistence.*;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name="departments")
@Entity
@Data

public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy="department", fetch= FetchType.LAZY)
    private List<Employee> employees;

    public Department(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }
    public Department(){}
//    public void addEmployee(Employee employee) {
//        this.employees.add(employee);
//    }
}
