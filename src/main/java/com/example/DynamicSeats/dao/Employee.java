package com.example.DynamicSeats.dao;


//import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Table(name="employees")
@Entity
@Data

public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String phoneNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;

    public Employee(String name, int employeeId,Department department,
                    String phoneNumber) {
        this.name = name;
        this.department = department;
        this.phoneNumber=phoneNumber;
    }
    public Employee(){

    }
}
